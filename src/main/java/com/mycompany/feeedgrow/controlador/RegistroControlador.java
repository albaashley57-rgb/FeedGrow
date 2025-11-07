
package com.mycompany.feeedgrow.controlador;
import com.mycompany.feeedgrow.modelo.Estudiante;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class RegistroControlador {
    public class RegistroController {

    private final File archivoUsuarios = new File("usuarios.txt");

    public boolean registrarUsuario(Estudiante estudiante) throws IOException {
        archivoUsuarios.createNewFile();
        List<String> lineas = Files.readAllLines(archivoUsuarios.toPath());

        for (String linea : lineas) {
            if (linea.startsWith(estudiante.getUsuario() + ",")) {
                return false; // Usuario ya existe
            }
        }

        try (FileWriter writer = new FileWriter(archivoUsuarios, true)) {
            writer.write(estudiante.getUsuario() + "," +
                         estudiante.getNombre() + "," +
                         estudiante.getCorreo() + "," +
                         estudiante.getCarrera() + "," +
                         estudiante.getContrasena()+ "\n");
        }

        return true;
    }

    public boolean validarCampos(Estudiante estudiante, String confirmarContraseña) {
        if (estudiante.getNombre().isEmpty() || estudiante.getUsuario().isEmpty() ||
            estudiante.getCorreo().isEmpty() || estudiante.getCarrera().isEmpty() ||
            estudiante.getContrasena().isEmpty() || confirmarContraseña.isEmpty()) {
            return false;
        }
        if (!estudiante.getUsuario().matches("\\d+")) return false;
        return estudiante.getContrasena().equals(confirmarContraseña);
    }
}

}
