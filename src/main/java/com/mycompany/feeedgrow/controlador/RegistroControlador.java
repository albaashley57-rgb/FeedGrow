package com.mycompany.feeedgrow.controlador;

import com.mycompany.feeedgrow.modelo.Estudiante;
import com.mycompany.feeedgrow.persistencia.GestorDatos;
import java.util.List;

public class RegistroControlador {
 private GestorDatos gestor;
 
 public RegistroControlador(GestorDatos gestor){
     this.gestor = gestor;
     
 }
    public String validarEstudiante(Estudiante estudiante, String confirmarContraseña) {
        String[] placeholders = {
        "Nombre", "Seleccione su carrera", 
        "Código de estudiante", "Contraseña", "Confirmar Contraseña"
        };

        StringBuilder errores = new StringBuilder();

        if (estudiante.getNombre().isEmpty() || estudiante.getNombre().equalsIgnoreCase(placeholders[0])) {
            errores.append("Debe ingresar su nombre completo.\n");
        }

        if (estudiante.getCodigo().isEmpty() || estudiante.getCodigo().equalsIgnoreCase(placeholders[2])) {
            errores.append("Debe ingresar su código estudiantil.\n");
        } else if (!estudiante.getCodigo().matches("\\d+")) {
            errores.append("El código solo puede contener números.\n");
        }
        //el correo no se vlaida porque no es relevante

        if (estudiante.getCarrera().isEmpty() || estudiante.getCarrera().equalsIgnoreCase(placeholders[1])) {
            errores.append("Debe ingresar su carrera.\n");
        }

        if (estudiante.getContrasena().isEmpty()  || estudiante.getContrasena().equalsIgnoreCase(placeholders[3])) {
            errores.append("Debe ingresar una contraseña.\n");
        }

        if (confirmarContraseña.isEmpty()  || confirmarContraseña.equalsIgnoreCase(placeholders[4])) {
            errores.append("Debe confirmar la contraseña.\n");
        } else if (!estudiante.getContrasena().equals(confirmarContraseña)) {
            errores.append("Las contraseñas no coinciden.\n");
        }

        return errores.toString().trim(); // Si está vacío, todo está bien
    }

    public String registrarEstudiante(Estudiante nuevo) {
        gestor.cargarEstudiantes();
        List<Estudiante> estudiantes = gestor.getEstudiantes();

        // Verificar si ya existe un estudiante con el mismo código
        for (Estudiante e : estudiantes) {
            if (e.getCodigo().equals(nuevo.getCodigo())) {
                return "Ya existe un estudiante con ese código.";
            }
        }

        gestor.registrarEstudiante(nuevo);
        return ""; // vacío = éxito
    }
}

