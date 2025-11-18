package com.mycompany.feeedgrow.modelo;


import java.util.ArrayList;
public class Estudiante {
   
    private final String nombre;
    private final String codigo;
    private String carrera;
    private String correo;
    private String contrasena;
    private double promedioGlobal;
    private final Perfil perfil;
    private final ArrayList<Calificacion> calificacionesHechas;
    private final ArrayList<Calificacion> calificacionesRecibidas;
    

    public Estudiante(String nombre, String codigo, String carrera, String correo, String contrasena) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.carrera = carrera;
        this.correo = correo;
        this.contrasena = contrasena;
        this.calificacionesHechas = new ArrayList<>();
        this.calificacionesRecibidas = new ArrayList<>();
        this.perfil = new Perfil(this);
    }

    // Getters y setters simplificados para claridad

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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena; // considerar hashing para producción */
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

    public void editarPerfil(String carrera, String correo, String nuevaContrasena) {
        setCarrera(carrera);
        setCorreo(correo);
        setContrasena(nuevaContrasena); // Aquí debería usarse hash
    }
//revisaa

    public Calificacion buscarCalificacionHechaPorEstudiante(String codigo) {
        for (Calificacion c : calificacionesHechas) {
            if (c.getEvaluado().getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }

  
    public void editarCalificacion(Calificacion calificacion) {
        for (int i = 0; i < calificacionesRecibidas.size(); i++) {
            Calificacion c = calificacionesRecibidas.get(i);
            if (c.getEvaluador().getCodigo().equals(calificacion.getEvaluador().getCodigo())) {
                calificacionesRecibidas.set(i, calificacion);
                this.perfil.actualizarPromedios();
                break;
            }
        }
    }

    public void eliminarCalificacion(Calificacion calificacion) {
        calificacionesRecibidas.remove(calificacion);
        this.perfil.actualizarPromedios();
    }

   @Override
   public String toString(){
       return this.codigo + "," + this.nombre + "," + this.correo + "," +  this.carrera + ","+this.contrasena;
   }

}

