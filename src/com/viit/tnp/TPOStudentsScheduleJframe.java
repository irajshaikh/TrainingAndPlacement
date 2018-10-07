/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viit.tnp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class TPOStudentsScheduleJframe extends javax.swing.JFrame {

    Connection conn = MySqlConnect.getConnection();
    PreparedStatement pst = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    int tpo_id;
    int dep_id;

    /**
     * Creates new form TPO_students_schedule
     */
    public TPOStudentsScheduleJframe(Integer tpo) {
        initComponents();
        setDefaultCloseOperation(TPOStudentsScheduleJframe.HIDE_ON_CLOSE);
        tpo_id = tpo;
        conn = MySqlConnect.getConnection();
        String Sql = "select d_id from TPO where tpo_id='" + tpo_id + "'";
        try {
            pst = conn.prepareStatement(Sql);
            rs = pst.executeQuery();
            rs.next();
            //System.out.println(rs.getString(1));
            System.out.println(rs.getInt(1));
            dep_id = rs.getInt(1);

        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null, e);
        }
        // jLabel1.setText("Your TPO ID is "+rs.getInt(2));
    }

    public ArrayList<TPOStudentsSchedule> getScheduleList() {
        ArrayList<TPOStudentsSchedule> scheduleList = new ArrayList<TPOStudentsSchedule>();

        String query = "select distinct appearing.stu_id,sch_id,appearing_date from appearing,student,person where student.d_id='" + dep_id + "'";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs1 = st.executeQuery(query);
            TPOStudentsSchedule user;
            while (rs1.next()) {
                user = new TPOStudentsSchedule(rs1.getInt("stu_id"), rs1.getInt("sch_id"), rs1.getDate("appearing_date").toString());//

                scheduleList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleList;
    }

    public void Show_Student_In_JTable() {
        ArrayList<TPOStudentsSchedule> list1 = getScheduleList();
        DefaultTableModel model = (DefaultTableModel) jTable_schedule.getModel();
        Object[] row = new Object[3];
        for (int i = 0; i < list1.size(); i++) {
            row[0] = list1.get(i).getstu_id();
            row[1] = list1.get(i).getsch_id();
            row[2] = list1.get(i).getacad_year();

            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_schedule = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(null);

        jButton1.setText("Show Table");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(220, 160, 130, 40);

        jTable_schedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Schedule ID", "Appearing Date"
            }
        ));
        jScrollPane1.setViewportView(jTable_schedule);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(13, 30, 550, 120);
        jPanel2.add(jLabel1);
        jLabel1.setBounds(-130, 0, 810, 240);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Show_Student_In_JTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TPOStudentsScheduleJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TPOStudentsScheduleJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TPOStudentsScheduleJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TPOStudentsScheduleJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //   new TPO_students_schedule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_schedule;
    // End of variables declaration//GEN-END:variables
}
