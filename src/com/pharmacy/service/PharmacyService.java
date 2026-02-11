package com.pharmacy.service;

import com.pharmacy.bean.*;
import com.pharmacy.dao.*;
import com.pharmacy.util.*;
import java.sql.Connection;
import java.util.Date;

public class PharmacyService {

    MedicineDAO medicineDAO = new MedicineDAO();
    PrescriptionDAO prescriptionDAO = new PrescriptionDAO();

    public boolean issuePrescription(String medicineID, String patientName,
                                     int quantity, Date date)
            throws Exception {

        if (medicineID == null || patientName == null || quantity <= 0)
            throw new ValidationException();

        Medicine med = medicineDAO.findMedicine(medicineID);
        if (med == null) return false;

        if (med.getExpiryDate().before(date))
            throw new ValidationException();

        if (quantity > med.getAvailableStock())
            throw new OutOfStockException();

        Connection con = DBUtil.getDBConnection();
        try {
            medicineDAO.updateAvailableStock(
                medicineID, med.getAvailableStock() - quantity);

            Prescription p = new Prescription();
            p.setPrescriptionID(prescriptionDAO.generatePrescriptionID());
            p.setMedicineID(medicineID);
            p.setPatientName(patientName);
            p.setQuantity(quantity);
            p.setPrescribedDate(date);
            p.setStatus("ISSUED");

            prescriptionDAO.recordPrescription(p);
            con.commit();
            return true;
        } catch (Exception e) {
            con.rollback();
            return false;
        }
    }

    public boolean cancelPrescription(int prescriptionID) throws Exception {
        if (prescriptionID <= 0)
            throw new ValidationException();
        return prescriptionDAO.cancelPrescription(prescriptionID);
    }
}
