
package com.mycompany.feeedgrow.modelo;
import java.util.ArrayList;
public class GestorDatos {
    
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Calificación> calificaciones;

    public GestorDatos() {
        this.estudiantes = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
    }

    public void registrarEstudiante(Estudiante e) {
        this.estudiantes.add(e);
    }

    public void buscarEstudiante(String nombre) {
        //buscar por nombre (no estoy segura de esta implementación
    }

    public void agregarEvaluacion(Calificación e) {
        this.calificaciones.add(e);
        e.getEvaluador().agregarCalificacionHecha(e);
        e.getEvaluado().agregarCalificacionRecibida(e);
    }

    public String top3() {
       /*que compare los promedios y de como respuesta una lista, que bien puede ser un atrirbuto
        si se desea, el caso es que lo ordene de mayor a menor*/
       return "en realidad debe retornar un array o ser vacio y modificar el atributo";
    }
}

