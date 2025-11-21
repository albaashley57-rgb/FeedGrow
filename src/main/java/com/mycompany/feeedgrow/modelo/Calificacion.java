
package com.mycompany.feeedgrow.modelo;

import java.util.EnumMap;
import java.util.Map;

public class Calificacion {
    private final Estudiante evaluador;
    private final Estudiante evaluado;
    private double promedio;
    private Map<CriterioEvaluacion, Double> calificaciones;
    private String titulorecomendacion;
    private String recomendacion;

    public Calificacion(Estudiante evaluador, Estudiante evaluado, Map<CriterioEvaluacion, Double> calificaciones,
            String titulorecomendacion, String recomendacion) {
        this.evaluador = evaluador;
        this.evaluado = evaluado;
        this.calificaciones = new EnumMap<>(calificaciones);
        this.titulorecomendacion = titulorecomendacion;
        this.recomendacion = recomendacion;
        this.promedio = calcularPromedio();
    }

    private double calcularPromedio() {
        return calificaciones.values().stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public void actualizarCalificacion(CriterioEvaluacion criterio, double valor) {
        calificaciones.put(criterio, valor);
        promedio = calcularPromedio();
    }

    public double getPromedio() {
        return promedio;
    }

    public Estudiante getEvaluador() {
        return evaluador;
    }

    public Estudiante getEvaluado() {
        return evaluado;
    }

    public Map<CriterioEvaluacion, Double> getCalificaciones() {
        return calificaciones;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public String getTituloRecomendacion() {
        return titulorecomendacion;
    }

    public void setTituloRecomendacion(String titulorecomendacion) {
        this.titulorecomendacion = titulorecomendacion;
    }
    
    
    @Override
    public String toString(){
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<CriterioEvaluacion, Double> entry : calificaciones.entrySet()) {
        sb.append(entry.getKey()).append(":").append(entry.getValue()).append(";");
    }
    if (sb.length() > 0) {
        sb.deleteCharAt(sb.length() - 1);
    }
    return evaluador.getNombre() + "," + evaluado.getNombre() + "," + sb.toString() + "," + titulorecomendacion + "," + recomendacion;
    }

}


