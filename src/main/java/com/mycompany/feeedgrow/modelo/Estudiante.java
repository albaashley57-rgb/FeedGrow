package com.mycompany.feeedgrow.modelo;
import java.util.ArrayList;
public class Estudiante {
   
    private final String nombre;
    private final String codigo;
    private String carrera;
    private String correo;
    private double promedioGlobal;
    private final Perfil perfil;
    private final ArrayList<Calificacion> calificacionesHechas;
    private final ArrayList<Calificacion> calificacionesRecibidas;
    private String passwordHash;
    private String salt;


    public Estudiante(String nombre, String codigo, String carrera, String correo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.carrera = carrera;
        this.correo = correo;
        this.calificacionesHechas = new ArrayList<>();
        this.calificacionesRecibidas = new ArrayList<>();
        this.perfil = new Perfil(this);
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }



    public String getNombre() {
        return this.nombre;
    }

  
    public String getCodigo() {
        return this.codigo;
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

    public ArrayList<Calificacion> getCalificacionesHechas() {
        return calificacionesHechas;
    }

    public ArrayList<Calificacion> getCalificacionesRecibidas() {
        return calificacionesRecibidas;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void agregarCalificacionRecibida(Calificacion calificacion) {
        this.calificacionesRecibidas.add(calificacion);
        this.perfil.actualizarPromedios();
    }

    public void agregarCalificacionHecha(Calificacion calificacion) {
        this.calificacionesHechas.add(calificacion);
    }
public void setContrasena(String nuevaContrasena){
        String localSalt = Seguridad.generarSalt();
        String hash = Seguridad.hashear(nuevaContrasena, localSalt);
        setSalt(salt);
        setPasswordHash(hash);
}
  
   @Override
   public String toString(){
       return this.codigo + "," + this.nombre + "," + this.correo + "," +  this.carrera + "," + this.salt + "," +this.passwordHash;
   }

}

