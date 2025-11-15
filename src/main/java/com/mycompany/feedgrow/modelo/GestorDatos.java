
package com.mycompany.feedgrow.modelo;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GestorDatos {

      
    private final File archivoEstudiantes = new File("estudiantes.txt");
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Calificacion> calificaciones;
 

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

    public void agregarEvaluacion(Calificacion e) {
        this.calificaciones.add(e);
        e.getEvaluador().agregarCalificacionHecha(e);
        e.getEvaluado().agregarCalificacionRecibida(e);
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public ArrayList<Estudiante> top3() {
        ArrayList<Estudiante> copia =new ArrayList(estudiantes);
        int n = 3;
        copia.sort(Comparator.comparingDouble(Estudiante::getPromedioGlobal).reversed());
        if (n > copia.size()) n = copia.size();
        return new ArrayList<>(copia.subList(0, n));
    }
    
    //crear un método que genere la lista omitiendo un estudiante que entre por parametro, y así 
    //reecribir los metodos búsquedapor codigo y nombre, esto es con la intención de buscar enntre mis calificaciones o así
    //o quizas implementarlo en el controlador
    
}

