
package com.mycompany.feeedgrow.modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Calificación {
    private final Estudiante evaluador; //cambiar a calificacdor y calificado
    private final Estudiante evaluado;
    private double promedio;
    private final Map<String, Double> calificaciones;
    private String atributo;
    private String títuloRecomendación;
    private String recomendación;


    public Calificación(Estudiante evaluador, Estudiante evaluado,double responsabilidad,
       double colaboración, double comunicación,double participación, double compromiso,
       double iniciativa,double liderazgo,double resoluciónDeConflictos,double confiabilidad,
       double actitud,String atributo,String títuloRecomendación, String recomendación) {
        
           this.evaluador = evaluador;
           this.evaluado = evaluado;
           this.calificaciones = new HashMap<>();
            calificaciones.put("responsabilidad", responsabilidad);
            calificaciones.put("colaboración", colaboración);
            calificaciones.put("comunicación", comunicación);
            calificaciones.put("participacion", participación);
            calificaciones.put("compromiso", compromiso);
            calificaciones.put("iniciativa", iniciativa);
            calificaciones.put("liderazgo", liderazgo);
            calificaciones.put("resolución de conflictos", resoluciónDeConflictos);
            calificaciones.put("confiabilidad", confiabilidad);
            calificaciones.put("actitud", actitud);
           this.atributo = atributo;
           this.recomendación = recomendación;
           this.títuloRecomendación = títuloRecomendación;
           this.promedio = calcularPromedioLocal();
    }

  private double calcularPromedioLocal(){
    double suma = 0;
    Collection valores = calificaciones.values();
    for(Object valor: valores){
        suma += (double)valor;
    }
    return suma / 10; 
  }

  public double getCalificaciónÁrea(String área){
       return calificaciones.get(área);
   }

    public Estudiante getEvaluador() {
        return evaluador;
    }

    public Estudiante getEvaluado() {
        return evaluado;
    }

    public double getPromedio() {
        return promedio;
    }

    public String getAtributo() {
        return atributo;
    }

    public String getTítuloRecomendación() {
        return títuloRecomendación;
    }

    public String getRecomendación() {
        return recomendación;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public void setTítuloRecomendación(String títuloRecomendación) {
        this.títuloRecomendación = títuloRecomendación;
    }

    public void setRecomendación(String recomendación) {
        this.recomendación = recomendación;
    }
   //determinar la mejor logica para editar calificaciones, lo mismo en perfil para editar mi perfil
   
           
}

