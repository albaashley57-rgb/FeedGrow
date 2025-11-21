
package com.mycompany.feeedgrow.controlador;

import com.mycompany.feeedgrow.modelo.CriterioEvaluacion;
import com.mycompany.feeedgrow.modelo.Estudiante;
import com.mycompany.feeedgrow.modelo.Seguridad;
import com.mycompany.feeedgrow.persistencia.GestorDatos;

public class PerfilControlador {
       private final GestorDatos gestor;

    public PerfilControlador(GestorDatos gestor) {
        this.gestor = gestor;
    }

    public double getPromedio(Estudiante e, CriterioEvaluacion criterio) {
        if (e == null || e.getPerfil() == null) return 0;
        return e.getPerfil().getPromedio(criterio);
    }

    public double getPromedioGlobal(Estudiante e) {
        if (e == null || e.getPerfil() == null) return 0;
        return e.getPerfil().getPromedioGlobal();
    }
    
   public String editarPerfil(Estudiante estudiante, String nuevaCarrera, String nuevoCorreo,
                           String antiguaContrasena, String nuevaContrasena, String confirmarContrasena) {

    // Validaciones básicas
    if (nuevaCarrera == null || nuevaCarrera.isEmpty()) {
        return "La carrera no puede estar vacía.";
    }
    
    if (nuevoCorreo == null || nuevoCorreo.isEmpty()) {
        return "El correo no puede estar vacío.";
    }

    // La contraseña actual siempre es obligatoria
    if (antiguaContrasena == null || antiguaContrasena.isEmpty()) {
        return "Debes ingresar la contraseña actual para realizar cambios.";
    }
    
    if (!Seguridad.validar(antiguaContrasena, estudiante.getSalt(), estudiante.getPasswordHash())) {
        return "La contraseña actual no coincide.";
    }

    boolean cambiarPass = 
            (nuevaContrasena != null && !nuevaContrasena.isEmpty()) ||
            (confirmarContrasena != null && !confirmarContrasena.isEmpty());

    if (cambiarPass) {
        if (nuevaContrasena.isEmpty() || confirmarContrasena.isEmpty()) {
            return "Para cambiar la contraseña completa los dos campos de nueva contraseña y confirmación.";
        }
        if (!nuevaContrasena.equals(confirmarContrasena)) {
            return "Las nuevas contraseñas no coinciden.";
        }
        if (nuevaContrasena.length() < 6) {
            return "La nueva contraseña debe tener al menos 6 caracteres.";
        }
      estudiante.setContrasena(nuevaContrasena);
    }
    estudiante.setCarrera(nuevaCarrera);
    estudiante.setCorreo(nuevoCorreo);
    gestor.actualizarEstudiante(estudiante);

    return ""; 
}
 

        

}

