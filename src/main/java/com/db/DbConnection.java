package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnection {

    public static void Dbinserto(Connection con, String a1, String a2, String a3,
                                 String a4, String a5, String a6,
                                 String a7, String a8, String a9,
                                 String a10, String a11, String a12,
                                 String a13, String a14, String a15,
                                 String a16) {

        PreparedStatement psmt = null;



        String sql = "INSERT INTO wifi_info(" +
                "X_SWIFI_MGR_NO, " +
                "X_SWIFI_WRDOFC, " +
                "X_SWIFI_MAIN_NM, " +
                "X_SWIFI_ADRES1, " +
                "X_SWIFI_ADRES2, " +
                "X_SWIFI_INSTL_FLOOR, " +
                "X_SWIFI_INSTL_TY, " +
                "X_SWIFI_INSTL_MBY, " +
                "X_SWIFI_SVC_SE, " +
                "X_SWIFI_CMCWR, " +
                "X_SWIFI_CNSTC_YEAR, " +
                "X_SWIFI_INOUT_DOOR," +
                " X_SWIFI_REMARS3, " +
                "LAT, " +
                "LNT, " +
                "WORK_DTTM) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int rowsAffected = 0;

        try {

            psmt = con.prepareStatement(sql);

            psmt.setString(1, a1);
            psmt.setString(2, a2);
            psmt.setString(3, a3);
            psmt.setString(4, a4);
            psmt.setString(5, a5);
            psmt.setString(6, a6);
            psmt.setString(7, a7);
            psmt.setString(8, a8);
            psmt.setString(9, a9);
            psmt.setString(10, a10);
            psmt.setString(11, a11);
            psmt.setString(12, a12);
            psmt.setString(13, a13);
            psmt.setDouble(14, Double.parseDouble(a14));
            psmt.setDouble(15, Double.parseDouble(a15));
            psmt.setString(16, a16);




            rowsAffected = psmt.executeUpdate();
            JdbcUtill.commit(con);
            JdbcUtill.close(psmt);

        } catch (SQLException e) {
            System.out.println(" 저장 실패 ");
            throw new RuntimeException(e);

        }

            System.out.println(rowsAffected + " row(s) inserted successfully");






    }
}
