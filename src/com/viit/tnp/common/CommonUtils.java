/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viit.tnp.common;

import java.sql.ResultSet;
import java.util.Vector;

public class CommonUtils {

    public static Vector getDepartmentsList() {

        String getDepartmentsQuery = "select distinct(dep_name) from department";

        ResultSet rs;
        Vector departments = new Vector();
        rs = MySqlConnect.executeSelectSQlQuery(getDepartmentsQuery);

        try {
            while (rs.next()) {
                departments.add(rs.getString("dep_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

    public static int getDepartmentIdFromName(String name) {

        String getDepartmentsQuery = "select d_id from department where dep_name='" + name + "'";

        ResultSet rs;
        rs = MySqlConnect.executeSelectSQlQuery(getDepartmentsQuery);
        int id = 0;
        try {
            while (rs.next()) {
                id = rs.getInt("d_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public static int getComapnyIdFromName(String name) {

        String getDepartmentsQuery = "select comp_id from company where co_name='" + name + "'";

        ResultSet rs;
        rs = MySqlConnect.executeSelectSQlQuery(getDepartmentsQuery);
        int id = 0;
        try {
            while (rs.next()) {
                id = rs.getInt("comp_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

}
