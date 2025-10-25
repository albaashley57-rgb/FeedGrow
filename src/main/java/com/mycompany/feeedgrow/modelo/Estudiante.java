package com.mycompany.feeedgrow.modelo;



import java.util.ArrayList;
public class Estudiante {
    
    /*para usar cosas de herencia se podría crear una clase usuario que acortaría este código 
    y se podria argumentar con la custion de extensibilidad del proyecto a más usuarios en caso
    de que creciera, además se aplicarían mas conceptos*/
    private String nombre;
    private String usuario;//en caso de crear la clase usuario ya no sería un String
    private String carrera;
    private String correo;
    private String contrasena;
    private Perfil perfil;
    private ArrayList<Calificación> calificacionesHechas;
    private ArrayList<Calificación> calificacionesRecibidas;
    
    
    public Estudiante(String nombre, String usuario, String carrera, String correo, String contrasena) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.carrera = carrera;
        this.correo = correo;
        this.contrasena = contrasena;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
    public void agregarCalificacionRecibida(Calificación calificacion) { 
        this.calificacionesRecibidas.add(calificacion);
        this.perfil.actualizarPromedios();
     }
    
    public void agregarCalificacionHecha(Calificación calificacion) {
        this.calificacionesHechas.add(calificacion); 
    }

   
}

