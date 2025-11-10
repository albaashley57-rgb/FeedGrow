package com.mycompany.feeedgrow.modelo;



import java.util.ArrayList;
public class Estudiante {
   
    private String nombre;
    private String código;
    private String carrera;
    private String correo;
    private String contraseña;
    private Perfil perfil;
    private ArrayList<Calificación> calificacionesHechas;
    private ArrayList<Calificación> calificacionesRecibidas;
    
    
    public Estudiante(String nombre, String código, String carrera, String correo, String contrasena) {
        this.nombre = nombre;
        this.código = código;
        this.carrera = carrera;
        this.correo = correo;
        this.contraseña = contrasena;
        this.calificacionesHechas = new ArrayList<>();
        this.calificacionesRecibidas = new ArrayList<>();
        this.perfil = new Perfil(this);
    }

    /*getters &setters (si llegan a existir unos que no se usen eliminar, igual para todas las clase
    sin embargo es algo que se hara al final dedspues de implementar ttodo para no tener codigo
    innecesario)*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCódigo() {
        return código;
    }

    public void setCódigo(String código) {
        this.código = código;
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

    public void setCalificacionesHechas(ArrayList<Calificación> calificacionesHechas) {
        this.calificacionesHechas = calificacionesHechas;
    }

    public ArrayList<Calificación> getCalificacionesRecibidas() {
        return calificacionesRecibidas;
    }

    public void setCalificacionesRecibidas(ArrayList<Calificación> calificacionesRecibidas) {
        this.calificacionesRecibidas = calificacionesRecibidas;
    }
    
     public Perfil getPerfil() { 
         return perfil; 
     }
    


    // Métodos (revisar lógica y si son necesarios más)
    public void agregarCalificacionRecibida(Calificación calificación) { 
        this.calificacionesRecibidas.add(calificación);
        this.perfil.actualizarPromedios();
     }
    
    public void agregarCalificacionHecha(Calificación calificación) {
        this.calificacionesHechas.add(calificación); 
    }

   @Override
   public String toString(){
       return this.código + "," + this.nombre + "," + this.correo + "," +  this.carrera + "," + this.contraseña;
   }
}

