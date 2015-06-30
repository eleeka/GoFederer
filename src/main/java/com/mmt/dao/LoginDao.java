package com.mmt.dao;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
  
public class LoginDao {  
    public static String validate(String name) {          
        boolean status = false;  
        Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null;  
  
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "citydescription";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "july";  
        String str=null;
        System.out.println(name);
        try { // System.out.println("in try");
            Class.forName(driver).newInstance();  
            conn = DriverManager  
                    .getConnection(url + dbName, userName, password);  
           // System.out.println("in try 1");
            pst = conn.prepareStatement("select Description from cide where city=?");  
           // System.out.println("in try 2");
            pst.setString(1, name);  
           // System.out.println("in try 3");
            //pst.setString(2, pass);  
  
            rs = pst.executeQuery(); 
            status = rs.next();  
            //System.out.println(status);
           // System.out.println("in try 4");
            str=rs.getString(1);
            //System.out.println("in try 5");
           
            //System.out.println("in try 6");
        } catch (Exception e) {  
            System.out.println(e+"login dao");  
        } finally {  
            if (conn != null) {  
                try {  
                    conn.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (rs != null) {  
                try {  
                    rs.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        return str;  
    }  
}  