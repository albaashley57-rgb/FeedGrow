package com.mycompany.feedgrow.controlador;
import com.mycompany.feedgrow.modelo.Estudiante;
import com.mycompany.feedgrow.modelo.Seguridad;
import com.mycompany.feedgrow.persistencia.GestorDatos;

public class InicioDeSesionControlador {
private GestorDatos gestor;

    public InicioDeSesionControlador(GestorDatos gestor){
       this.gestor = gestor;
    }


    // 1️⃣ Validar que los campos no estén vacíos
    public String validarCamposLogin(String codigo, String contraseña) {
        if (codigo == null || codigo.trim().isEmpty() ||
            codigo.equalsIgnoreCase("Ingrese su usuario") ||
            contraseña == null || contraseña.trim().isEmpty() ||
            contraseña.equals("wwwwwww")) {
            return "Debe ingresar su código y contraseña.";
        }

        if (!codigo.matches("\\d+")) {
            return "El código debe contener solo números.";
        }

        return "";
    }

    public String verificarUsuario(String codigo, String contrasena) {
        Estudiante estudiante = gestor.buscarEstudiantePorCodigo(codigo);

        if (estudiante == null) {
            return "No existe una cuenta con ese código.";
        }

        if (!Seguridad.validar(contrasena, estudiante.getSalt(), estudiante.getPasswordHash())) {
            return "La contraseña es incorrecta.";
        }

        return "";
    }
} 

