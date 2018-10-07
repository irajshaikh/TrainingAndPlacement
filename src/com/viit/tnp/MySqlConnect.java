/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viit.tnp;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author iraj
 */
public class MySqlConnect {

    private static Connection conn = null;

//    Singleton design pattern
    public static Connection getConnection() {
        if (conn != null) {
            return conn;
        }
        return connectDB();
    }

    private static Connection connectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/TNP?useSSL=false", "tnp-admin", "Password@18");
            return dbConn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public static boolean executeUpdateSQlQuery(String query) {
        Statement st;
        try {
            st = getConnection().createStatement();
            if ((st.executeUpdate(query)) == 1) {
//                Query executed successfully
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
