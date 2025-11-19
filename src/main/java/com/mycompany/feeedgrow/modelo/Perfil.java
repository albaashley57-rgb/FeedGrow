
package com.mycompany.feeedgrow.modelo;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;


public class Perfil {
    
private final Estudiante estudiante;
private final List<Calificacion> calificacionesRecibidas;
private Map<CriterioEvaluacion, Double> promediosPorCriterio;
private double promedioGlobal;
private String[] mejoresAtributos;

    public Perfil(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.calificacionesRecibidas = estudiante.getCalificacionesRecibidas();
        this.promediosPorCriterio = new EnumMap<>(CriterioEvaluacion.class);
        this.mejoresAtributos = new String[3];
        actualizarPromedios();
    }

    public void actualizarPromedios() {
        Map<CriterioEvaluacion, Double> sumas = new EnumMap<>(CriterioEvaluacion.class);
        for (CriterioEvaluacion criterio : CriterioEvaluacion.values()) {
            sumas.put(criterio, 0.0);
        }
        int n = (calificacionesRecibidas != null) ? calificacionesRecibidas.size() : 0;
        if (n == 0) {
            for (CriterioEvaluacion criterio : CriterioEvaluacion.values()) {
                promediosPorCriterio.put(criterio, 0.0);
            }
            promedioGlobal = 0;
            actualizarMejoresAtributos();
            return;
        }
        for (Calificacion c : calificacionesRecibidas) {
            Map<CriterioEvaluacion, Double> califs = c.getCalificaciones();
            for (CriterioEvaluacion criterio : CriterioEvaluacion.values()) {
                sumas.put(criterio, sumas.get(criterio) + califs.getOrDefault(criterio, 0.0));
            }
        }
        double sumaGlobal = 0;
        for (CriterioEvaluacion criterio : CriterioEvaluacion.values()) {
            double prom = sumas.get(criterio) / n;
            promediosPorCriterio.put(criterio, prom);
            sumaGlobal += prom;
        }
        promedioGlobal = sumaGlobal / CriterioEvaluacion.values().length;
        actualizarMejoresAtributos();
    }
// aqui es que hay que revisar para el null
    private void actualizarMejoresAtributos() {
        Arrays.fill(mejoresAtributos, null);
        java.util.List<java.util.Map.Entry<CriterioEvaluacion, Double>> lista =
                new java.util.ArrayList<>(promediosPorCriterio.entrySet());
        lista.removeIf(e -> e.getValue() == null || e.getValue() <= 0.0);
        if (lista.isEmpty()) {
            return;
        }
        lista.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));
        int limite = Math.min(3, lista.size());
        for (int i = 0; i < limite; i++) {
            mejoresAtributos[i] = lista.get(i).getKey().name(); 
    }
}

    public double getPromedio(CriterioEvaluacion criterio) {
        return promediosPorCriterio.getOrDefault(criterio, 0.0);
    }

    public double getPromedioGlobal() { 
        return promedioGlobal; 
    }

    public String getMejoresAtributos() { 
        if (mejoresAtributos == null)return "";
        return mejoresAtributos[0] +","+ mejoresAtributos[1] + ", " + mejoresAtributos[2]; 
        }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public List<Calificacion> getCalificacionesRecibidas() {
        return calificacionesRecibidas;
    }
    
}

  
  
