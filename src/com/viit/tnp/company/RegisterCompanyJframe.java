/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viit.tnp.company;

import com.viit.tnp.common.MySqlConnect;
import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class RegisterCompanyJframe extends javax.swing.JFrame {

    Connection conn = MySqlConnect.getConnection();
    Company company = new Company();

    /**
     * Creates new form company
     */
    public RegisterCompanyJframe() {
        initComponents();
        setDefaultCloseOperation(RegisterCompanyJframe.HIDE_ON_CLOSE);
        labelCompanyNameError.setVisible(false);
        labelTypeError.setVisible(false);
        labelStreetError.setVisible(false);
        labelPincodeError.setVisible(false);
        labelHRNameError.setVisible(false);
        labelEmailError.setVisible(false);
        labelPhoneError.setVisible(false);
    }

    public boolean validatePincode() {
        String pincode = company.getPincode();
        boolean isValidPincode = (pincode.length() == 6
                && pincode.matches("^[1-9][0-9]{5}$")) || pincode.length() == 0;
        if (!isValidPincode) {
            labelPincodeError.setText("Invalid pincode");
            labelPincodeError.setVisible(true);
        } else {
            labelPincodeError.setVisible(false);
        }
        return isValidPincode;
    }

    public boolean validatePhone() {
        String mobileNo = company.getPhoneNo();
        boolean isValidPhone = mobileNo.length() == 10 && mobileNo.matches("[0-9]+");
        if (!isValidPhone) {
            if (mobileNo.length() == 0) {
                labelPhoneError.setText("Phone no is required");
            } else {
                labelPhoneError.setText("Invalid phone no");
            }
            labelPhoneError.setVisible(true);
        } else {
            labelPhoneError.setVisible(false);
        }
        return isValidPhone;
    }

    public boolean validateCompanyName() {
        String companyName = company.getCompanyName();
        boolean isValidName = companyName.length() != 0;
        if (!isValidName) {
            labelCompanyNameError.setText("Name is required");
            labelCompanyNameError.setVisible(true);
        } else {
            labelCompanyNameError.setVisible(false);
        }
        return isValidName;
    }

    public boolean validateType() {
        String companyType = company.getType();
        boolean isValidType = companyType.length() != 0;
        if (!isValidType) {
            labelTypeError.setText("Type is required");
            labelTypeError.setVisible(true);
        } else {
            labelTypeError.setVisible(false);
        }
        return isValidType;
    }

    public boolean validateHRName() {
        String hrName = company.getHrName();
        boolean isValidHRName = hrName.length() != 0;
        if (!isValidHRName) {
            labelHRNameError.setText("HR name is required");
            labelHRNameError.setVisible(true);
        } else {
            labelHRNameError.setVisible(false);
        }
        return isValidHRName;
    }

    public boolean validateStreet() {
        String street = company.getStreet();
        boolean isValidStreet = street.length() != 0;
        if (!isValidStreet) {
            labelStreetError.setText("Street is required");
            labelStreetError.setVisible(true);
        } else {
            labelStreetError.setVisible(false);
        }
        return isValidStreet;
    }

    public boolean validateEmail() {
        boolean isValidEmail;
        String email = company.getEmail();
        String email_pattern = "^[_A-Za-z0-9]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9-]+)*(\\.[A-za-z0-9]{2,})$";
        Pattern pattern = Pattern.compile(email_pattern);
        Matcher matcher = pattern.matcher(email);
        isValidEmail = matcher.matches();

        if (!isValidEmail) {
            if (email.length() == 0) {
                labelStreetError.setText("Email is required");
            } else {
                labelStreetError.setText("Invalid email");
            }
            labelStreetError.setVisible(true);
        } else {
            labelStreetError.setVisible(false);
        }
        return isValidEmail;
    }

    private boolean validateForm() {
        boolean isValid = false;

        boolean isValidCompanyName = validateCompanyName();
        boolean isValidType = validateType();
        boolean isValidStreet = validateStreet();
        boolean isValidHRName = validateHRName();
        boolean isValidPincode = validatePincode();
        boolean isValidEmail = validateEmail();
        boolean isValidPhone = validatePhone();
        if (isValidCompanyName && isValidType && isValidStreet && isValidHRName
                && isValidPincode && isValidEmail && isValidPhone) {
            isValid = true;
        }
        return isValid;
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
        jLabel8 = new javax.swing.JLabel();
        jTextFieldCompanyName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldType = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldHRName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldPhone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldStreet = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldPincode = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        registerButtonPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jComboBox1 = new javax.swing.JComboBox<>();
        labelPincodeError = new javax.swing.JLabel();
        labelCompanyNameError = new javax.swing.JLabel();
        labelStreetError = new javax.swing.JLabel();
        labelEmailError = new javax.swing.JLabel();
        labelHRNameError = new javax.swing.JLabel();
        labelTypeError = new javax.swing.JLabel();
        labelPhoneError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register company");

        jPanel2.setBackground(new java.awt.Color(36, 47, 65));
        jPanel2.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Company Name :");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(40, 60, 170, 22);

        jTextFieldCompanyName.setBackground(new java.awt.Color(36, 47, 65));
        jTextFieldCompanyName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldCompanyName.setForeground(java.awt.Color.white);
        jTextFieldCompanyName.setBorder(null);
        jTextFieldCompanyName.setCaretColor(java.awt.Color.white);
        jTextFieldCompanyName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCompanyNameKeyReleased(evt);
            }
        });
        jPanel2.add(jTextFieldCompanyName);
        jTextFieldCompanyName.setBounds(250, 60, 151, 30);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Type :");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(40, 120, 60, 22);

        jTextFieldType.setBackground(new java.awt.Color(36, 47, 65));
        jTextFieldType.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldType.setForeground(java.awt.Color.white);
        jTextFieldType.setBorder(null);
        jTextFieldType.setCaretColor(java.awt.Color.white);
        jTextFieldType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldTypeKeyReleased(evt);
            }
        });
        jPanel2.add(jTextFieldType);
        jTextFieldType.setBounds(250, 120, 151, 30);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("HR Name : ");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(470, 70, 110, 22);

        jTextFieldHRName.setBackground(new java.awt.Color(36, 47, 65));
        jTextFieldHRName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldHRName.setForeground(java.awt.Color.white);
        jTextFieldHRName.setBorder(null);
        jTextFieldHRName.setCaretColor(java.awt.Color.white);
        jTextFieldHRName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldHRNameKeyReleased(evt);
            }
        });
        jPanel2.add(jTextFieldHRName);
        jTextFieldHRName.setBounds(640, 60, 151, 30);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email : ");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(470, 140, 66, 30);

        jTextFieldEmail.setBackground(new java.awt.Color(36, 47, 65));
        jTextFieldEmail.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldEmail.setForeground(java.awt.Color.white);
        jTextFieldEmail.setBorder(null);
        jTextFieldEmail.setCaretColor(java.awt.Color.white);
        jTextFieldEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldEmailKeyReleased(evt);
            }
        });
        jPanel2.add(jTextFieldEmail);
        jTextFieldEmail.setBounds(640, 140, 151, 30);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Phone number :");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(470, 222, 142, 30);

        jTextFieldPhone.setBackground(new java.awt.Color(36, 47, 65));
        jTextFieldPhone.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldPhone.setForeground(java.awt.Color.white);
        jTextFieldPhone.setBorder(null);
        jTextFieldPhone.setCaretColor(java.awt.Color.white);
        jTextFieldPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPhoneKeyReleased(evt);
            }
        });
        jPanel2.add(jTextFieldPhone);
        jTextFieldPhone.setBounds(640, 220, 151, 30);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Street :");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(40, 190, 67, 22);

        jTextFieldStreet.setBackground(new java.awt.Color(36, 47, 65));
        jTextFieldStreet.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldStreet.setForeground(java.awt.Color.white);
        jTextFieldStreet.setBorder(null);
        jTextFieldStreet.setCaretColor(java.awt.Color.white);
        jTextFieldStreet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldStreetKeyReleased(evt);
            }
        });
        jPanel2.add(jTextFieldStreet);
        jTextFieldStreet.setBounds(250, 190, 151, 30);

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("City : ");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(40, 270, 54, 22);

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Pincode : ");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(40, 350, 87, 22);

        jTextFieldPincode.setBackground(new java.awt.Color(36, 47, 65));
        jTextFieldPincode.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldPincode.setForeground(java.awt.Color.white);
        jTextFieldPincode.setBorder(null);
        jTextFieldPincode.setCaretColor(java.awt.Color.white);
        jTextFieldPincode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPincodeKeyReleased(evt);
            }
        });
        jPanel2.add(jTextFieldPincode);
        jTextFieldPincode.setBounds(250, 340, 151, 30);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(430, 40, 10, 390);

        registerButtonPanel.setBackground(new java.awt.Color(97, 212, 195));
        registerButtonPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerButtonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerButtonPanelMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(36, 47, 65));
        jLabel10.setText("Register");

        javax.swing.GroupLayout registerButtonPanelLayout = new javax.swing.GroupLayout(registerButtonPanel);
        registerButtonPanel.setLayout(registerButtonPanelLayout);
        registerButtonPanelLayout.setHorizontalGroup(
            registerButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerButtonPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        registerButtonPanelLayout.setVerticalGroup(
            registerButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerButtonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );

        jPanel2.add(registerButtonPanel);
        registerButtonPanel.setBounds(390, 460, 120, 45);

        jSeparator2.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setBorder(null);
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(640, 250, 150, 10);

        jSeparator3.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setBorder(null);
        jPanel2.add(jSeparator3);
        jSeparator3.setBounds(250, 90, 150, 10);

        jSeparator4.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator4.setBorder(null);
        jPanel2.add(jSeparator4);
        jSeparator4.setBounds(250, 150, 150, 10);

        jSeparator5.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator5.setBorder(null);
        jPanel2.add(jSeparator5);
        jSeparator5.setBounds(250, 220, 150, 10);

        jSeparator7.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator7.setBorder(null);
        jPanel2.add(jSeparator7);
        jSeparator7.setBounds(250, 370, 150, 10);

        jSeparator8.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator8.setBorder(null);
        jPanel2.add(jSeparator8);
        jSeparator8.setBounds(640, 90, 150, 10);

        jSeparator9.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator9.setBorder(null);
        jPanel2.add(jSeparator9);
        jSeparator9.setBounds(640, 170, 150, 10);

        jComboBox1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pune", "Mumbai", "Hyderabad", "Nagpur", "Bengaluru", "Solapur", "Indore", " " }));
        jComboBox1.setBorder(null);
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(250, 270, 150, 32);

        labelPincodeError.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelPincodeError.setForeground(new java.awt.Color(230, 49, 29));
        labelPincodeError.setText("pincodeError");
        jPanel2.add(labelPincodeError);
        labelPincodeError.setBounds(180, 380, 240, 21);

        labelCompanyNameError.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelCompanyNameError.setForeground(new java.awt.Color(230, 49, 29));
        labelCompanyNameError.setText("nameError");
        jPanel2.add(labelCompanyNameError);
        labelCompanyNameError.setBounds(150, 90, 270, 21);

        labelStreetError.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelStreetError.setForeground(new java.awt.Color(230, 49, 29));
        labelStreetError.setText("streetError");
        jPanel2.add(labelStreetError);
        labelStreetError.setBounds(150, 230, 270, 21);

        labelEmailError.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelEmailError.setForeground(new java.awt.Color(230, 49, 29));
        labelEmailError.setText("emailError");
        jPanel2.add(labelEmailError);
        labelEmailError.setBounds(600, 180, 270, 21);

        labelHRNameError.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelHRNameError.setForeground(new java.awt.Color(230, 49, 29));
        labelHRNameError.setText("hrNameError");
        jPanel2.add(labelHRNameError);
        labelHRNameError.setBounds(600, 100, 270, 21);

        labelTypeError.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelTypeError.setForeground(new java.awt.Color(230, 49, 29));
        labelTypeError.setText("typeError");
        jPanel2.add(labelTypeError);
        labelTypeError.setBounds(150, 160, 270, 21);

        labelPhoneError.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelPhoneError.setForeground(new java.awt.Color(230, 49, 29));
        labelPhoneError.setText("phoneError");
        jPanel2.add(labelPhoneError);
        labelPhoneError.setBounds(600, 260, 270, 21);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonPanelMouseClicked
        boolean isValidForm = validateForm();

        if (isValidForm) {
            String query1 = "INSERT INTO `company`(`co_name`,`type`,`HR_personnel`,"
                    + "`email`,`phone`,`street`,`city`,`pincode`) VALUES ('"
                    + jTextFieldCompanyName.getText() + "','" + jTextFieldType.getText()
                    + "','" + jTextFieldHRName.getText() + "','" + jTextFieldEmail.getText()
                    + "','" + jTextFieldPhone.getText() + "','" + jTextFieldStreet.getText()
                    + "','" + jComboBox1.getSelectedItem() + "','" + jTextFieldPincode.getText() + "')";
            boolean registered = MySqlConnect.executeUpdateSQlQuery(query1);
            if (registered) {
                JOptionPane.showMessageDialog(null, "Company registered!");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Failed to register company", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
        }
    }//GEN-LAST:event_registerButtonPanelMouseClicked

    private void jTextFieldPincodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPincodeKeyReleased
        company.setPincode(jTextFieldPincode.getText());
        validatePincode();
    }//GEN-LAST:event_jTextFieldPincodeKeyReleased

    private void jTextFieldEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEmailKeyReleased
        company.setEmail(jTextFieldEmail.getText());
        validateEmail();
    }//GEN-LAST:event_jTextFieldEmailKeyReleased

    private void jTextFieldPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPhoneKeyReleased
        company.setPhoneNo(jTextFieldPhone.getText());
        validatePhone();
    }//GEN-LAST:event_jTextFieldPhoneKeyReleased

    private void jTextFieldHRNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHRNameKeyReleased
        company.setHrName(jTextFieldHRName.getText());
        validateHRName();
    }//GEN-LAST:event_jTextFieldHRNameKeyReleased

    private void jTextFieldTypeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTypeKeyReleased
        company.setType(jTextFieldType.getText());
        validateType();
    }//GEN-LAST:event_jTextFieldTypeKeyReleased

    private void jTextFieldStreetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldStreetKeyReleased
        company.setStreet(jTextFieldStreet.getText());
        validateStreet();
    }//GEN-LAST:event_jTextFieldStreetKeyReleased

    private void jTextFieldCompanyNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCompanyNameKeyReleased
        company.setCompanyName(jTextFieldCompanyName.getText());
        validateCompanyName();
    }//GEN-LAST:event_jTextFieldCompanyNameKeyReleased

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
            java.util.logging.Logger.getLogger(RegisterCompanyJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterCompanyJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterCompanyJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterCompanyJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterCompanyJframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextFieldCompanyName;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldHRName;
    private javax.swing.JTextField jTextFieldPhone;
    private javax.swing.JTextField jTextFieldPincode;
    private javax.swing.JTextField jTextFieldStreet;
    private javax.swing.JTextField jTextFieldType;
    private javax.swing.JLabel labelCompanyNameError;
    private javax.swing.JLabel labelEmailError;
    private javax.swing.JLabel labelHRNameError;
    private javax.swing.JLabel labelPhoneError;
    private javax.swing.JLabel labelPincodeError;
    private javax.swing.JLabel labelStreetError;
    private javax.swing.JLabel labelTypeError;
    private javax.swing.JPanel registerButtonPanel;
    // End of variables declaration//GEN-END:variables

////    private Connection getConnection() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
