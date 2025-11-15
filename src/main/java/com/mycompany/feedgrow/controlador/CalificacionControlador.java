
package com.mycompany.feedgrow.controlador;

import com.mycompany.feedgrow.modelo.Calificacion;
import com.mycompany.feedgrow.modelo.Estudiante;
import com.mycompany.feedgrow.modelo.GestorDatos;
import java.util.Map;

public class CalificacionControlador {

    private final GestorDatos gestor;

    public CalificacionControlador(GestorDatos gestor) {
        this.gestor = gestor;
    }

    // Agregar nueva calificación
    public boolean agregarCalificacion(Estudiante evaluador, Estudiante evaluado,
                                      Map<CriterioEvaluacion, Double> valores,
                                      String atributo, String titulo, String recomendacion) {
        // Validar que no haya duplicado
        for (Calificacion c : evaluador.getCalificacionesHechas()) {
            if (c.getEvaluado().getCodigo().equals(evaluado.getCodigo())) {
                return false;
            }
        }

        Calificacion nueva = new Calificacion(evaluador, evaluado, valores, atributo, titulo, recomendacion);
        evaluador.agregarCalificacionHecha(nueva);
        //gestor.actualizarEstudiante(evaluador); //revisar esto
        //gestor.actualizarEstudiante(evaluado);
        return true; // éxito
    }

    // Editar calificación existente, criterio no esta implementado
    public String editarCalificacion(Calificacion calificacion, Map<CriterioEvaluacion, Double> nuevosValores,
                                     String nuevoAtributo, String nuevoTitulo, String nuevaRecomendacion) {
        for (Map.Entry<CriterioEvaluacion, Double> entry : nuevosValores.entrySet()) {
            calificacion.actualizarCalificacion(entry.getKey(), entry.getValue());//revisar como funciona esto
        }
        calificacion.setAtributo(nuevoAtributo);
        calificacion.setTituloRecomendacion(nuevoTitulo);
        calificacion.setRecomendacion(nuevaRecomendacion);
        return ""; // éxito
    }

    // Eliminar calificación
    public String eliminarCalificacion(Estudiante evaluador, Calificacion calificacion) {
        evaluador.getCalificacionesHechas().remove(calificacion);
        calificacion.getEvaluado().getCalificacionesRecibidas().remove(calificacion);
        gestor.actualizarEstudiante(evaluador);
        gestor.actualizarEstudiante(calificacion.getEvaluado());
        return ""; // éxito
    }
}

