package MrJuerga;

import Controlador.UsuariosControl;
import Controlador.VentasControl;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MrJuerga {

    public static void main(String[] args) {
        try {
            System.out.println(new UsuariosControl().getUltimoIdUsuario());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
