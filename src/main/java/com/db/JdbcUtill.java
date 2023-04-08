package com.db;

import java.sql.*;

public class JdbcUtill {
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/wifiinfo";
    private static final String DB_ID = "root";
    private static final String DB_PASSWORD = "1234";
    private static final String DRIVER = "org.mariadb.jdbc.Driver";


    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            System.out.println(" 드라이버 로드 실패");
        }
        Connection con = null;

        try {
            con = DriverManager.getConnection(DB_URL, DB_ID, DB_PASSWORD);
            System.out.println("연결 성공");
            con.setAutoCommit(false);

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(" 연결 실패 ");
        }
        return con;


    }

    public static boolean isConnetcion(Connection con) {
        boolean valid = true;

        try {
            if(con == null || con.isClosed()){
                valid = false;
            }

        }catch ( SQLException e) {
            valid = true;
            e.printStackTrace();
        }

        return valid;
    }

    public static void close(Connection con) {
        if(isConnetcion(con)){
            try {
                con.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement stmt) {
        if(stmt != null) {
            try{
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs) {
        if(rs != null) {
            try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void commit (Connection con) {
        if(isConnetcion(con)){
            try{
                con.commit();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void rollback(Connection con) {
        if(isConnetcion(con)) {
            try{
                con.rollback();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }




}
