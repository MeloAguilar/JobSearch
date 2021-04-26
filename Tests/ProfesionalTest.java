import Clases.Empresa;
import Clases.Profesional;

import static org.junit.jupiter.api.Assertions.*;

import Clases.Solicitud;
import Excepciones.NoFollowerException;
import org.junit.jupiter.api.*;

public class ProfesionalTest {

    private Profesional usuario;
    private Empresa usuario2;

    @Test
    public void CasoValidoSeguirUsuario(){
        darCuerpo ();
        assertEquals (usuario.getListaSeguidos (), usuario.seguirUsuario (usuario2));
    }


    @Test
    public void CasoNoValidoUnfollowUser() throws NoFollowerException {
        darCuerpo ();
        usuario.getListaSeguidos ().add (usuario2);
        assertEquals (usuario.getListaSeguidos (), usuario.unFollowUsuario (usuario2));
    }


    @Test
    public void CasoValidoEnviarSolicitud(){
        darCuerpo ();
        Solicitud solicitud = new Solicitud (usuario,usuario2,"Soy mu major", "director de Márquetin");
        assertEquals (solicitud, usuario.enviarSolicitud (usuario2, "Soy mu major", "director de Márquetin"));
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
        this.usuario2 = new Empresa (nombre2, sector2, nickName2, passWord2,900);
    }
}
