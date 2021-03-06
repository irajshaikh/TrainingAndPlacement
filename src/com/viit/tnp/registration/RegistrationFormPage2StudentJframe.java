/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viit.tnp.registration;

import com.viit.tnp.common.CommonUtils;
import com.viit.tnp.common.MySqlConnect;
import com.viit.tnp.common.PersonalDetails;
import com.viit.tnp.student.Student;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class RegistrationFormPage2StudentJframe extends javax.swing.JFrame {

    /**
     * Creates new form student_register
     */
    int pid;
    Connection conn = MySqlConnect.getConnection();
    DefaultComboBoxModel comboModel;

    PersonalDetails personalDetails;
    Student s = new Student();

    public RegistrationFormPage2StudentJframe(PersonalDetails personalDetails) {
        comboModel = new DefaultComboBoxModel(CommonUtils.getDepartmentsList());
        initComponents();
        this.personalDetails = personalDetails;
        labelMarksFEError.setVisible(false);
        labelMarksSEError.setVisible(false);
        labelMarksTEError.setVisible(false);
    }

    public void executeSQlQuery(String query, String message) {
        Statement st;
        try {
            st = conn.createStatement();
            if ((st.executeUpdate(query)) == 1) {
                JOptionPane.showMessageDialog(null, "Data " + message + " Succefully");
            } else {
                JOptionPane.showMessageDialog(null, "Data Not " + message);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldFEMarks = new javax.swing.JTextField();
        fieldSEMarks = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fieldTEMarks = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fieldDepartment = new javax.swing.JComboBox<>();
        nextButtonPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dateChooser = new javax.swing.JComboBox<>();
        labelMarksTEError = new javax.swing.JLabel();
        labelMarksFEError = new javax.swing.JLabel();
        labelMarksSEError = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Additional details");

        jPanel2.setBackground(new java.awt.Color(36, 47, 65));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Academic Year:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(40, 40, 137, 22);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CGPA");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(130, 220, 80, 29);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("First Year/Diploma : ");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(40, 270, 190, 22);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Second Year :");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(40, 330, 180, 22);

        fieldFEMarks.setBackground(new java.awt.Color(36, 47, 65));
        fieldFEMarks.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        fieldFEMarks.setForeground(java.awt.Color.white);
        fieldFEMarks.setBorder(null);
        fieldFEMarks.setCaretColor(java.awt.Color.white);
        fieldFEMarks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldFEMarksKeyReleased(evt);
            }
        });
        jPanel2.add(fieldFEMarks);
        fieldFEMarks.setBounds(240, 270, 50, 30);

        fieldSEMarks.setBackground(new java.awt.Color(36, 47, 65));
        fieldSEMarks.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        fieldSEMarks.setForeground(java.awt.Color.white);
        fieldSEMarks.setBorder(null);
        fieldSEMarks.setCaretColor(java.awt.Color.white);
        fieldSEMarks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldSEMarksKeyReleased(evt);
            }
        });
        jPanel2.add(fieldSEMarks);
        fieldSEMarks.setBounds(240, 330, 50, 30);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Third Year :");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(40, 400, 106, 22);

        fieldTEMarks.setBackground(new java.awt.Color(36, 47, 65));
        fieldTEMarks.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        fieldTEMarks.setForeground(java.awt.Color.white);
        fieldTEMarks.setBorder(null);
        fieldTEMarks.setCaretColor(java.awt.Color.white);
        fieldTEMarks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldTEMarksKeyReleased(evt);
            }
        });
        jPanel2.add(fieldTEMarks);
        fieldTEMarks.setBounds(240, 400, 50, 30);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Department:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(40, 130, 113, 22);

        fieldDepartment.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        fieldDepartment.setModel(comboModel);
        fieldDepartment.setBorder(null);
        jPanel2.add(fieldDepartment);
        fieldDepartment.setBounds(240, 130, 168, 30);

        nextButtonPanel.setBackground(new java.awt.Color(97, 212, 195));
        nextButtonPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextButtonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextButtonPanelMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(36, 47, 65));
        jLabel9.setText("Next");

        javax.swing.GroupLayout nextButtonPanelLayout = new javax.swing.GroupLayout(nextButtonPanel);
        nextButtonPanel.setLayout(nextButtonPanelLayout);
        nextButtonPanelLayout.setHorizontalGroup(
            nextButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nextButtonPanelLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(26, 26, 26))
        );
        nextButtonPanelLayout.setVerticalGroup(
            nextButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nextButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(nextButtonPanel);
        nextButtonPanel.setBounds(840, 450, 99, 45);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/regStepSideStudent.png"))); // NOI18N
        jPanel2.add(jLabel8);
        jLabel8.setBounds(700, 10, 256, 256);
        jPanel2.add(jSeparator4);
        jSeparator4.setBounds(240, 430, 50, 10);
        jPanel2.add(jSeparator5);
        jSeparator5.setBounds(240, 300, 50, 10);
        jPanel2.add(jSeparator6);
        jSeparator6.setBounds(240, 360, 50, 10);

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("/ 10");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(300, 400, 50, 30);

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("/ 10");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(300, 270, 50, 30);

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("/ 10");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(300, 330, 50, 30);

        dateChooser.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        dateChooser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016", "2017", "2018", "2019", "2020" }));
        jPanel2.add(dateChooser);
        dateChooser.setBounds(240, 40, 170, 32);

        labelMarksTEError.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelMarksTEError.setForeground(new java.awt.Color(230, 49, 29));
        labelMarksTEError.setText("marksTEError");
        jPanel2.add(labelMarksTEError);
        labelMarksTEError.setBounds(350, 400, 270, 30);

        labelMarksFEError.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelMarksFEError.setForeground(new java.awt.Color(230, 49, 29));
        labelMarksFEError.setText("marksFEError");
        jPanel2.add(labelMarksFEError);
        labelMarksFEError.setBounds(350, 270, 270, 21);

        labelMarksSEError.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelMarksSEError.setForeground(new java.awt.Color(230, 49, 29));
        labelMarksSEError.setText("marksSEError");
        jPanel2.add(labelMarksSEError);
        labelMarksSEError.setBounds(350, 330, 270, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/regStep2Top.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveAndNext() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        int date = Integer.parseInt(dateChooser.getSelectedItem().toString());
        String selectedDepartment = fieldDepartment.getSelectedItem().toString();
        int departmentId = CommonUtils.getDepartmentIdFromName(selectedDepartment);
        float marksFirstYear = Float.parseFloat(fieldFEMarks.getText());
        float marksSecondYear = Float.parseFloat(fieldSEMarks.getText());
        float marksThirdYear = Float.parseFloat(fieldTEMarks.getText());
        int isActive = 1;

        Student student = new Student(marksFirstYear, marksSecondYear,
                marksThirdYear, isActive, departmentId, date);
        this.dispose();
        new RegistrationFormPage3Jframe("Student", personalDetails, null, student).setVisible(true);
    }

    private void nextButtonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonPanelMouseClicked
        boolean isValidFEMarks = validateMarks(1);
        boolean isValidSEMarks = validateMarks(2);
        boolean isValidTEMarks = validateMarks(3);
        if (isValidFEMarks && isValidSEMarks && isValidTEMarks) {
            this.saveAndNext();
        }
    }//GEN-LAST:event_nextButtonPanelMouseClicked

    private void fieldFEMarksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldFEMarksKeyReleased
        validateMarks(1);
    }//GEN-LAST:event_fieldFEMarksKeyReleased

    private void fieldSEMarksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldSEMarksKeyReleased
        validateMarks(2);
    }//GEN-LAST:event_fieldSEMarksKeyReleased

    private void fieldTEMarksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTEMarksKeyReleased
        validateMarks(3);
    }//GEN-LAST:event_fieldTEMarksKeyReleased

    boolean validateMarks(int year) {
        boolean isValid = true;

        javax.swing.JTextField fieldMarks = fieldFEMarks;
        javax.swing.JLabel errorLabel = labelMarksFEError;

        switch (year) {
            case 1:
                fieldMarks = fieldFEMarks;
                errorLabel = labelMarksFEError;
                break;
            case 2:
                fieldMarks = fieldSEMarks;
                errorLabel = labelMarksSEError;
                break;
            case 3:
                fieldMarks = fieldTEMarks;
                errorLabel = labelMarksTEError;
                break;
        }
        errorLabel.setVisible(false);
        String marksText = fieldMarks.getText();
        if (marksText.length() == 0) {
            isValid = false;
            errorLabel.setText("Required");
            errorLabel.setVisible(true);
        } else {
            try {
                float marks = Float.parseFloat(marksText);
                if (marks < 0 || marks > 10) {
                    errorLabel.setText("Should be between 0 and 10");
                    errorLabel.setVisible(true);
                }
            } catch (Exception e) {
                errorLabel.setText("Should be a number");
                errorLabel.setVisible(true);
            }
        }
        return isValid;
    }

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
            java.util.logging.Logger.getLogger(RegistrationFormPage2StudentJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationFormPage2StudentJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationFormPage2StudentJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationFormPage2StudentJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JComboBox<String> dateChooser;
    private javax.swing.JComboBox<String> fieldDepartment;
    private javax.swing.JTextField fieldFEMarks;
    private javax.swing.JTextField fieldSEMarks;
    private javax.swing.JTextField fieldTEMarks;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel labelMarksFEError;
    private javax.swing.JLabel labelMarksSEError;
    private javax.swing.JLabel labelMarksTEError;
    private javax.swing.JPanel nextButtonPanel;
    // End of variables declaration//GEN-END:variables
}
