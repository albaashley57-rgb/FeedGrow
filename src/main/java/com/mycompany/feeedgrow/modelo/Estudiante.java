package com.mycompany.feeedgrow.modelo;


import java.util.ArrayList;
public class Estudiante {
   
    private final String nombre;
    private final String código;
    private String carrera;
    private String correo;
    private String contraseña;
    private double promedioGlobal;
    private final Perfil perfil;
    private final ArrayList<Calificación> calificacionesHechas;
    private final ArrayList<Calificación> calificacionesRecibidas;
    
    
    public Estudiante(String nombre, String código, String carrera, String correo, String contrasena) {
        this.nombre = nombre;
        this.código = código;
        this.carrera = carrera;
        this.correo = correo;
        this.contraseña = contrasena;
        this.calificacionesHechas = new ArrayList<>();
        this.calificacionesRecibidas = new ArrayList<>();
        this.perfil = new Perfil(this);
        this.promedioGlobal = this.perfil.getPromedioGlobal();
    }

    /*getters &setters (si llegan a existir unos que no se usen eliminar, igual para todas las clase
    sin embargo es algo que se hara al final dedspues de implementar ttodo para no tener codigo
    innecesario)*/
    public String getNombre() {
        return nombre;
    }

    public double getPromedioGlobal() {
        return promedioGlobal;
    }

    public String getCódigo() {
        return código;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public ArrayList<Calificación> getCalificacionesHechas() {
        return calificacionesHechas;
    }


    public ArrayList<Calificación> getCalificacionesRecibidas() {
        return calificacionesRecibidas;
    }

     public Perfil getPerfil() { 
         return perfil; 
     }
    

    public void agregarCalificacionRecibida(Calificación calificación) { 
        this.calificacionesRecibidas.add(calificación);
        this.perfil.actualizarPerfil();
        
     }
    
    public void agregarCalificacionHecha(Calificación calificación) {
        this.calificacionesHechas.add(calificación); 
        calificación.getEvaluado().perfil.actualizarPerfil();
    }

   @Override
   public String toString(){
       return this.código + "," + this.nombre + "," + this.correo + "," +  this.carrera + ","+this.contraseña;
   }
    
   

    // quizás lo de editar el "perfil" es mejor editar el estudiante enlazado a él
}

