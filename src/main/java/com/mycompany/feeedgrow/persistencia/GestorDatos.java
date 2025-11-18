
package com.mycompany.feeedgrow.persistencia;

import com.mycompany.feeedgrow.modelo.Calificacion;
import com.mycompany.feeedgrow.modelo.CriterioEvaluacion;
import com.mycompany.feeedgrow.modelo.Estudiante;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GestorDatos {

      
    private final File archivoEstudiantes = new File("estudiantes.txt");
    private final File archivoCalificaciones = new File("calificaciones.txt");
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Calificacion> calificaciones;
 

    public GestorDatos() {
        this.calificaciones = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
        cargarEstudiantes();
        cargarCalificaciones();
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
                        datos[3].trim(), // carrera
                        datos[2].trim(), // correo
                        datos[4].trim()  // contraseña
                    );
                    estudiantes.add(e);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

 public void cargarCalificaciones() {
        calificaciones.clear();
        if (!archivoCalificaciones.exists()) {
            System.out.println("El archivo no existe todavía. Se creará al registrar el primer estudiante.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoCalificaciones))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",", 5); 
            if (datos.length == 5) {
                String nombreEvaluador = datos[0].trim();
                String nombreEvaluado = datos[1].trim();
                String califStr = datos[2].trim();
                String tituloRecomendacion = datos[3].trim();
                String recomendacion = datos[4].trim();

                // Reconstruir el Map de calificaciones
                Map<CriterioEvaluacion, Double> map = new EnumMap<>(CriterioEvaluacion.class);
                if (!califStr.isEmpty()) {
                    String[] pares = califStr.split(";");
                    for (String par : pares) {
                        String[] c = par.split(":");
                        if (c.length == 2) {
                            CriterioEvaluacion criterio = CriterioEvaluacion.valueOf(c[0]);
                            double valor = Double.parseDouble(c[1]);
                            map.put(criterio, valor);
                        }
                    }
                }

                Estudiante evaluador = buscarEstudiantePorNombre(nombreEvaluador); 
                Estudiante evaluado = buscarEstudiantePorNombre(nombreEvaluado);

                Calificacion c = new Calificacion(evaluador, evaluado, map, tituloRecomendacion, recomendacion);
                calificaciones.add(c);
                evaluado.agregarCalificacionRecibida(c);
                evaluador.agregarCalificacionHecha(c);
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
    
     public void guardarCalificaciones() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoCalificaciones))) {
            for (Calificacion c : calificaciones) {
                writer.write(c.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }


    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    
    public List<Calificacion> getCalificaciones(){
        return calificaciones;
    }

    public void registrarEstudiante(Estudiante nuevo) {
        estudiantes.add(nuevo);
        guardarEstudiantes();
    }
    
    public void agregarCalificacion(Calificacion e) {
         if (!existeCalificacionDuplicada(e)) {
            this.calificaciones.add(e);
            e.getEvaluador().agregarCalificacionHecha(e);
            e.getEvaluado().agregarCalificacionRecibida(e);
            guardarCalificaciones();
         }
    }

    public Estudiante buscarEstudiantePorCodigo(String codigo) {
        for (Estudiante e : estudiantes) {
            if (e.getCodigo().equals(codigo)) {
                return e;
            }
        }
        return null;
    }
    public Estudiante buscarEstudiantePorNombre(String nombre) {
        for (Estudiante e : estudiantes) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        return null;
    }
    
  public List<Estudiante> buscarEstudiantesCalificadosPorEvaluador(Estudiante evaluador) {
    if (evaluador == null || evaluador.getCodigo() == null) {
        return java.util.Collections.emptyList();
    }

    return calificaciones.stream()
            .filter(c -> c.getEvaluador() != null
                      && c.getEvaluador().getCodigo().equals(evaluador.getCodigo()))
            .map(Calificacion::getEvaluado)
            .distinct() // evita repetidos
            .collect(Collectors.toList());
}

public Calificacion buscarCalificacionPorEvaluadorYEvaluado(Estudiante evaluador, Estudiante evaluado) {
    if (evaluador == null || evaluado == null) {
        return null;
    }
    String codigoEval = evaluador.getCodigo();
    String codigoEvado = evaluado.getCodigo();
    if (codigoEval == null || codigoEvado == null) {
        return null;
    }
    for (Calificacion c : calificaciones) {
        if (c.getEvaluador() != null && c.getEvaluado() != null &&
            codigoEval.equals(c.getEvaluador().getCodigo()) &&
            codigoEvado.equals(c.getEvaluado().getCodigo())) {

            return c;
        }
    }
    return null; 
}

    public List<Estudiante> top3() {
        return estudiantes.stream()
                .sorted((a, b) -> Double.compare(b.getPerfil().getPromedioGlobal(), a.getPerfil().getPromedioGlobal()))
                .limit(3)
                .collect(Collectors.toList());
    }
    
       private boolean existeCalificacionDuplicada(Calificacion evaluacion) {
        for (Calificacion c : calificaciones) {
            if (c.getEvaluador().equals(evaluacion.getEvaluador()) &&
                c.getEvaluado().equals(evaluacion.getEvaluado())) {
                return true;
            }
        }
        return false;
    }
    public void actualizarEstudiante(Estudiante estudianteActualizado) {
    for (int i = 0; i < estudiantes.size(); i++) {
        Estudiante e = estudiantes.get(i);
        if (e.getCodigo().equals(estudianteActualizado.getCodigo())) {
            // Reemplaza el objeto antiguo por el actualizado
            estudiantes.set(i, estudianteActualizado);
            guardarEstudiantes(); // persistencia
            return;
        }
    }
}
    
}

