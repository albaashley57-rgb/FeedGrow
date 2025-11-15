
package com.mycompany.feedgrow.controlador;

import com.mycompany.feedgrow.modelo.Estudiante;
import com.mycompany.feedgrow.modelo.GestorDatos;
import java.util.List;
import java.util.stream.Collectors;
public class BusquedaControlador {
    private final GestorDatos gestor;

    public BusquedaControlador(GestorDatos gestor) {
        this.gestor = gestor;
    }

    public List<Estudiante> buscarPorNombre(String nombre) {
        return gestor.obtenerEstudiantes().stream()
                .filter(e -> e.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Estudiante> filtrarPorCarrera(String carrera) {
        return gestor.obtenerEstudiantes().stream()
                .filter(e -> e.getCarrera().equalsIgnoreCase(carrera))
                .collect(Collectors.toList());
    }
}

