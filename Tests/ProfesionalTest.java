import Clases.Profesional;
import Clases.Usuario;
import static org.junit.jupiter.api.Assertions.*;

import Excepciones.NoEmployeeException;
import Excepciones.NoFollowerException;
import org.junit.jupiter.api.*;

public class ProfesionalTest {

    private Profesional usuario;
    private Profesional usuario2;

    @Test
    public void CasoValidoSeguirUsuario(){
        darCuerpo ();
        assertEquals (usuario.getUsuariosSeguidos (), usuario.seguirUsuario (usuario2));
    }


    @Test void CasoValidoUnfollowUser() throws NoFollowerException {
        darCuerpo ();
        usuario.getUsuariosSeguidos ().add (usuario2);
        assertEquals (usuario.getUsuariosSeguidos (), usuario.unFollowUsuario (usuario2));
    }



    public void darCuerpo(){
        String nombre = "Pepe";
        String nombre2 = "Juan";
        String apellidos = "Lame";
        String apellidos2 = "Culos";
        String sector = "Cocina";
        String sector2 = "Finanzas";
        String nickName = "Poyazs";
        String nickName2 = "Pepino";
        String passWord = "Escalopendra";
        String passWord2 = "Supercalifragilistico";

        this.usuario = new Profesional (nombre, sector, nickName, passWord, apellidos);
        this.usuario2 = new Profesional (nombre2, sector2, nickName2, passWord2, apellidos2);
    }
}
