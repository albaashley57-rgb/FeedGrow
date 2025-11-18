package com.mycompany.feeedgrow.vista;

import com.mycompany.feeedgrow.controlador.PerfilControlador;
import com.mycompany.feeedgrow.modelo.Estudiante;
import com.mycompany.feeedgrow.persistencia.GestorDatos;
import javax.swing.JOptionPane;

public class EditarPerfil extends javax.swing.JPanel {

    private Estudiante estudiante;
    private GestorDatos gestor;

    public EditarPerfil(GestorDatos gestor, Estudiante estudiante) {
        this.estudiante = estudiante;
        this.gestor = gestor;
        initComponents();
        initCustom();
    }

    private void initCustom() {
        if (estudiante != null) {
            jLabel11.setText(estudiante.getNombre());
        }
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
        Responsabilidad1 = new javax.swing.JLabel();
        jCampoCorreo = new javax.swing.JTextField();
        Responsabilidad2 = new javax.swing.JLabel();
        Responsabilidad3 = new javax.swing.JLabel();
        Responsabilidad4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField3 = new javax.swing.JPasswordField();
        jComboCarrera = new javax.swing.JComboBox<>();

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

        Responsabilidad1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        Responsabilidad1.setText("Carrera:");
        jPanel2.add(Responsabilidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 192, -1));

        jCampoCorreo.setBackground(new java.awt.Color(200, 200, 200));
        jPanel2.add(jCampoCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 890, -1));

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
        jPanel2.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 890, -1));

        jPasswordField2.setBackground(new java.awt.Color(200, 200, 200));
        jPasswordField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField2ActionPerformed(evt);
            }
        });
        jPanel2.add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 890, -1));

        jPasswordField3.setBackground(new java.awt.Color(200, 200, 200));
        jPasswordField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField3ActionPerformed(evt);
            }
        });
        jPanel2.add(jPasswordField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 890, -1));

        jComboCarrera.setBackground(new java.awt.Color(200, 200, 200));
        jComboCarrera.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione su carrera...", "Biología", "Física", "Licenciatura en Matemáticas", "Matemáticas", "Química", "Ingeniería de Sistemas", "Ingeniería Eléctrica", "Ingeniería Electrónica", "Ingeniería Industrial", "Ingeniería Mecánica", "Ingeniería Biomédica", "Ingeniería en Ciencia de Datos", "Diseño Industrial", "Ingeniería Civil", "Ingeniería Química", "Ingeniería de Petróleos", "Geología", "Enfermería", "Fisioterapia", "Medicina", "Microbiología y Bioanálisis", "Nutrición y Dietética", "Derecho", "Economía", "Filosofía", "Historia y Archivística", "Licenciatura en Educación Básica Primaria", "Licenciatura en Literatura y Lengua Castellana", "Licenciatura en Lenguas Extranjeras con énfasis en Inglés", "Licenciatura en Música", "Trabajo Social", "Técnica Profesional en Ejecución de Proyectos Culturales y Creativos" }));
        jPanel2.add(jComboCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 890, -1));

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
    String carrera = (String) jComboCarrera.getSelectedItem();
    String correo = jCampoCorreo.getText();
    String antiguaPass = new String(jPasswordField1.getPassword());
    String nuevaPass = new String(jPasswordField2.getPassword());
    String confirmarPass = new String(jPasswordField3.getPassword());

    PerfilControlador controlador = new PerfilControlador(gestor);
    String resultado = controlador.editarPerfil(estudiante, carrera, correo,
                                                antiguaPass, nuevaPass, confirmarPass);

    if (resultado.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Cambios guardados.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        jPasswordField1.setText("");
        jPasswordField2.setText("");
        jPasswordField3.setText("");
    } else {
        JOptionPane.showMessageDialog(this, resultado, "Error", JOptionPane.WARNING_MESSAGE);
    }              
    }//GEN-LAST:event_GuardarActionPerformed

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
    private javax.swing.JTextField jCampoCorreo;
    private javax.swing.JComboBox<String> jComboCarrera;
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
    // End of variables declaration//GEN-END:variables
}
