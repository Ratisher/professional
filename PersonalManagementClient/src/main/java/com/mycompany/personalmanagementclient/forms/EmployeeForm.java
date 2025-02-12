/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.personalmanagementclient.forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author 1208-VM1
 */
public class EmployeeForm extends javax.swing.JFrame {

    public static int clickedUserId;

    public static int employeeID;
    private DefaultListModel divisionsModel = new DefaultListModel();
    private OkHttpClient okHttpClient = new OkHttpClient();

    /**
     * Creates new form EmployeeForm
     */
    public EmployeeForm() {
        initComponents();
        jList1.setModel(divisionsModel);
        createDivisionsList();
        jList1.setSelectedValue("Дороги России", false);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(8, 12, 8, 12));
        loadEmployeeData(jList1.getSelectedValue());
    }

    private void createDivisionsList() {
        Request getDivisions = new Request.Builder()
                .url("http://localhost:8080/api/v1/division/allDivision")
                .get()
                .build();

        try (Response divisions = okHttpClient.newCall(getDivisions).execute()) {
            JSONArray ja = new JSONArray(divisions.body().string());
            for (int i = 0; i < ja.length(); i++) {
                JSONObject jo = ja.getJSONObject(i);
                divisionsModel.addElement(jo.getString("name"));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadEmployeeData(String division) {
        Request request = new Request.Builder()
                .url("http://localhost:8080/api/v1/employee/employeeByDivision?division=" + division)
                .build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            JSONArray ja = new JSONArray(response.body().string());
            for (int i = 0; i < ja.length(); i++) {
                JSONObject jo = ja.getJSONObject(i);
                employeeID = jo.getInt("employeeID");
                String surname = jo.getString("surname");
                String firstname = jo.getString("firstname");
                String patronymic = jo.getString("patronymic");
                String telephone = jo.getString("telephone");
                String email = jo.getString("email");
                String office = jo.getString("office");
                String divisionId = jo.get("divisionId").toString();
                String positionId = jo.get("positionId").toString();
                String educationId = jo.get("educationId").toString();
                JPanel employeePanel = createEmployeePanel(surname, firstname, patronymic, telephone, email, office, divisionId, positionId, educationId);
                mainPanel.add(Box.createVerticalStrut(10));
                mainPanel.add(employeePanel);
                int panelIndex = employeeID;
                employeePanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        employeeID = panelIndex;
                        new EmployeeCardForm().setVisible(true);
                    }
                });
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private JPanel createEmployeePanel(String surname, String firstname, String patronymic, String telephone, String email, String office, String divisionId, String positionId, String educationId) {

        String divisionName = null;
        String positionName = null;

        String divisionUrl = "http://localhost:8080/api/v1/division/getDivision/" + divisionId;
        String positionUrl = "http://localhost:8080/api/v1/position/getPosition/" + positionId;

        Request getDivision = new Request.Builder()
                .url(divisionUrl)
                .get()
                .build();

        Request getPosition = new Request.Builder()
                .url(positionUrl)
                .get()
                .build();

        try (Response response = okHttpClient.newCall(getDivision).execute()) {
            JSONObject jo = new JSONObject(response.body().string());
            divisionName = jo.getString("name");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (Response response = okHttpClient.newCall(getPosition).execute()) {
            JSONObject jo = new JSONObject(response.body().string());
            positionName = jo.getString("name");
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel dataPane = new JPanel();
        dataPane.setLayout(new BoxLayout(dataPane, BoxLayout.Y_AXIS));
        dataPane.setPreferredSize(new Dimension(600, 125));
        dataPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, 125));
        dataPane.setBackground(Color.white);
        dataPane.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.setBackground(Color.white);
        JLabel surnameLabel = new JLabel(surname + " ");
        Font FIOFont = new Font("TimesRoman", Font.BOLD, 16);
        surnameLabel.setFont(FIOFont);
        JLabel firstnameLabel = new JLabel(firstname + " ");
        firstnameLabel.setFont(FIOFont);
        JLabel patronymicLabel = new JLabel(patronymic);
        patronymicLabel.setFont(FIOFont);
        namePanel.add(surnameLabel);
        namePanel.add(firstnameLabel);
        namePanel.add(patronymicLabel);
        namePanel.setBorder(new EmptyBorder(0, 8, 0, 8));
        namePanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel divisionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        divisionPanel.setBackground(Color.white);
        JLabel division = new JLabel(divisionName + " - ");
        JLabel position = new JLabel(positionName);
        divisionPanel.add(division);
        divisionPanel.add(position);
        divisionPanel.setBorder(new EmptyBorder(8, 8, 0, 8));
        divisionPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        infoPanel.setBackground(Color.white);
        JLabel telephoneLabel = new JLabel(telephone + " ");
        Font dataFont = new Font("TimesRoman", Font.PLAIN, 13);
        telephoneLabel.setFont(dataFont);
        JLabel emailLabel = new JLabel(email);
        infoPanel.add(telephoneLabel);
        infoPanel.add(emailLabel);
        infoPanel.setBorder(new EmptyBorder(0, 8, 0, 8));
        infoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel officePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        officePanel.setBackground(Color.white);
        JLabel officeLabel = new JLabel("Офис: " + office);
        officeLabel.setFont(dataFont);
        officePanel.add(officeLabel);
        officePanel.setBorder(new EmptyBorder(0, 8, 12, 8));
        officePanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        dataPane.add(divisionPanel);
        dataPane.add(namePanel);
        dataPane.add(infoPanel);
        dataPane.add(officePanel);

        return dataPane;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Сотрудник отдела кадров");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(120, 178, 75));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Организационная структура");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(71, 71, 71)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(444, 444, 444))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(137, 252, 67));

        jList1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
        );

        jScrollPane1.setBackground(new java.awt.Color(204, 255, 204));

        mainPanel.setBackground(new java.awt.Color(137, 252, 67));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 772, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 704, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainPanel);

        jPanel5.setBackground(new java.awt.Color(137, 252, 67));

        jButton1.setBackground(new java.awt.Color(248, 252, 67));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setText("+");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        mainPanel.removeAll();
        loadEmployeeData(jList1.getSelectedValue());
        mainPanel.revalidate();
        mainPanel.repaint();
    }//GEN-LAST:event_jList1MouseClicked

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
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
