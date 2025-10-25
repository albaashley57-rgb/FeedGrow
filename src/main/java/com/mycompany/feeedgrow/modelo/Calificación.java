
package com.mycompany.feeedgrow.modelo;

public class Calificación {
    private final Estudiante evaluador;
    private final Estudiante evaluado;
    /*/si existiera una forma mas eficiente para manejar todos estos datos y 
    recorrerlos (ya que vienen en pares) preguntar e implementarlo, habria que 
    "migrar" todas las clases*/
    private double promedio;
    private double responsabilidad;
    private double colaboracion;
    private double comunicacion;
    private double participación;
    private double compromiso;
    private double inicitiva;
    private double liderazgo;
    private double resoluciónDeConflictos;
    private double confiabilidad;
    private double actitud;
    private String atributo;
    private String recomendacion;
 

    public double getResponsabilidad() {
        return responsabilidad;
    }

    public void setResponsabilidad(double responsabilidad) {
        this.responsabilidad = responsabilidad;
    }

    public double getColaboracion() {
        return colaboracion;
    }

    public void setColaboracion(double colaboracion) {
        this.colaboracion = colaboracion;
    }

    public double getComunicacion() {
        return comunicacion;
    }

    public void setComunicacion(double comunicacion) {
        this.comunicacion = comunicacion;
    }

    public double getParticipación() {
        return participación;
    }

    public void setParticipación(double participación) {
        this.participación = participación;
    }

    public double getCompromiso() {
        return compromiso;
    }

    public void setCompromiso(double compromiso) {
        this.compromiso = compromiso;
    }

    public double getInicitiva() {
        return inicitiva;
    }

    public void setInicitiva(double inicitiva) {
        this.inicitiva = inicitiva;
    }

    public double getLiderazgo() {
        return liderazgo;
    }

    public void setLiderazgo(double liderazgo) {
        this.liderazgo = liderazgo;
    }

    public double getResoluciónDeConflictos() {
        return resoluciónDeConflictos;
    }

    public void setResoluciónDeConflictos(double resoluciónDeConflictos) {
        this.resoluciónDeConflictos = resoluciónDeConflictos;
    }

    public double getConfiabilidad() {
        return confiabilidad;
    }

    public void setConfiabilidad(double confiabilidad) {
        this.confiabilidad = confiabilidad;
    }

    public double getActitud() {
        return actitud;
    }

    public void setActitud(double actitud) {
        this.actitud = actitud;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
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


    public Calificación(Estudiante evaluador, Estudiante evaluado,double responsabilidad,
       double colaboracion, double comunicacion,double participación, double compromiso,
       double inicitiva,double liderazgo,double resoluciónDeConflictos,double confiabilidad,
       double actitud,String atributo,String recomendacion) {
        
        this.evaluador = evaluador;
        this.evaluado = evaluado;
        this.responsabilidad = responsabilidad;
        //hacerlos concordar con cada uno de los atributos
        //y que aquí se calcule el promedio o hacer un metodo por fuera que se llame aquí
       
    }

  

    
}

