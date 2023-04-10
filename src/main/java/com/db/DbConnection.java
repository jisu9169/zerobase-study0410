package com.db;

import com.wifi.BookMarkDataValue;
import com.wifi.DataValue;
import com.wifi.History;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {

    public static void Dbinserto(Connection con, String a1, String a2, String a3,
                                 String a4, String a5, String a6,
                                 String a7, String a8, String a9,
                                 String a10, String a11, String a12,
                                 String a13, String a14, String a15,
                                 String a16) {

        PreparedStatement psmt = null;
        psmt = null;


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
    public static List<DataValue.row> DistanceAlignment(Double lat, Double lnt) throws IOException {
        String updateSql = "UPDATE wifi_info " +
                "SET distance = 6371 * acos(cos(radians(35.192573)) " +
                "             * cos(radians(lat)) " +
                "             * cos(radians(lnt) - radians(126.8061843)) " +
                "             + sin(radians(35.192573)) * sin(radians(lat)))";
        String selectSql = "SELECT * FROM wifi_info " +
                "ORDER BY distance ASC LIMIT 30";
        Connection con = JdbcUtill.getConnection();
        ResultSet rs;
        PreparedStatement psmt = null;

        try {
            psmt = con.prepareStatement(updateSql);
            psmt.executeQuery();
            psmt = null;
            psmt = con.prepareStatement(selectSql);
             rs = psmt.executeQuery();
            ArrayList<DataValue.row> al = new ArrayList();
            while (rs.next()) {
                // 각 레코드에서 필요한 정보를 추출해서 DataValue.row 객체를 생성하고 리스트에 추가하는 작업을 수행
                String distance = String.valueOf(rs.getDouble("distance"));
                String X_SWIFI_MGR_NO = rs.getString("X_SWIFI_MGR_NO");
                String X_SWIFI_WRDOFC = rs.getString("X_SWIFI_WRDOFC");
                String X_SWIFI_MAIN_NM = rs.getString("X_SWIFI_MAIN_NM");
                String X_SWIFI_ADRES1 = rs.getString("X_SWIFI_ADRES1");
                String X_SWIFI_ADRES2 = rs.getString("X_SWIFI_ADRES2");
                String X_SWIFI_INSTL_FLOOR = rs.getString("X_SWIFI_INSTL_FLOOR");
                String X_SWIFI_INSTL_TY = rs.getString("X_SWIFI_INSTL_TY");
                String X_SWIFI_INSTL_MBY = rs.getString("X_SWIFI_INSTL_MBY");
                String X_SWIFI_SVC_SE = rs.getString("X_SWIFI_SVC_SE");
                String X_SWIFI_CMCWR = rs.getString("X_SWIFI_CMCWR");
                String X_SWIFI_CNSTC_YEAR = rs.getString("X_SWIFI_CNSTC_YEAR");
                String X_SWIFI_INOUT_DOOR = rs.getString("X_SWIFI_INOUT_DOOR");
                String X_SWIFI_REMARS3 = rs.getString("X_SWIFI_REMARS3");
                String LAT = rs.getString("LAT");
                String LNT = rs.getString("LNT");
                String WORK_DTTM = rs.getString("WORK_DTTM");

                DataValue.row row = new DataValue.row(distance, X_SWIFI_MGR_NO, X_SWIFI_WRDOFC, X_SWIFI_MAIN_NM, X_SWIFI_ADRES1, X_SWIFI_ADRES2, X_SWIFI_INSTL_FLOOR, X_SWIFI_INSTL_TY, X_SWIFI_INSTL_MBY, X_SWIFI_SVC_SE, X_SWIFI_CMCWR, X_SWIFI_CNSTC_YEAR, X_SWIFI_INOUT_DOOR, X_SWIFI_REMARS3, LAT, LNT, WORK_DTTM);
                al.add(row);
            }
            psmt= null;
            String sql = "INSERT INTO history_info (lat, lnt, search_date) VALUES (?, ?, ?)";

            psmt = con.prepareStatement(sql);
            psmt.setDouble(1,lat);
            psmt.setDouble(2,lnt);
            psmt.setDate(3,new java.sql.Date(System.currentTimeMillis()));
            psmt.executeUpdate();
            JdbcUtill.commit(con);

            JdbcUtill.close(rs);
            JdbcUtill.close(psmt);
            JdbcUtill.close(con);

            return al;
        }catch (SQLException e){
            System.out.println(" 정렬 실패 ");
            throw new RuntimeException(e);

        }
    }

    public static List<History.row> HistoryList() throws IOException {

        String sql = "SELECT * FROM history_info;";
        Connection con = JdbcUtill.getConnection();
        ResultSet rs=null;
        PreparedStatement psmt = null;
        try {
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();
            ArrayList<History.row> al = new ArrayList<>();
            while (rs.next()){
                int id = rs.getInt("id");
                Double LAT = rs.getDouble("LAT");
                Double LNT = rs.getDouble("LNT");
                String search_date =rs.getString("search_date");
                History.row row = new History.row(id,LAT,LNT,search_date);
                al.add(row);
            }


            return al;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            if(rs!=null){
                JdbcUtill.close(rs);
            }
            if(psmt!=null){
                JdbcUtill.close(psmt);
            }
            JdbcUtill.close(con);
        }

    }
    public static void DbDeleteTable(Connection con) throws IOException{
        String deleteSql = "DELETE FROM wifi_info";

        PreparedStatement psmt = null;
        try {
            psmt = con.prepareStatement(deleteSql);
            psmt.executeQuery();
            JdbcUtill.close(psmt);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @SuppressWarnings("SqlDialectInspection")
    public static void DbHistoryDeleteTable(int id) {
        String deleteSql = "DELETE FROM history_info WHERE ID = ?";
        Connection con = JdbcUtill.getConnection();
        PreparedStatement psmt = null;
        try {
            psmt = con.prepareStatement(deleteSql);
            psmt.setInt(1, id);
            psmt.executeQuery();
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (psmt != null) {
                JdbcUtill.close(psmt);
            }
            JdbcUtill.close(con);
        }
    }
    public static void DbBookMarkInsert(String name, String wifiname) {
        String sql = "INSERT INTO bookmark_info " +
                "(bookmark_name, wifi_name) " +
                "VALUES (?, ?)";
        Connection con = JdbcUtill.getConnection();
        PreparedStatement psmt=null;
        try{
            psmt=con.prepareStatement(sql);
            psmt.setString(1,name);
            psmt.setString(2,wifiname);
            psmt.executeQuery();
            con.commit();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            if(psmt != null) {
                JdbcUtill.close(psmt);
            }
            JdbcUtill.close(con);
        }
      }

    public static List<BookMarkDataValue.row> BookMarkList() throws IOException{
        String sql = "SELECT * FROM bookmark_info;";
        Connection con = JdbcUtill.getConnection();
        ResultSet rs = null;
        PreparedStatement psmt = null;

        try {
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();
            ArrayList<BookMarkDataValue.row> al = new ArrayList<>();
            while (rs.next()){
                int id = rs.getInt("id");
                String bookmark_name = rs.getString("bookmark_name");
                String wifi_name = rs.getString("wifi_name");
                int order_num = rs.getInt("order_num");
                String registration_date = rs.getString("registration_date");
                String modification_date = rs.getString("modification_date");
                BookMarkDataValue.row row = new BookMarkDataValue.row(id,bookmark_name, wifi_name, order_num, registration_date, modification_date);
                al.add(row);
            }


            return al;
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            if(rs!=null){
                JdbcUtill.close(rs);
            }
            if(psmt!=null){
                JdbcUtill.close(psmt);
            }
            JdbcUtill.close(con);
        }



    }

    public static void DbBookMarkDelete(int id) {
        String deleteSql = "DELETE FROM bookmark_info WHERE ID = ?";
        Connection con = JdbcUtill.getConnection();
        PreparedStatement psmt = null;
        try {
            psmt = con.prepareStatement(deleteSql);
            psmt.setInt(1, id);
            psmt.executeQuery();
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (psmt != null) {
                JdbcUtill.close(psmt);
            }
            JdbcUtill.close(con);
        }
    }
    public static void DbBookMarkModi(int id, String bookmark_name, int order_num) {
        String sql = "UPDATE bookmark_info SET order_num = ?, bookmark_name = ? WHERE ID = ?";
        Connection con = JdbcUtill.getConnection();
        PreparedStatement psmt = null;
        try {
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, order_num);
            psmt.setString(2, bookmark_name);
            psmt.setInt(3, id);
            psmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (psmt != null) {
                JdbcUtill.close(psmt);
            }
            JdbcUtill.close(con);
        }

    }

}
