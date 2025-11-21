
package com.mycompany.feedgrow.controlador;
import com.mycompany.feedgrow.modelo.Calificacion;
import com.mycompany.feedgrow.modelo.CriterioEvaluacion;
import com.mycompany.feedgrow.modelo.Estudiante;
import com.mycompany.feedgrow.persistencia.GestorDatos;
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
        String recomendacion, boolean edicion) {
        String errores = validarValores(valoresTexto);
        if (!errores.isEmpty()) return errores; 
        Map<CriterioEvaluacion, Double> valores = new java.util.HashMap<>();
        for (Map.Entry<CriterioEvaluacion, String> e : valoresTexto.entrySet()) {
            valores.put(e.getKey(), Double.parseDouble(e.getValue().trim()));
        }
        if(!edicion){
            for (Calificacion c : evaluador.getCalificacionesHechas()) {
                if (c.getEvaluado().getCodigo().equals(evaluado.getCodigo())) {
                    return "Ya existe una calificación de este evaluador para este estudiante";
                }
            }
            Calificacion nueva = new Calificacion(evaluador, evaluado, valores, titulo, recomendacion);
            evaluador.agregarCalificacionHecha(nueva);
            evaluado.agregarCalificacionRecibida(nueva);
            gestor.agregarCalificacion(nueva); //si vee, deberiamos crear un metodo que sea editarcalificacionrecibida?, busacar el mas conviencite 
            gestor.actualizarEstudiante(evaluador);
            gestor.actualizarEstudiante(evaluado);
            return "";
        }else{
            
            Calificacion b = null;
            for (Calificacion c : evaluador.getCalificacionesHechas()) {
                if (c.getEvaluado().getCodigo().equals(evaluado.getCodigo())) {
                   b = c; 
                }
            }
                String edicionError = editarCalificacion(b, valores, titulo, recomendacion);
                return edicionError;
        }
}
    
//aqui hay que revisar para cargar calificaciones recibidas dentro del estudiante, mirar porque con calificar actua normal (quizas porque ya le damos a add)
    public String editarCalificacion(Calificacion calificacion, 
                                 Map<CriterioEvaluacion, Double> nuevosValores, 
                                 String nuevoTitulo, 
                                 String nuevaRecomendacion) {

    if (calificacion == null) {
        return "La calificación que se intenta editar no existe.";
    }
    for (Map.Entry<CriterioEvaluacion, Double> entry : nuevosValores.entrySet()) {
        calificacion.actualizarCalificacion(entry.getKey(), entry.getValue());
    }
    calificacion.setTituloRecomendacion(nuevoTitulo);
    calificacion.setRecomendacion(nuevaRecomendacion);
    for (int i = 0; i < gestor.getCalificaciones().size(); i++) {
        Calificacion c = gestor.getCalificaciones().get(i);
        if (c.getEvaluador().getCodigo().equals(calificacion.getEvaluador().getCodigo()) &&
            c.getEvaluado().getCodigo().equals(calificacion.getEvaluado().getCodigo())) {

            gestor.getCalificaciones().set(i, calificacion);
            break;
        }
    }
    gestor.guardarCalificaciones();
     calificacion.getEvaluado().getPerfil().actualizarPromedios();
    return "";
}


    public String eliminarCalificacion(Estudiante evaluador, Estudiante evaluado, Calificacion calificacion) {
    evaluador.getCalificacionesHechas()
         .removeIf(c -> c.getEvaluado().getCodigo().equals(calificacion.getEvaluado().getCodigo()));
evaluado.getCalificacionesRecibidas()
         .removeIf(c -> c.getEvaluador().getCodigo().equals(calificacion.getEvaluador().getCodigo()));
    gestor.actualizarEstudiante(evaluador);
    gestor.actualizarEstudiante(evaluado);
    gestor.eliminarCalificacion(calificacion);
    gestor.guardarCalificaciones();
    evaluado.getPerfil().actualizarPromedios();
    return ""; 
    }
    
   private String validarValores(Map<CriterioEvaluacion, String> valoresTexto) {
    StringBuilder errores = new StringBuilder();

    for (Map.Entry<CriterioEvaluacion, String> entry : valoresTexto.entrySet()) {
        String texto = entry.getValue().trim();
        double v;
        try {
            v = Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            errores.append(entry.getKey().name())
                   .append(" debe ser un número válido.\n");
            continue;
        }
        if (v < 0 || v > 5) {
            errores.append(entry.getKey().name())
                   .append(" debe estar entre 0 y 5.\n");
        }
    }

    return errores.toString();
}
}


