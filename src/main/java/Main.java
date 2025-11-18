
import com.mycompany.feeedgrow.persistencia.GestorDatos;
import com.mycompany.feeedgrow.vista.InicioDeSesion;

public class Main {

    public static void main(String[] args) {
       GestorDatos gestor = new GestorDatos();
       InicioDeSesion inicio = new InicioDeSesion(gestor);
       inicio.setVisible(true);
       
    }
    
}
