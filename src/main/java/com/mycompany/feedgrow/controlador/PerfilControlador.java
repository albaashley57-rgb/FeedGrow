
package com.mycompany.feedgrow.controlador;
import com.mycompany.feedgrow.modelo.Estudiante;
import com.mycompany.feedgrow.modelo.GestorDatos;
public class PerfilControlador {
   
    private final GestorDatos gestor;

    public PerfilControlador(GestorDatos gestor) {
        this.gestor = gestor;
    }

    public String editarPerfil(Estudiante estudiante, String nuevaCarrera, String nuevoCorreo,
                               String antiguaContrasena, String nuevaContrasena, String confirmarContrasena) {
        if (!estudiante.getContraseña().equals(antiguaContrasena)) {
            return "La contraseña actual no coincide.";
        }
        if (!nuevaContrasena.equals(confirmarContrasena)) {
            return "Las contraseñas nuevas no coinciden.";
        }
       // estudiante.editarPerfil(nuevaCarrera, nuevoCorreo, nuevaContrasena);
        //gestor.actualizarEstudiante(estudiante);
        return ""; // éxito
    }
}

