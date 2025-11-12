
package com.mycompany.feeedgrow.modelo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Perfil {
    
    private final Estudiante estudiante;
    private final Map<String, Double> promedioCalificaciones;
    private double promedioGlobal;
    private String[] mejoresAtributos;

    public Perfil(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.mejoresAtributos = new String[3];
        this.promedioCalificaciones = new HashMap();
        this.actualizarPromedios();
        this.actualizarMejoresAtributo();
    }
    
    public void actualizarPromedios(){
        promedioCalificaciones.put("responsabilidad", this.calcularPromedioPorArea("responsabilidad"));
        promedioCalificaciones.put("colaboración", this.calcularPromedioPorArea("colaboración"));
        promedioCalificaciones.put("comunicación", this.calcularPromedioPorArea("comunicación"));
        promedioCalificaciones.put("participación", this.calcularPromedioPorArea("participación"));
        promedioCalificaciones.put("compromiso", this.calcularPromedioPorArea("compromiso"));
        promedioCalificaciones.put("iniciativa", this.calcularPromedioPorArea("iniciativa"));
        promedioCalificaciones.put("liderazgo", this.calcularPromedioPorArea("liderazgo"));
        promedioCalificaciones.put("resolución de conflictos", this.calcularPromedioPorArea("resoluciónDeConflictos"));
        promedioCalificaciones.put("confiabilidad", this.calcularPromedioPorArea("confiabilidad"));
        promedioCalificaciones.put("actitud", this.calcularPromedioPorArea("actitud"));
        this.promedioGlobal = this.calcularPromedioGlobal();
    }
     
    private double calcularPromedioPorArea(String area){
        ArrayList<Calificación> calificacionesRecibidas = this.estudiante.getCalificacionesRecibidas();
        if (calificacionesRecibidas.isEmpty()){
            return 0.0;
        }
        double suma = 0;
        int contador = 0;
        for (Calificación c : calificacionesRecibidas) {
            Double valor = c.getCalificaciónÁrea(area);
            if (valor != null) {
                suma += valor;
                contador++;
            }
        }
        return contador == 0 ? 0 : suma / contador;
    }
    
    private double calcularPromedioGlobal(){
        ArrayList<Calificación> calificacionesRecibidas = this.estudiante.getCalificacionesRecibidas();
        double suma = 0.0;
        for(Calificación c : calificacionesRecibidas){
            suma += c.getPromedio();
        }
        return suma / calificacionesRecibidas.size();
    }
    
    public Estudiante getEstudiante() {
        return estudiante;
    }

    public double getPromedioGlobal() {
        return promedioGlobal;
    }

    public double getPromedio(String area){
        return promedioCalificaciones.get(area);
    }
   
    public String[] getMejoresAtributos() {
        return mejoresAtributos;
    }


    //revisar
    public void actualizarMejoresAtributo() {
        ArrayList<Calificación> calificacionesRecibidas = this.estudiante.getCalificacionesRecibidas();
        if (calificacionesRecibidas.isEmpty()) {
            this.mejoresAtributos = new String[] {"", "", ""};
            return;
        }
        Map<String, Integer> freq = new HashMap<>();
        for (Calificación c : calificacionesRecibidas) {
            String a = c.getAtributo();
            if (a != null) {
                a = a.trim();
                if (!a.isEmpty()) {
                    String key = a.toLowerCase(); 
                    freq.put(key, freq.getOrDefault(key, 0) + 1);
                }
            }
        }

    
        PriorityQueue<Map.Entry<String,Integer>> pq =
            new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<String,Integer> e : freq.entrySet()) {
            if (pq.size() < 3) {
                pq.offer(e);
            } else if (e.getValue() > pq.peek().getValue()) {
                pq.poll();
                pq.offer(e);
            }
        }

        
        this.mejoresAtributos = new String[] {"", "", ""};
        int i = pq.size() - 1;
        while (!pq.isEmpty()) {
            this.mejoresAtributos[i--] = pq.poll().getKey();
        }
      
    }
    public void actualizarPerfil(){
        this.actualizarMejoresAtributo();
        this.actualizarPromedios();
    }
    public void editarPerfil(String carrera){
        this.estudiante.setCarrera(carrera);
        //como lo que dice en calificacion de editar calificacion, no se sbae cual es la mejor forma de hacerlo
    }
}
  
  
