package com.pharmacy.dao;

import com.pharmacy.bean.Prescription;
import com.pharmacy.util.DBUtil;
import java.sql.*;

public class PrescriptionDAO {

    public int generatePrescriptionID() throws Exception {
        Connection con = DBUtil.getDBConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(
            "SELECT NVL(MAX(PRESCRIPTION_ID),130000)+1 FROM PRESCRIPTION_TBL"
        );
        rs.next();
        return rs.getInt(1);
    }

    public boolean recordPrescription(Prescription p) throws Exception {
        Connection con = DBUtil.getDBConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO PRESCRIPTION_TBL VALUES(?,?,?,?,?,?)"
        );
        ps.setInt(1, p.getPrescriptionID());
        ps.setString(2, p.getMedicineID());
        ps.setString(3, p.getPatientName());
        ps.setInt(4, p.getQuantity());
        ps.setDate(5, new java.sql.Date(p.getPrescribedDate().getTime()));
        ps.setString(6, p.getStatus());
        return ps.executeUpdate() > 0;
    }

    public boolean cancelPrescription(int prescriptionID) throws Exception {
        Connection con = DBUtil.getDBConnection();
        PreparedStatement ps = con.prepareStatement(
            "UPDATE PRESCRIPTION_TBL SET STATUS='CANCELLED' WHERE PRESCRIPTION_ID=?"
        );
        ps.setInt(1, prescriptionID);
        return ps.executeUpdate() > 0;
    }
}
