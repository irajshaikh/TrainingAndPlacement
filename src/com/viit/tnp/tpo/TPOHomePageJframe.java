/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viit.tnp.tpo;

import com.viit.tnp.alumni.AlumniJframe;
import com.viit.tnp.company.Company;
import com.viit.tnp.company.RegisterCompanyJframe;
import com.viit.tnp.common.MySqlConnect;
import com.viit.tnp.report.ReportDepartmentWiseJframe;
import com.viit.tnp.report.ReportCompanywiseJframe;
import com.viit.tnp.common.EditProfileJframe;
import com.viit.tnp.login.LoginJframe;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TPOHomePageJframe extends javax.swing.JFrame {

    String username;
    int tpoId;
    int personId;

    public TPOHomePageJframe(String Username) throws SQLException {
        initComponents();
        username = Username;

        String getTPOPersonIdFromUsernameQuery = "select * from tpo_person_view where username='" + username + "'";
        ResultSet rs = MySqlConnect.executeSelectSQlQuery(getTPOPersonIdFromUsernameQuery);
        if (rs != null) {
            rs.next();
            tpoId = rs.getInt(2);
            tpoIdValue.setText(tpoId + "");
            personId = rs.getInt(3);
        }
        setDefaultCloseOperation(TPOHomePageJframe.HIDE_ON_CLOSE);
        labelTitle.setText("Welcome " + username + "!");
        panelCompanyTable.setVisible(false);
        panelScheduleTable.setVisible(false);
        labelWelcomeIcon.setVisible(true);

        String getDepartmentNameQuery = "select dep_name from department,TPO where"
                + " TPO.d_id=department.d_id and TPO.tpo_id=" + tpoId;
        rs = null;
        try {
            rs = MySqlConnect.executeSelectSQlQuery(getDepartmentNameQuery);
            rs.next();

            String departmentName = rs.getString("dep_name");
            departIdValue.setText(departmentName);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public ArrayList<Company> getCompanyList() {
        ArrayList<Company> companiesList = new ArrayList<Company>();

        String getCompaniesQuery = "SELECT * FROM  `company` ";
        ResultSet rs = MySqlConnect.executeSelectSQlQuery(getCompaniesQuery);
        try {
            if (rs != null) {
                Company company;
                while (rs.next()) {
                    company = new Company(rs.getInt("comp_id"),
                            rs.getString("co_name"),
                            rs.getString("type"));
                    companiesList.add(company);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companiesList;
    }

    public void showCompanyInJTable() {
        ArrayList<Company> list = getCompanyList();
        DefaultTableModel model = (DefaultTableModel) jTable_company.getModel();

        for (int index = 0; index < model.getRowCount();) {
            model.removeRow(index);
        }

        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getComp_id();
            row[1] = list.get(i).getCompanyName();
            row[2] = list.get(i).getType();

            model.addRow(row);
        }
    }

    public ArrayList<Schedule> getScheduleList() {
        ArrayList<Schedule> scheduleList = new ArrayList<Schedule>();

        String query = "SELECT * FROM  `schedule_company_view` "
                + "where tpo_id='" + tpoId + "' and active=1";
        ResultSet rs = MySqlConnect.executeSelectSQlQuery(query);
        try {
            Schedule schedule;
            while (rs.next()) {
                schedule = new Schedule(rs.getInt("sch_id"),
                        rs.getDate("sch_date").toString(),
                        rs.getInt("comp_id"), rs.getString("co_name"),
                        rs.getInt("criteria"), rs.getInt("min_salary"));

                scheduleList.add(schedule);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleList;
    }

    public void showScheduleInJTable() {
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

        jPanel1 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        panelCompanyTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_company = new javax.swing.JTable();
        labelWelcomeIcon = new javax.swing.JLabel();
        panelScheduleTable = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_schedule = new javax.swing.JTable();
        labelTitle = new javax.swing.JLabel();
        tpoIdValue = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        departIdValue = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCompany = new javax.swing.JMenu();
        menuItemCompanyDetail = new javax.swing.JMenuItem();
        menuItemRegisterCompany = new javax.swing.JMenuItem();
        menuSchedule = new javax.swing.JMenu();
        menuItemScheduleDetails = new javax.swing.JMenuItem();
        menuItemCreateSchedule = new javax.swing.JMenuItem();
        menuItemDeleteSchedule = new javax.swing.JMenuItem();
        menuStudent = new javax.swing.JMenu();
        menuItemStudentDetails = new javax.swing.JMenuItem();
        jmenuItemRegisteredStudents = new javax.swing.JMenuItem();
        menuAlumni = new javax.swing.JMenu();
        menuItemRecruitedStudents = new javax.swing.JMenuItem();
        menuReport = new javax.swing.JMenu();
        menuItemDepartmentWise = new javax.swing.JMenuItem();
        menuItemCompanyWise = new javax.swing.JMenuItem();
        menuItemYearWise = new javax.swing.JMenuItem();
        menuProfile = new javax.swing.JMenu();
        menuItemEdit = new javax.swing.JMenuItem();
        menuMore = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");

        jPanel1.setBackground(new java.awt.Color(37, 46, 65));

        panelCompanyTable.setBackground(new java.awt.Color(37, 46, 65));
        panelCompanyTable.setForeground(new java.awt.Color(249, 231, 231));
        panelCompanyTable.setLayout(null);

        jTable_company.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Company ID", "Company Name", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_company.getTableHeader().setResizingAllowed(false);
        jTable_company.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable_company);

        panelCompanyTable.add(jScrollPane1);
        jScrollPane1.setBounds(10, 60, 850, 250);

        labelWelcomeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/regStepSideTPO.png"))); // NOI18N

        panelScheduleTable.setBackground(new java.awt.Color(37, 46, 65));
        panelScheduleTable.setForeground(new java.awt.Color(249, 231, 231));
        panelScheduleTable.setLayout(null);

        jTable_schedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Schedule ID", "Schedule Date", "Company ID", "Company Name", "Criteria", "Min Salary"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_schedule.getTableHeader().setResizingAllowed(false);
        jTable_schedule.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable_schedule);

        panelScheduleTable.add(jScrollPane2);
        jScrollPane2.setBounds(10, 60, 850, 250);

        jLayeredPane1.setLayer(panelCompanyTable, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(labelWelcomeIcon, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(panelScheduleTable, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(labelWelcomeIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(344, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelCompanyTable, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelScheduleTable, javax.swing.GroupLayout.PREFERRED_SIZE, 881, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(labelWelcomeIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelCompanyTable, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(43, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelScheduleTable, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(31, Short.MAX_VALUE)))
        );

        labelTitle.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(255, 255, 255));
        labelTitle.setText("Title");

        tpoIdValue.setForeground(new java.awt.Color(239, 229, 229));
        tpoIdValue.setText("tpo_id");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(237, 223, 223));
        jLabel1.setText("TPO id :");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(237, 223, 223));
        jLabel3.setText("Department :");

        departIdValue.setForeground(new java.awt.Color(229, 214, 214));
        departIdValue.setText("dept_Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(66, 66, 66)
                        .addComponent(tpoIdValue))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(departIdValue)))
                .addGap(133, 133, 133))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(344, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tpoIdValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(departIdValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(456, Short.MAX_VALUE)))
        );

        jMenuBar1.setBackground(new java.awt.Color(97, 212, 195));
        jMenuBar1.setForeground(new java.awt.Color(97, 212, 195));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(493, 50));

        menuCompany.setForeground(new java.awt.Color(37, 46, 65));
        menuCompany.setText("Company");
        menuCompany.setToolTipText("");

        menuItemCompanyDetail.setText("View company");
        menuItemCompanyDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCompanyDetailActionPerformed(evt);
            }
        });
        menuCompany.add(menuItemCompanyDetail);

        menuItemRegisterCompany.setText("Company Register");
        menuItemRegisterCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRegisterCompanyActionPerformed(evt);
            }
        });
        menuCompany.add(menuItemRegisterCompany);

        jMenuBar1.add(menuCompany);

        menuSchedule.setForeground(new java.awt.Color(37, 46, 65));
        menuSchedule.setText("Schedule");

        menuItemScheduleDetails.setText("View schedule");
        menuItemScheduleDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemScheduleDetailsActionPerformed(evt);
            }
        });
        menuSchedule.add(menuItemScheduleDetails);

        menuItemCreateSchedule.setText("Create schedule");
        menuItemCreateSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCreateScheduleActionPerformed(evt);
            }
        });
        menuSchedule.add(menuItemCreateSchedule);

        menuItemDeleteSchedule.setText("Delete schedule");
        menuItemDeleteSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDeleteScheduleActionPerformed(evt);
            }
        });
        menuSchedule.add(menuItemDeleteSchedule);

        jMenuBar1.add(menuSchedule);

        menuStudent.setForeground(new java.awt.Color(37, 46, 65));
        menuStudent.setText("Student");

        menuItemStudentDetails.setText("View student");
        menuItemStudentDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemStudentDetailsActionPerformed(evt);
            }
        });
        menuStudent.add(menuItemStudentDetails);

        jmenuItemRegisteredStudents.setText("Students registered for schedule");
        jmenuItemRegisteredStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuItemRegisteredStudentsActionPerformed(evt);
            }
        });
        menuStudent.add(jmenuItemRegisteredStudents);

        jMenuBar1.add(menuStudent);

        menuAlumni.setForeground(new java.awt.Color(37, 46, 65));
        menuAlumni.setText("Alumini");

        menuItemRecruitedStudents.setText("Recruited Students");
        menuItemRecruitedStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRecruitedStudentsActionPerformed(evt);
            }
        });
        menuAlumni.add(menuItemRecruitedStudents);

        jMenuBar1.add(menuAlumni);

        menuReport.setForeground(new java.awt.Color(37, 46, 65));
        menuReport.setText("Report");

        menuItemDepartmentWise.setText("View Department wise");
        menuItemDepartmentWise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDepartmentWiseActionPerformed(evt);
            }
        });
        menuReport.add(menuItemDepartmentWise);

        menuItemCompanyWise.setText("View Company wise");
        menuItemCompanyWise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCompanyWiseActionPerformed(evt);
            }
        });
        menuReport.add(menuItemCompanyWise);

        menuItemYearWise.setText("View Year wise");
        menuItemYearWise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemYearWiseActionPerformed(evt);
            }
        });
        menuReport.add(menuItemYearWise);

        jMenuBar1.add(menuReport);

        menuProfile.setForeground(new java.awt.Color(37, 46, 65));
        menuProfile.setText("Profile");

        menuItemEdit.setText("Edit");
        menuItemEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEditActionPerformed(evt);
            }
        });
        menuProfile.add(menuItemEdit);

        jMenuBar1.add(menuProfile);

        menuMore.setForeground(new java.awt.Color(37, 46, 65));
        menuMore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoutButton.gif"))); // NOI18N
        menuMore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMoreMouseClicked(evt);
            }
        });
        menuMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMoreActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuMore);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEditActionPerformed
        try {
            new EditProfileJframe(personId).setVisible(true);
            this.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(TPOHomePageJframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemEditActionPerformed

    private void menuItemRegisterCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRegisterCompanyActionPerformed
        this.setVisible(true);
        new RegisterCompanyJframe().setVisible(true);
    }//GEN-LAST:event_menuItemRegisterCompanyActionPerformed

    private void menuItemCompanyDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCompanyDetailActionPerformed
        showCompanyInJTable();
        labelTitle.setVisible(false);
        panelCompanyTable.setVisible(true);
        panelScheduleTable.setVisible(false);
        labelWelcomeIcon.setVisible(false);
    }//GEN-LAST:event_menuItemCompanyDetailActionPerformed

    private void menuItemCreateScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCreateScheduleActionPerformed
        this.setVisible(true);
        new CreateScheduleJframe(tpoId).setVisible(true);
    }//GEN-LAST:event_menuItemCreateScheduleActionPerformed

    private void menuItemScheduleDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemScheduleDetailsActionPerformed
        showScheduleInJTable();
        labelTitle.setVisible(false);
        panelCompanyTable.setVisible(false);
        panelScheduleTable.setVisible(true);
        labelWelcomeIcon.setVisible(false);
    }//GEN-LAST:event_menuItemScheduleDetailsActionPerformed

    private void menuItemStudentDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemStudentDetailsActionPerformed
        this.setVisible(true);
        new StudentsListJframe(tpoId).setVisible(true);
    }//GEN-LAST:event_menuItemStudentDetailsActionPerformed

    private void jmenuItemRegisteredStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuItemRegisteredStudentsActionPerformed
        this.setVisible(true);
        new AppearingStudentsScheduleListJframe(tpoId).setVisible(true);
    }//GEN-LAST:event_jmenuItemRegisteredStudentsActionPerformed

    private void menuMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMoreActionPerformed
        logout();
    }//GEN-LAST:event_menuMoreActionPerformed
    public void logout() {
        this.dispose();
        try {
            new LoginJframe().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(TPOHomePageJframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void menuItemRecruitedStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRecruitedStudentsActionPerformed
        new AlumniJframe(tpoId).setVisible(true);
    }//GEN-LAST:event_menuItemRecruitedStudentsActionPerformed

    private void menuItemDepartmentWiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDepartmentWiseActionPerformed
        new ReportDepartmentWiseJframe().setVisible(true);
    }//GEN-LAST:event_menuItemDepartmentWiseActionPerformed

    private void menuItemCompanyWiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCompanyWiseActionPerformed
        new ReportCompanywiseJframe().setVisible(true);
    }//GEN-LAST:event_menuItemCompanyWiseActionPerformed

    private void menuItemYearWiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemYearWiseActionPerformed
        new AlumniJframe(tpoId).setVisible(true);
    }//GEN-LAST:event_menuItemYearWiseActionPerformed

    private void menuMoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMoreMouseClicked
        logout();
    }//GEN-LAST:event_menuMoreMouseClicked

    private void menuItemDeleteScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDeleteScheduleActionPerformed
        // TODO add your handling code here:
        new DeleteScheduleJFrame().setVisible(true);
    }//GEN-LAST:event_menuItemDeleteScheduleActionPerformed

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
            java.util.logging.Logger.getLogger(TPOHomePageJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TPOHomePageJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TPOHomePageJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TPOHomePageJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel departIdValue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_company;
    private javax.swing.JTable jTable_schedule;
    private javax.swing.JMenuItem jmenuItemRegisteredStudents;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JLabel labelWelcomeIcon;
    private javax.swing.JMenu menuAlumni;
    private javax.swing.JMenu menuCompany;
    private javax.swing.JMenuItem menuItemCompanyDetail;
    private javax.swing.JMenuItem menuItemCompanyWise;
    private javax.swing.JMenuItem menuItemCreateSchedule;
    private javax.swing.JMenuItem menuItemDeleteSchedule;
    private javax.swing.JMenuItem menuItemDepartmentWise;
    private javax.swing.JMenuItem menuItemEdit;
    private javax.swing.JMenuItem menuItemRecruitedStudents;
    private javax.swing.JMenuItem menuItemRegisterCompany;
    private javax.swing.JMenuItem menuItemScheduleDetails;
    private javax.swing.JMenuItem menuItemStudentDetails;
    private javax.swing.JMenuItem menuItemYearWise;
    private javax.swing.JMenu menuMore;
    private javax.swing.JMenu menuProfile;
    private javax.swing.JMenu menuReport;
    private javax.swing.JMenu menuSchedule;
    private javax.swing.JMenu menuStudent;
    private javax.swing.JPanel panelCompanyTable;
    private javax.swing.JPanel panelScheduleTable;
    private javax.swing.JLabel tpoIdValue;
    // End of variables declaration//GEN-END:variables
}
