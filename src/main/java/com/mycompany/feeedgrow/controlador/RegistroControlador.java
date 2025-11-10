package com.mycompany.feeedgrow.controlador;

import com.mycompany.feeedgrow.modelo.Estudiante;
import com.mycompany.feeedgrow.modelo.GestorDatos;
import java.util.List;

public class RegistroControlador {
    GestorDatos gestor = new GestorDatos();


    public String validarEstudiante(Estudiante estudiante, String confirmarContraseña) {
        String[] placeholders = {
        "Nombre", "Seleccione su carrera", 
        "Código de estudiante", "Contraseña", "Confirmar Contraseña"
        };

        StringBuilder errores = new StringBuilder();

        if (estudiante.getNombre().isEmpty() || estudiante.getNombre().equalsIgnoreCase(placeholders[0])) {
            errores.append("Debe ingresar su nombre completo.\n");
        }

        if (estudiante.getCódigo().isEmpty() || estudiante.getCódigo().equalsIgnoreCase(placeholders[2])) {
            errores.append("Debe ingresar su código estudiantil.\n");
        } else if (!estudiante.getCódigo().matches("\\d+")) {
            errores.append("El código solo puede contener números.\n");
        }
        //el correo no se vlaida porque no es relevante

        if (estudiante.getCarrera().isEmpty() || estudiante.getCarrera().equalsIgnoreCase(placeholders[1])) {
            errores.append("Debe ingresar su carrera.\n");
        }

        if (estudiante.getContraseña().isEmpty()  || estudiante.getContraseña().equalsIgnoreCase(placeholders[3])) {
            errores.append("Debe ingresar una contraseña.\n");
        }

        if (confirmarContraseña.isEmpty()  || confirmarContraseña.equalsIgnoreCase(placeholders[4])) {
            errores.append("Debe confirmar la contraseña.\n");
        } else if (!estudiante.getContraseña().equals(confirmarContraseña)) {
            errores.append("Las contraseñas no coinciden.\n");
        }

        return errores.toString().trim(); // Si está vacío, todo está bien
    }

    public String registrarEstudiante(Estudiante nuevo) {
        gestor.cargarEstudiantes();
        List<Estudiante> estudiantes = gestor.obtenerEstudiantes();

        // Verificar si ya existe un estudiante con el mismo código
        for (Estudiante e : estudiantes) {
            if (e.getCódigo().equals(nuevo.getCódigo())) {
                return "Ya existe un estudiante con ese código.";
            }
        }

        gestor.registrarEstudiante(nuevo);
        return ""; // vacío = éxito
    }
}

