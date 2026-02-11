package com.pharmacy.dao;

import com.pharmacy.bean.Medicine;
import com.pharmacy.util.DBUtil;
import java.sql.*;

public class MedicineDAO {

    public Medicine findMedicine(String medicineID) throws Exception {
        Connection con = DBUtil.getDBConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM MEDICINE_TBL WHERE MEDICINE_ID=?"
        );
        ps.setString(1, medicineID);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Medicine m = new Medicine();
            m.setMedicineID(rs.getString(1));
            m.setName(rs.getString(2));
            m.setBatchNo(rs.getString(3));
            m.setTotalStock(rs.getInt(4));
            m.setAvailableStock(rs.getInt(5));
            m.setExpiryDate(rs.getDate(6));
            return m;
        }
        return null;
    }

    public boolean updateAvailableStock(String medicineID, int stock) throws Exception {
        Connection con = DBUtil.getDBConnection();
        PreparedStatement ps = con.prepareStatement(
            "UPDATE MEDICINE_TBL SET AVAILABLE_STOCK=? WHERE MEDICINE_ID=?"
        );
        ps.setInt(1, stock);
        ps.setString(2, medicineID);
        return ps.executeUpdate() > 0;
    }
}
