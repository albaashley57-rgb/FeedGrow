package com.mycompany.feeedgrow.vista;

import com.mycompany.feeedgrow.modelo.Estudiante;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EditarPerfil extends javax.swing.JPanel {

    private Estudiante estudiante;

    public EditarPerfil(Estudiante estudiante) {
        this.estudiante = estudiante;
        initComponents();
        initCustom();
    }

    private void initCustom() {
        if (estudiante != null) {
            jLabel11.setText(estudiante.getNombre());
            jTextField1.setText(estudiante.getCarrera());
            jTextField2.setText(estudiante.getCorreo());
        }
    }

    private void guardar() {
        List<String> errores = new ArrayList<>();

        String carrera    = jTextField1.getText().trim();
        String correo     = jTextField2.getText().trim();
        String contrasena = new String(jPasswordField1.getPassword());
        String newPass    = new String(jPasswordField2.getPassword());
        String confirm    = new String(jPasswordField3.getPassword());

        // Validar carrera (no vacía)
        if (carrera.isEmpty()) {
            errores.add("La carrera no puede estar vacía.");
        }

        // Validar correo
        if (correo.isEmpty()) {
            errores.add("El correo no puede estar vacío.");
        }

        // ¿Quiere cambiar contraseña?
        boolean quiereCambiarPass =
                !contrasena.isEmpty() || !newPass.isEmpty() || !confirm.isEmpty();

        if (quiereCambiarPass) {
            if (contrasena.isEmpty() || newPass.isEmpty() || confirm.isEmpty()) {
                errores.add("Para cambiar la contraseña completa los tres campos.");
            } else {
                // Verifica contra la actual
                if (!contrasena.equals(estudiante.getContraseña())) {  // SIN ñ
                    errores.add("La contraseña antigua no coincide.");
                }
                if (newPass.length() < 6) {
                    errores.add("La nueva contraseña debe tener al menos 6 caracteres.");
                }
                if (!newPass.equals(confirm)) {
                    errores.add("La confirmación no coincide con la nueva contraseña.");
                }
            }
        }

        // Si hay errores, los mostramos y salimos
        if (!errores.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    String.join("\n", errores),
                    "Revisa los datos",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Guardar cambios en el modelo
        estudiante.setCarrera(carrera);
        estudiante.setCorreo(correo);
        if (quiereCambiarPass) {
            estudiante.setContraseña(newPass);   // SIN ñ
        }

        JOptionPane.showMessageDialog(
                this,
                "Cambios guardados.",
                "OK",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jOptionPane1 = new javax.swing.JOptionPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Guardar = new javax.swing.JButton();
        Responsabilidad = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Responsabilidad1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        Responsabilidad2 = new javax.swing.JLabel();
        Responsabilidad3 = new javax.swing.JLabel();
        Responsabilidad4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField3 = new javax.swing.JPasswordField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Captura de pantalla 2025-02-04 233137.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 28)); // NOI18N
        jLabel11.setText("{estudiante nombre}");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, 36));

        Guardar.setBackground(new java.awt.Color(0, 204, 102));
        Guardar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        Guardar.setForeground(new java.awt.Color(255, 255, 255));
        Guardar.setText("Guardar cambios");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        jPanel2.add(Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        Responsabilidad.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        Responsabilidad.setText("Confirmar contraseña:");
        jPanel2.add(Responsabilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 250, -1));

        jTextField1.setBackground(new java.awt.Color(200, 200, 200));
        jTextField1.setText("{jTextField1}");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 560, -1));

        Responsabilidad1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        Responsabilidad1.setText("Carrera:");
        jPanel2.add(Responsabilidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 192, -1));

        jTextField2.setBackground(new java.awt.Color(200, 200, 200));
        jTextField2.setText("{jTextField2}");
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 560, -1));

        Responsabilidad2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        Responsabilidad2.setText("Correo:");
        jPanel2.add(Responsabilidad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 192, -1));

        Responsabilidad3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        Responsabilidad3.setText("Antigua contraseña:");
        jPanel2.add(Responsabilidad3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 230, -1));

        Responsabilidad4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        Responsabilidad4.setText("Nueva contraseña:");
        jPanel2.add(Responsabilidad4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 230, -1));

        jPasswordField1.setBackground(new java.awt.Color(200, 200, 200));
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 560, -1));

        jPasswordField2.setBackground(new java.awt.Color(200, 200, 200));
        jPasswordField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField2ActionPerformed(evt);
            }
        });
        jPanel2.add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 560, -1));

        jPasswordField3.setBackground(new java.awt.Color(200, 200, 200));
        jPasswordField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField3ActionPerformed(evt);
            }
        });
        jPanel2.add(jPasswordField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 560, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
     guardar();                                   
    }//GEN-LAST:event_GuardarActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jPasswordField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField2ActionPerformed

    private void jPasswordField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Guardar;
    private javax.swing.JLabel Responsabilidad;
    private javax.swing.JLabel Responsabilidad1;
    private javax.swing.JLabel Responsabilidad2;
    private javax.swing.JLabel Responsabilidad3;
    private javax.swing.JLabel Responsabilidad4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
