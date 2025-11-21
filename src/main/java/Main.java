
import com.mycompany.feedgrow.persistencia.GestorDatos;
import com.mycompany.feedgrow.vista.InicioDeSesion;

public class Main {

    public static void main(String[] args) {

      GestorDatos gestor = new GestorDatos();
       InicioDeSesion inicio = new InicioDeSesion(gestor);
       inicio.setVisible(true);
       
    }
    
}
