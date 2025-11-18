
package com.mycompany.feeedgrow.controlador;
import com.mycompany.feeedgrow.modelo.Calificacion;
import com.mycompany.feeedgrow.modelo.CriterioEvaluacion;
import com.mycompany.feeedgrow.modelo.Estudiante;
import com.mycompany.feeedgrow.persistencia.GestorDatos;
import java.util.Map;
public class CalificarControlador {
  
    private final GestorDatos gestor;

    public CalificarControlador(GestorDatos gestor) {
        this.gestor = gestor;
    }

    public String agregarCalificacion(
        Estudiante evaluador, 
        Estudiante evaluado,
        Map<CriterioEvaluacion, String> valoresTexto,
        String titulo, 
        String recomendacion) {

    // VALIDACIÓN PRIMERO
    String errores = validarValores(valoresTexto);
    if (!errores.isEmpty()) return errores;

    // Convertimos a double SOLO después de validar
    Map<CriterioEvaluacion, Double> valores = new java.util.HashMap<>();
    for (Map.Entry<CriterioEvaluacion, String> e : valoresTexto.entrySet()) {
        valores.put(e.getKey(), Double.parseDouble(e.getValue().trim()));
    }

    // Evitar calificar dos veces
    for (Calificacion c : evaluador.getCalificacionesHechas()) {
        if (c.getEvaluado().getCodigo().equals(evaluado.getCodigo())) {
            return "Ya existe una calificación de este evaluador para este estudiante";
        }
    }

    // Crear y guardar calificación
    Calificacion nueva = new Calificacion(evaluador, evaluado, valores, titulo, recomendacion);
    evaluador.agregarCalificacionHecha(nueva);
    evaluado.agregarCalificacionRecibida(nueva);

    gestor.agregarCalificacion(nueva);
    gestor.actualizarEstudiante(evaluador);
    gestor.actualizarEstudiante(evaluado);

    return "";
}

    public String editarCalificacion(Calificacion calificacion, Map<CriterioEvaluacion, Double> nuevosValores, String nuevoTitulo, String nuevaRecomendacion) {
        for (Map.Entry<CriterioEvaluacion, Double> entry : nuevosValores.entrySet()) {
            calificacion.actualizarCalificacion(entry.getKey(), entry.getValue());//revisar como funciona esto
        }
        calificacion.setTituloRecomendacion(nuevoTitulo);
        calificacion.setRecomendacion(nuevaRecomendacion);
        return ""; 
    }

    public String eliminarCalificacion(Estudiante evaluador, Calificacion calificacion) {
        evaluador.getCalificacionesHechas().remove(calificacion);
        calificacion.getEvaluado().getCalificacionesRecibidas().remove(calificacion);
        gestor.actualizarEstudiante(evaluador);
        gestor.actualizarEstudiante(calificacion.getEvaluado());
        return ""; 
    }
    
   private String validarValores(Map<CriterioEvaluacion, String> valoresTexto) {
    StringBuilder errores = new StringBuilder();

    for (Map.Entry<CriterioEvaluacion, String> entry : valoresTexto.entrySet()) {
        String texto = entry.getValue().trim();

        // ¿Campo vacío o letra?
        double v;
        try {
            v = Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            errores.append(entry.getKey().name())
                   .append(" debe ser un número válido.\n");
            continue;
        }

        // ¿Rango?
        if (v < 0 || v > 5) {
            errores.append(entry.getKey().name())
                   .append(" debe estar entre 0 y 5.\n");
        }
    }

    return errores.toString();
}
}


