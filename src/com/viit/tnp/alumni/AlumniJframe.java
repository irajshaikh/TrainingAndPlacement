package com.viit.tnp.alumni;

import com.viit.tnp.common.MySqlConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class AlumniJframe extends javax.swing.JFrame {

    Connection conn = MySqlConnect.getConnection();
    PreparedStatement pst = null;
    ResultSet rs = null;
    int year;
    String year1;
    int tpo_id;
    int dep_id;

    public AlumniJframe(Integer tpo) {
        initComponents();
        setDefaultCloseOperation(AlumniJframe.HIDE_ON_CLOSE);
        tpo_id = tpo;
    }

    public ArrayList<Alumni> getAlumniList(String year) {
        ArrayList<Alumni> alumniList = new ArrayList<Alumni>();

        String query = "select cand_id,fname,schedule_company_view.co_name,"
                + "designation,package,candidate.sch_id,candidate.stu_id "
                + "from candidate,student,person,schedule_company_view"
                + " where candidate.stu_id=student.stu_id and"
                + " schedule_company_view.sch_id=candidate.sch_id and person.p_id=student.p_id "
                + "and year(academic_year)='" + year + "'";

        Statement st;
        ResultSet rs = null;

        try {
            st = conn.createStatement();
            String cba = jComboBox1.getSelectedItem().toString();
            if (cba == "2010" || cba == "2011" || cba == "2012"
                    || cba == "2013" || cba == "2014" || cba == "2015"
                    || cba == "2016" || cba == "2017") {
                rs = st.executeQuery(query);
            }

            Alumni alumni;
            while (rs.next()) {
                alumni = new Alumni(rs.getInt("cand_id"), rs.getString("fname"),
                        rs.getString("co_name"), rs.getString("designation"),
                        rs.getString("package"), rs.getInt("sch_id"),
                        rs.getInt("stu_id"));

                alumniList.add(alumni);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alumniList;
    }

    public void ShowAlumniByYear(String year) {
        ArrayList<Alumni> list1 = getAlumniList(year);
        DefaultTableModel model = (DefaultTableModel) jTable_alumni.getModel();
        Object[] row = new Object[7];
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        for (int i = 0; i < list1.size(); i++) {
            row[0] = list1.get(i).getCandidateId();
            row[1] = list1.get(i).getName();
            row[2] = list1.get(i).getCompany();
            row[3] = list1.get(i).getDesignation();
            row[4] = list1.get(i).getPackage();
            row[5] = list1.get(i).getScheduleId();
            row[6] = list1.get(i).getStudentId();

            model.addRow(row);
        }
    }

    public ArrayList<Alumni> getAllAlumniList() throws SQLException {
        ArrayList<Alumni> alumniList = new ArrayList<Alumni>();

        String query1 = "select cand_id,fname,schedule_company_view.co_name,"
                + "designation,package,candidate.sch_id,candidate.stu_id "
                + "from candidate,student,person,schedule_company_view where "
                + "candidate.stu_id=student.stu_id and "
                + "schedule_company_view.sch_id=candidate.sch_id and"
                + " person.p_id=student.p_id order by cand_id";

        Statement st;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query1);
            Alumni alumni;
            while (rs.next()) {
                alumni = new Alumni(rs.getInt("cand_id"),
                        rs.getString("fname"), rs.getString("co_name"),
                        rs.getString("designation"), rs.getString("package"),
                        rs.getInt("sch_id"), rs.getInt("stu_id"));//

                alumniList.add(alumni);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alumniList;
    }

    public void ShowAlumniInJtable() throws SQLException {
        ArrayList<Alumni> list1 = getAllAlumniList();
        DefaultTableModel model = (DefaultTableModel) jTable_alumni.getModel();
        Object[] row = new Object[7];
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        for (int i = 0; i < list1.size(); i++) {
            row[0] = list1.get(i).getCandidateId();
            row[1] = list1.get(i).getName();
            row[2] = list1.get(i).getCompany();
            row[3] = list1.get(i).getDesignation();
            row[4] = list1.get(i).getPackage();
            row[5] = list1.get(i).getScheduleId();
            row[6] = list1.get(i).getStudentId();

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
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_alumni = new javax.swing.JTable();
        loginButtonPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Placed students");

        jPanel2.setBackground(new java.awt.Color(36, 47, 65));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Academic Year : ");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(90, 30, 230, 29);

        jComboBox1.setBackground(new java.awt.Color(36, 47, 65));
        jComboBox1.setForeground(java.awt.Color.white);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017" }));
        jComboBox1.setToolTipText("");
        jComboBox1.setBorder(null);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(360, 30, 216, 30);

        jTable_alumni.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Candidate ID", "First Name", "Company", "Designation", "Package", "Schedule ID", "Student ID"
            }
        ));
        jScrollPane1.setViewportView(jTable_alumni);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 80, 860, 118);

        loginButtonPanel.setBackground(new java.awt.Color(97, 212, 195));
        loginButtonPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButtonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButtonPanelMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(36, 47, 65));
        jLabel3.setText("Show all");

        javax.swing.GroupLayout loginButtonPanelLayout = new javax.swing.GroupLayout(loginButtonPanel);
        loginButtonPanel.setLayout(loginButtonPanelLayout);
        loginButtonPanelLayout.setHorizontalGroup(
            loginButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginButtonPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginButtonPanelLayout.setVerticalGroup(
            loginButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginButtonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPanel2.add(loginButtonPanel);
        loginButtonPanel.setBounds(380, 230, 120, 45);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 886, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        year = Integer.parseInt(jComboBox1.getSelectedItem().toString());
        year1 = (jComboBox1.getSelectedItem().toString());
        ShowAlumniByYear(year1);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void loginButtonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonPanelMouseClicked
        try {
            ShowAlumniInJtable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_loginButtonPanelMouseClicked

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
            java.util.logging.Logger.getLogger(AlumniJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlumniJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlumniJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlumniJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new alumni().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_alumni;
    private javax.swing.JPanel loginButtonPanel;
    // End of variables declaration//GEN-END:variables
}
