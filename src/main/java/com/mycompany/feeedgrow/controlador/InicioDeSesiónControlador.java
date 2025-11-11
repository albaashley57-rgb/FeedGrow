package com.mycompany.feeedgrow.controlador;
import com.mycompany.feeedgrow.modelo.Estudiante;
import com.mycompany.feeedgrow.modelo.GestorDatos;

public class InicioDeSesiónControlador {
private GestorDatos gestor = new GestorDatos();

    public GestorDatos getGestor() {
        return gestor;
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

        return ""; // todo bien
    }

    public String verificarUsuario(String codigo, String contraseña) {
        Estudiante estudiante = gestor.buscarPorCodigo(codigo);

        if (estudiante == null) {
            return "No existe una cuenta con ese código.";
        }

        if (!estudiante.getContraseña().equals(contraseña)) {
            return "La contraseña es incorrecta.";
        }

        return ""; // todo bien
    }
} 

