
package com.mycompany.feeedgrow.modelo;

import com.mycompany.feeedgrow.controlador.RegistroControlador;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos {

      
    private final File archivoEstudiantes = new File("estudiantes.txt");
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Calificación> calificaciones;
 

    public GestorDatos() {
        this.calificaciones = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
        cargarEstudiantes();
        //luego crear el metodo cargar calificaciones
    }
    

    public void cargarEstudiantes() {
        estudiantes.clear();
        if (!archivoEstudiantes.exists()) {
            System.out.println("El archivo no existe todavía. Se creará al registrar el primer estudiante.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoEstudiantes))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 5) {
                    Estudiante e = new Estudiante(
                        datos[1].trim(), // nombre
                        datos[0].trim(), // código
                        datos[2].trim(), // correo
                        datos[3].trim(), // carrera
                        datos[4].trim()  // contraseña
                    );
                    estudiantes.add(e);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

 
    public void guardarEstudiantes() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoEstudiantes))) {
            for (Estudiante e : estudiantes) {
                writer.write(e.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    // 🔹 Métodos públicos reutilizables
    public List<Estudiante> obtenerEstudiantes() {
        return estudiantes;
    }

    public void registrarEstudiante(Estudiante nuevo) {
        estudiantes.add(nuevo);
        guardarEstudiantes();
    }

    public Estudiante buscarPorCodigo(String codigo) {
        for (Estudiante e : estudiantes) {
            if (e.getCódigo().equals(codigo)) {
                return e;
            }
        }
        return null;
    }


    public Estudiante buscarEstudiante(String nombre) {
        for (Estudiante e : estudiantes) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        return null;
    }

    public void agregarEvaluacion(Calificación e) {
        this.calificaciones.add(e);
        e.getEvaluador().agregarCalificacionHecha(e);
        e.getEvaluado().agregarCalificacionRecibida(e);
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public String top3() {
        /* ejemplo básico: ordena por promedio descendente
        estudiantes.sort((a, b) -> Float.compare(b.getPromedio(), a.getPromedio()));

        StringBuilder top = new StringBuilder("🏅 Top 3 estudiantes:\n");
        for (int i = 0; i < Math.min(3, estudiantes.size()); i++) {
            Estudiante e = estudiantes.get(i);
            top.append((i + 1) + ". " + e.getNombre() + " - Promedio: " + e.getPromedio() + "\n");
        }

        return top.toString();*/ //REVISAR
        return"";
    }
}

