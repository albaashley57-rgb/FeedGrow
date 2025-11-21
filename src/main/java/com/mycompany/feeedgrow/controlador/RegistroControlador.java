package com.mycompany.feeedgrow.controlador;

import com.mycompany.feeedgrow.modelo.Estudiante;
import com.mycompany.feeedgrow.persistencia.GestorDatos;
import java.util.List;

public class RegistroControlador {
 private GestorDatos gestor;
 
 public RegistroControlador(GestorDatos gestor){
     this.gestor = gestor;
     
 }
    public String validarEstudiante(String nombre, String codigo, String carrera, String contrasena, String confirmarContrasena) {
        String[] placeholders = {
        "Nombre", "Seleccione su carrera", 
        "Código de estudiante", "Contraseña", "Confirmar Contraseña"
        };

        StringBuilder errores = new StringBuilder();

        if (nombre.isEmpty() || nombre.equalsIgnoreCase(placeholders[0])) {
            errores.append("Debe ingresar su nombre completo.\n");
        }

        if (codigo.isEmpty() || codigo.equalsIgnoreCase(placeholders[2])) {
            errores.append("Debe ingresar su código estudiantil.\n");
        } else if (!codigo.matches("\\d+")) {
            errores.append("El código solo puede contener números.\n");
        }
        if (carrera.isEmpty() || carrera.equalsIgnoreCase(placeholders[1])) {
            errores.append("Debe ingresar su carrera.\n");
        }

        if (contrasena.isEmpty()  || contrasena.equalsIgnoreCase(placeholders[3])) {
            errores.append("Debe ingresar una contraseña.\n");
        }

        if (confirmarContrasena.isEmpty()  || confirmarContrasena.equalsIgnoreCase(placeholders[4])) {
            errores.append("Debe confirmar la contraseña.\n");
        } else if (!contrasena.equals(confirmarContrasena)) {
            errores.append("Las contraseñas no coinciden.\n");
        }

        return errores.toString().trim();
    }

    public String registrarEstudiante(Estudiante nuevo) {
        gestor.cargarEstudiantes();
        List<Estudiante> estudiantes = gestor.getEstudiantes();
        for (Estudiante e : estudiantes) {
            if (e.getCodigo().equals(nuevo.getCodigo())) {
                return "Ya existe un estudiante con ese código.";
            }
        }

        gestor.registrarEstudiante(nuevo);
        return ""; 
    }
}

