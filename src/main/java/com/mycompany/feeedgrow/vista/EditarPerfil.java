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
            nombre.setText(estudiante.getNombre());
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
        fondo = new javax.swing.JPanel();
        iconoUsuario = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        Guardar = new javax.swing.JButton();
        confirmarContrasena = new javax.swing.JLabel();
        carrera = new javax.swing.JLabel();
        jCampoCorreo = new javax.swing.JTextField();
        Correo = new javax.swing.JLabel();
        antiguaContrasena = new javax.swing.JLabel();
        nuevaContrasena = new javax.swing.JLabel();
        jAntiguaContrasena = new javax.swing.JPasswordField();
        jNuevaContrasena = new javax.swing.JPasswordField();
        jConfirmarContrasena = new javax.swing.JPasswordField();
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

        fondo.setBackground(new java.awt.Color(255, 255, 255));

        iconoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Captura de pantalla 2025-02-04 233137.png"))); // NOI18N

        nombre.setFont(new java.awt.Font("Roboto SemiBold", 0, 24)); // NOI18N
        nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombre.setText("{estudiante nombre}");

        Guardar.setBackground(new java.awt.Color(0, 204, 102));
        Guardar.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Guardar.setForeground(new java.awt.Color(255, 255, 255));
        Guardar.setText("Guardar cambios");
        Guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        confirmarContrasena.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        confirmarContrasena.setForeground(new java.awt.Color(30, 30, 30));
        confirmarContrasena.setText("Confirmar contraseña:");

        carrera.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        carrera.setForeground(new java.awt.Color(30, 30, 30));
        carrera.setText("Carrera:");

        jCampoCorreo.setBackground(new java.awt.Color(217, 217, 217));
        jCampoCorreo.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jCampoCorreo.setForeground(new java.awt.Color(30, 30, 30));
        jCampoCorreo.setBorder(null);

        Correo.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        Correo.setForeground(new java.awt.Color(30, 30, 30));
        Correo.setText("Correo:");

        antiguaContrasena.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        antiguaContrasena.setForeground(new java.awt.Color(30, 30, 30));
        antiguaContrasena.setText("Antigua contraseña:");

        nuevaContrasena.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        nuevaContrasena.setForeground(new java.awt.Color(30, 30, 30));
        nuevaContrasena.setText("Nueva contraseña:");

        jAntiguaContrasena.setBackground(new java.awt.Color(217, 217, 217));
        jAntiguaContrasena.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jAntiguaContrasena.setForeground(new java.awt.Color(30, 30, 30));
        jAntiguaContrasena.setBorder(null);
        jAntiguaContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAntiguaContrasenaActionPerformed(evt);
            }
        });

        jNuevaContrasena.setBackground(new java.awt.Color(217, 217, 217));
        jNuevaContrasena.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jNuevaContrasena.setForeground(new java.awt.Color(30, 30, 30));
        jNuevaContrasena.setBorder(null);
        jNuevaContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNuevaContrasenaActionPerformed(evt);
            }
        });

        jConfirmarContrasena.setBackground(new java.awt.Color(217, 217, 217));
        jConfirmarContrasena.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jConfirmarContrasena.setForeground(new java.awt.Color(30, 30, 30));
        jConfirmarContrasena.setBorder(null);
        jConfirmarContrasena.setCaretColor(new java.awt.Color(30, 30, 30));
        jConfirmarContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConfirmarContrasenaActionPerformed(evt);
            }
        });

        jComboCarrera.setBackground(new java.awt.Color(217, 217, 217));
        jComboCarrera.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jComboCarrera.setForeground(new java.awt.Color(30, 30, 30));
        jComboCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione su carrera...", "Biología", "Física", "Licenciatura en Matemáticas", "Matemáticas", "Química", "Ingeniería de Sistemas", "Ingeniería Eléctrica", "Ingeniería Electrónica", "Ingeniería Industrial", "Ingeniería Mecánica", "Ingeniería Biomédica", "Ingeniería en Ciencia de Datos", "Diseño Industrial", "Ingeniería Civil", "Ingeniería Química", "Ingeniería de Petróleos", "Geología", "Enfermería", "Fisioterapia", "Medicina", "Microbiología y Bioanálisis", "Nutrición y Dietética", "Derecho", "Economía", "Filosofía", "Historia y Archivística", "Licenciatura en Educación Básica Primaria", "Licenciatura en Literatura y Lengua Castellana", "Licenciatura en Lenguas Extranjeras con énfasis en Inglés", "Licenciatura en Música", "Trabajo Social", "Técnica Profesional en Ejecución de Proyectos Culturales y Creativos" }));
        jComboCarrera.setBorder(null);

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addComponent(iconoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14)))
                .addGap(313, 313, 313))
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addComponent(Guardar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboCarrera, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCampoCorreo)
                            .addComponent(jAntiguaContrasena)
                            .addComponent(jNuevaContrasena)
                            .addComponent(confirmarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nuevaContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(antiguaContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carrera, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jConfirmarContrasena))
                        .addGap(183, 183, 183))))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(iconoUsuario))
                .addGap(44, 44, 44)
                .addComponent(carrera)
                .addGap(7, 7, 7)
                .addComponent(jComboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Correo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCampoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(antiguaContrasena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAntiguaContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nuevaContrasena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNuevaContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confirmarContrasena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jConfirmarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
    String carrera = (String) jComboCarrera.getSelectedItem();
    String correo = jCampoCorreo.getText();
    String antiguaPass = new String(jAntiguaContrasena.getPassword());
    String nuevaPass = new String(jNuevaContrasena.getPassword());
    String confirmarPass = new String(jConfirmarContrasena.getPassword());

    PerfilControlador controlador = new PerfilControlador(gestor);
    String resultado = controlador.editarPerfil(estudiante, carrera, correo,
                                                antiguaPass, nuevaPass, confirmarPass);

    if (resultado.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Cambios guardados.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        jAntiguaContrasena.setText("");
        jNuevaContrasena.setText("");
        jConfirmarContrasena.setText("");
    } else {
        JOptionPane.showMessageDialog(this, resultado, "Error", JOptionPane.WARNING_MESSAGE);
    }              
    }//GEN-LAST:event_GuardarActionPerformed

    private void jAntiguaContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAntiguaContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAntiguaContrasenaActionPerformed

    private void jNuevaContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNuevaContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNuevaContrasenaActionPerformed

    private void jConfirmarContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConfirmarContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jConfirmarContrasenaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Correo;
    private javax.swing.JButton Guardar;
    private javax.swing.JLabel antiguaContrasena;
    private javax.swing.JLabel carrera;
    private javax.swing.JLabel confirmarContrasena;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel iconoUsuario;
    private javax.swing.JPasswordField jAntiguaContrasena;
    private javax.swing.JTextField jCampoCorreo;
    private javax.swing.JComboBox<String> jComboCarrera;
    private javax.swing.JPasswordField jConfirmarContrasena;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jNuevaContrasena;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel nuevaContrasena;
    // End of variables declaration//GEN-END:variables
}
