
package com.mycompany.feeedgrow.modelo;
import java.util.ArrayList;
public class Perfil {
    private Estudiante estudiante;
    private ArrayList<Calificación> calificacionesRecibidas;
    // promedios precalculados
    /*para cuestiones esteticas podría crearse un atributo color y una clase color 
    con valores rgb y un metodo para generar colores al azar y se creen colores al 
    azar por defecto para la "foto" de perfil, que pues esta sería como una imagen 
    a la que solo se le cambia el color*/
    private double promedioResponsabilidad;
    private double promedioColaboracion;
    private double promedioComunicacion;
    private double promedioParticipación;
    private double promedioCompromiso;
    private double promedioInicitiva;
    private double promedioLiderazgo;
    private double promedioResoluciónDeConflictos;
    private double promedioConfiabilidad;
    private double promedioActitud;
    private double promedioGlobal;
    private String[] mejoresAtributos;

    public Perfil(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.calificacionesRecibidas = estudiante.getCalificacionesRecibidas();
        this.mejoresAtributos = new String[3];
        this.actualizarPromedios();
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public ArrayList<Calificación> getCalificacionesRecibidas() {
        return calificacionesRecibidas;
    }

    public void setCalificacionesRecibidas(ArrayList<Calificación> calificacionesRecibidas) {
        this.calificacionesRecibidas = calificacionesRecibidas;
    }

    public double getPromedioResponsabilidad() {
        return promedioResponsabilidad;
    }

    public void setPromedioResponsabilidad(double promedioResponsabilidad) {
        this.promedioResponsabilidad = promedioResponsabilidad;
    }

    public double getPromedioColaboracion() {
        return promedioColaboracion;
    }

    public void setPromedioColaboracion(double promedioColaboracion) {
        this.promedioColaboracion = promedioColaboracion;
    }

    public double getPromedioParticipación() {
        return promedioParticipación;
    }

    public void setPromedioParticipación(double promedioParticipación) {
        this.promedioParticipación = promedioParticipación;
    }

    public double getPromedioCompromiso() {
        return promedioCompromiso;
    }

    public void setPromedioCompromiso(double promedioCompromiso) {
        this.promedioCompromiso = promedioCompromiso;
    }

    public double getPromedioInicitiva() {
        return promedioInicitiva;
    }

    public void setPromedioInicitiva(double promedioInicitiva) {
        this.promedioInicitiva = promedioInicitiva;
    }

    public double getPromedioResoluciónDeConflictos() {
        return promedioResoluciónDeConflictos;
    }

    public void setPromedioResoluciónDeConflictos(double promedioResoluciónDeConflictos) {
        this.promedioResoluciónDeConflictos = promedioResoluciónDeConflictos;
    }

    public double getPromedioConfiabilidad() {
        return promedioConfiabilidad;
    }

    public void setPromedioConfiabilidad(double promedioConfiabilidad) {
        this.promedioConfiabilidad = promedioConfiabilidad;
    }

    public double getPromedioActitud() {
        return promedioActitud;
    }

    public void setPromedioActitud(double promedioActitud) {
        this.promedioActitud = promedioActitud;
    }

    public String[] getMejoresAtributos() {
        return mejoresAtributos;
    }

    public void setMejoresAtributos(String[] mejoresAtributos) {
        this.mejoresAtributos = mejoresAtributos;
    }
    

    public void actualizarPromedios() {
        if (this.calificacionesRecibidas.isEmpty()) {
           this.promedioLiderazgo = this.promedioComunicacion  = this.promedioGlobal = 0;//por ejemplo, obvio hacer para todos
            for (int i=0; i<3; i++){
            this.mejoresAtributos [i] = " ";
            }
        }else{

            double sumaL = 0, sumaC = 0;
            for (Calificación e : this.calificacionesRecibidas) {
                sumaL += e.getLiderazgo();
                sumaC += e.getComunicacion();
                //toca poner la suma por atributo y por promedio para hallar promedios globales y así
            }

            int n = this.calificacionesRecibidas.size();
           this.promedioLiderazgo = sumaL / n;
           this.promedioComunicacion = sumaC / n;
           
           this.actualizarMejoresAtributo();
        }
        
        
    }
 

    private void actualizarMejoresAtributo() {
        /*este metodo tiene que revisar en la lsita de calificaciones y ver cuales
        Strings se repiten maas veces en el atributo "atributo"(recomendaria cambiar
        el nombre para no confundrnod pero el caso es que se refiere como a la mejor 
        habilidad y escoger los primeros tres para el vector*/
      
    }
    
}
  
  
