
package com.mycompany.feeedgrow.modelo;

import java.util.ArrayList;
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
        // Inicializar suma por criterio
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

    private void actualizarMejoresAtributos() {
        List<Map.Entry<CriterioEvaluacion, Double>> lista = new ArrayList<>(promediosPorCriterio.entrySet());
        lista.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        for (int i = 0; i < 3; i++) {
            mejoresAtributos[i] = (i < lista.size()) ? lista.get(i).getKey().name() : "";
        }
    }

    public double getPromedio(CriterioEvaluacion criterio) {
        return promediosPorCriterio.getOrDefault(criterio, 0.0);
    }

    public double getPromedioGlobal() { 
        return promedioGlobal; 
    }

    public String getMejoresAtributos() { 
        return mejoresAtributos[0] +","+ mejoresAtributos[1] + ", " + mejoresAtributos[2]; 
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public List<Calificacion> getCalificacionesRecibidas() {
        return calificacionesRecibidas;
    }
    
}

  
  
