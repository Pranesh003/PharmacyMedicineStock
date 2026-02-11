package com.pharmacy.bean;

import java.util.Date;

public class Prescription {
    private int prescriptionID;
    private String medicineID;
    private String patientName;
    private int quantity;
    private Date prescribedDate;
    private String status;

    public int getPrescriptionID() { return prescriptionID; }
    public void setPrescriptionID(int prescriptionID) { this.prescriptionID = prescriptionID; }

    public String getMedicineID() { return medicineID; }
    public void setMedicineID(String medicineID) { this.medicineID = medicineID; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Date getPrescribedDate() { return prescribedDate; }
    public void setPrescribedDate(Date prescribedDate) { this.prescribedDate = prescribedDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
