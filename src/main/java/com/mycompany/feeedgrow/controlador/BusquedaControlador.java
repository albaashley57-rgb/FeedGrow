package com.mycompany.feeedgrow.controlador;
import com.mycompany.feeedgrow.modelo.Estudiante;


import java.util.List;
import java.util.stream.Collectors;

public class BusquedaControlador {


    public List<Estudiante> buscar(String nombre, String carrera, Estudiante usuario, List<Estudiante> lista) {

        if (nombre != null && !nombre.isEmpty()) {
            String nombreLower = nombre.toLowerCase();
            lista = lista.stream()
                    .filter(e -> e.getNombre() != null && e.getNombre().toLowerCase().contains(nombreLower))
                    .collect(Collectors.toList());
        }

        if (carrera != null && !carrera.equalsIgnoreCase("Seleccione carrera")) {
            String carreraLower = carrera.toLowerCase();
            lista = lista.stream()
                    .filter(e -> e.getCarrera() != null && e.getCarrera().toLowerCase().contains(carreraLower))
                    .collect(Collectors.toList());
        }

        // Excluir al usuario actual
        if (usuario != null) {
            lista = lista.stream()
                    .filter(e -> !e.getCodigo().equals(usuario.getCodigo()))
                    .collect(Collectors.toList());
        }

        return lista;
    }
}


