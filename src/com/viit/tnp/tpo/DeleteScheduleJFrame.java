/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viit.tnp.tpo;

import com.viit.tnp.common.MySqlConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DeleteScheduleJFrame extends javax.swing.JFrame {
    
    Connection conn = MySqlConnect.getConnection();
    
    boolean isEligible = false;
    String scheduleDateString;
    DefaultComboBoxModel comboModel;
    
    public DeleteScheduleJFrame() {
        setDefaultCloseOperation(DeleteScheduleJFrame.HIDE_ON_CLOSE);
        getCompaniesList();
        initComponents();
        jTable_schedule.getTableHeader().setReorderingAllowed(false);
        labelSalaryError.setVisible(false);
        labelScheduleIdError.setVisible(false);
    }
    
    private boolean validateScheduleId() {
        boolean isValid = true;
        labelScheduleIdError.setVisible(false);
        String scheduleInput = textFieldSchId.getText();
        
        if (scheduleInput.length() == 0) {
            labelScheduleIdError.setVisible(true);
            labelScheduleIdError.setText("Required");
            isValid = false;
        } else {
            try {
                Integer.parseInt(scheduleInput);
            } catch (Exception e) {
                isValid = false;
                labelScheduleIdError.setVisible(true);
                labelScheduleIdError.setText("Should be integer");
            }
        }
        return isValid;
    }
    
    private boolean validateMinSalary() {
        boolean isValid = true;
        String salaryInput = searchMinSalary.getText();
        labelSalaryError.setVisible(false);
        if (salaryInput.length() != 0) {
            try {
                Integer.parseInt(salaryInput);
            } catch (Exception e) {
                isValid = false;
                labelSalaryError.setVisible(true);
                labelSalaryError.setText("Should be integer");
            }
        }
        return isValid;
    }
//    Get companies for which this TPO has created schedules

    public void getCompaniesList() {
        
        String query1 = "select distinct(co_name) from company";
        
        Statement st;
        ResultSet rs;
        Vector companies = new Vector();

//      Add a default blank entry
        companies.add("Any");
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query1);
            
            while (rs.next()) {
                companies.add(rs.getString("co_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        comboModel = new DefaultComboBoxModel(companies);
    }
    
    public ArrayList<Schedule> getScheduleList() {
        ArrayList<Schedule> scheduleList = new ArrayList<Schedule>();
        
        String companyNameQuery = "", minSalaryQuery = "";
        String getSchedulesQuery = "select * from schedule_company_view ";
        
        if (searchCompany.getSelectedIndex() != 0 && searchCompany.getSelectedItem().toString().length() > 0) {
            companyNameQuery += " schedule_company_view.co_name = '" + searchCompany.getSelectedItem().toString() + "'";
        }
        
        if (searchMinSalary.getText().length() > 0) {
            minSalaryQuery += " min_salary >= " + Integer.parseInt(searchMinSalary.getText());
        }
        
        if (companyNameQuery.length() != 0 && minSalaryQuery.length() != 0) {
            getSchedulesQuery += " where " + companyNameQuery + " and " + minSalaryQuery;
        } else if (companyNameQuery.length() != 0) {
            getSchedulesQuery += " where " + companyNameQuery;
        } else if (minSalaryQuery.length() != 0) {
            getSchedulesQuery += " where " + minSalaryQuery;
        }
        
        Statement st;
        ResultSet rs;
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(getSchedulesQuery);
            Schedule user;
            while (rs.next()) {
                user = new Schedule(rs.getInt("sch_id"),
                        rs.getDate("sch_date").toString(),
                        rs.getInt("comp_id"), rs.getString("co_name"),
                        rs.getInt("criteria"), rs.getInt("min_salary"));
                
                scheduleList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleList;
    }
    
    public void showScheduleTable() {
        
        ArrayList<Schedule> list1 = getScheduleList();
        DefaultTableModel model = (DefaultTableModel) jTable_schedule.getModel();
        
        for (int index = 0; index < model.getRowCount();) {
            model.removeRow(index);
        }
        
        Object[] row = new Object[6];
        for (int i = 0; i < list1.size(); i++) {
            row[0] = list1.get(i).getschid();
            row[1] = list1.get(i).getschdate();
            row[2] = list1.get(i).getcompid();
            row[3] = list1.get(i).getconame();
            row[4] = list1.get(i).getcriteria();
            row[5] = list1.get(i).getminsalary();
            
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
        scheduleIdLabel = new javax.swing.JLabel();
        searchMinSalary = new javax.swing.JTextField();
        scrollPaneScheduleTable = new javax.swing.JScrollPane();
        jTable_schedule = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchCompany = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        textFieldSchId = new javax.swing.JTextField();
        deleteButtonPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        searchButtonPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        labelSalaryError = new javax.swing.JLabel();
        labelScheduleIdError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Delete schedule");

        jPanel2.setBackground(new java.awt.Color(37, 46, 65));
        jPanel2.setLayout(null);

        scheduleIdLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        scheduleIdLabel.setForeground(java.awt.Color.white);
        scheduleIdLabel.setText("Schedule ID :");
        jPanel2.add(scheduleIdLabel);
        scheduleIdLabel.setBounds(180, 450, 130, 30);

        searchMinSalary.setBackground(new java.awt.Color(37, 46, 65));
        searchMinSalary.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        searchMinSalary.setForeground(java.awt.Color.white);
        searchMinSalary.setBorder(null);
        searchMinSalary.setCaretColor(java.awt.Color.white);
        searchMinSalary.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchMinSalaryKeyReleased(evt);
            }
        });
        jPanel2.add(searchMinSalary);
        searchMinSalary.setBounds(650, 70, 145, 30);

        jTable_schedule.setBackground(new java.awt.Color(36, 47, 65));
        jTable_schedule.setForeground(new java.awt.Color(255, 255, 255));
        jTable_schedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Schedule ID", "Schedule Date", "Company ID", "Company Name", "Criteria", "Minimum Salary"
            }
        ));
        scrollPaneScheduleTable.setViewportView(jTable_schedule);

        jPanel2.add(scrollPaneScheduleTable);
        scrollPaneScheduleTable.setBounds(50, 180, 760, 230);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Search schedules");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(290, 20, 270, 22);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Company name: ");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(50, 60, 151, 30);

        searchCompany.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        searchCompany.setModel(comboModel);
        searchCompany.setBorder(null);
        jPanel2.add(searchCompany);
        searchCompany.setBounds(220, 60, 180, 32);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Minimum salary:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(470, 70, 146, 30);

        textFieldSchId.setBackground(new java.awt.Color(37, 46, 65));
        textFieldSchId.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        textFieldSchId.setForeground(java.awt.Color.white);
        textFieldSchId.setBorder(null);
        textFieldSchId.setCaretColor(java.awt.Color.white);
        textFieldSchId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldSchIdKeyReleased(evt);
            }
        });
        jPanel2.add(textFieldSchId);
        textFieldSchId.setBounds(330, 450, 145, 30);

        deleteButtonPanel.setBackground(new java.awt.Color(97, 212, 195));
        deleteButtonPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButtonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonPanelMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(36, 47, 65));
        jLabel4.setText("Delete");

        javax.swing.GroupLayout deleteButtonPanelLayout = new javax.swing.GroupLayout(deleteButtonPanel);
        deleteButtonPanel.setLayout(deleteButtonPanelLayout);
        deleteButtonPanelLayout.setHorizontalGroup(
            deleteButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteButtonPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        deleteButtonPanelLayout.setVerticalGroup(
            deleteButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(deleteButtonPanel);
        deleteButtonPanel.setBounds(530, 440, 110, 45);

        searchButtonPanel.setBackground(new java.awt.Color(97, 212, 195));
        searchButtonPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchButtonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonPanelMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(36, 47, 65));
        jLabel5.setText("Search");

        javax.swing.GroupLayout searchButtonPanelLayout = new javax.swing.GroupLayout(searchButtonPanel);
        searchButtonPanel.setLayout(searchButtonPanelLayout);
        searchButtonPanelLayout.setHorizontalGroup(
            searchButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchButtonPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        searchButtonPanelLayout.setVerticalGroup(
            searchButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchButtonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jPanel2.add(searchButtonPanel);
        searchButtonPanel.setBounds(370, 120, 100, 45);
        jPanel2.add(jSeparator3);
        jSeparator3.setBounds(330, 480, 150, 10);
        jPanel2.add(jSeparator4);
        jSeparator4.setBounds(650, 100, 150, 10);

        labelSalaryError.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelSalaryError.setForeground(new java.awt.Color(230, 49, 29));
        labelSalaryError.setText("minSalaryError");
        jPanel2.add(labelSalaryError);
        labelSalaryError.setBounds(570, 110, 270, 21);

        labelScheduleIdError.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelScheduleIdError.setForeground(new java.awt.Color(230, 49, 29));
        labelScheduleIdError.setText("scheduleError");
        jPanel2.add(labelScheduleIdError);
        labelScheduleIdError.setBounds(290, 500, 270, 21);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteSchedule() {
        String scheduleId = textFieldSchId.getText();
        String deleteScheduleQuery = "delete from schedule where "
                + "sch_id=" + scheduleId;
        boolean deleteSuccess = false;
        try {
            deleteSuccess = MySqlConnect.executeUpdateSQlQuery(deleteScheduleQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (deleteSuccess) {
            JOptionPane.showMessageDialog(null, "Deleted the schedule");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Unable to delete schedule", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void deleteButtonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonPanelMouseClicked
        if ( validateScheduleId()) {
            deleteSchedule();
        }
    }//GEN-LAST:event_deleteButtonPanelMouseClicked

    private void searchButtonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonPanelMouseClicked
        if (validateMinSalary()) {
            showScheduleTable();
        }
    }//GEN-LAST:event_searchButtonPanelMouseClicked

    private void searchMinSalaryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchMinSalaryKeyReleased
        validateMinSalary();
    }//GEN-LAST:event_searchMinSalaryKeyReleased

    private void textFieldSchIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldSchIdKeyReleased
        validateScheduleId();
    }//GEN-LAST:event_textFieldSchIdKeyReleased

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
            java.util.logging.Logger.getLogger(DeleteScheduleJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteScheduleJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteScheduleJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteScheduleJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Register_schedule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel deleteButtonPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable_schedule;
    private javax.swing.JLabel labelSalaryError;
    private javax.swing.JLabel labelScheduleIdError;
    private javax.swing.JLabel scheduleIdLabel;
    private javax.swing.JScrollPane scrollPaneScheduleTable;
    private javax.swing.JPanel searchButtonPanel;
    private javax.swing.JComboBox<String> searchCompany;
    private javax.swing.JTextField searchMinSalary;
    private javax.swing.JTextField textFieldSchId;
    // End of variables declaration//GEN-END:variables
}
