import Clases.Profesional;
import Clases.Usuario;
import org.junit.jupiter.api.*;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    private Usuario usuario;


    @Test
    public void passWordTestCasoValido() {
        String nombre = "Carmelo";
        String sector = "Cocina";
        String nickName = "Melits";
        String passWord = "Casery";
        String apellidos = "Locuron";
        this.usuario = new Profesional (nombre, sector, nickName, passWord, apellidos);
        String contrasenia = "******";
        assertEquals (contrasenia, usuario.ocultarPassword ( ));

    }
}