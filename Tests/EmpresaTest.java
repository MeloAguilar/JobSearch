import static org.junit.jupiter.api.Assertions.*;

import Clases.Empresa;
import Clases.Profesional;
import org.junit.jupiter.api.*;

public class EmpresaTest {

    Profesional usuario;
    Profesional usuario2;
    Profesional usuario3;

    Empresa empresa;

    @Test
    public void CasoPruebaValidoContratarProfesional(){
        String nombre = "Carmelo";
        String sector = "Cocina";
        String nickName = "Melits";
        String passWord = "Casery";
        String apellidos = "Locuron";
        this.usuario = new Profesional (nombre, sector, nickName, passWord, apellidos);

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
        String nombre3 = "Carmelo";
        String sector3 = "Cocina";
        String nickName3 = "Melits";
        String passWord3 = "Casery";
        String apellidos3 = "Locuron";

        this.usuario = new Profesional (nombre, sector, nickName, passWord, apellidos);
        this.usuario2 = new Profesional (nombre2, sector2, nickName2, passWord2, apellidos2);
        this.usuario3 = new Profesional (nombre3,sector3,nickName3,passWord3,apellidos3);
    }
}
