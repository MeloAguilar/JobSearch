package Main;

import Clases.Profesional;
import Clases.Usuario;
import Excepciones.NoEmployeeException;
import Excepciones.NoFollowerException;

public class Main {

    public static void main(String[] args) {
        Usuario p1 = new Profesional ("Pepe","Inmobiliario", "PepeLCrack","PepeFollanca", "Lameortos");
        Usuario p2 = new Profesional ("Juani", "Inmobiliaria", "GErani", "Chupacabras", "Randomio");
        Usuario p3 = new Profesional ("Charo", "Inmobiliaria", "Espero", "Chupas", "Randomio");


        p1.seguirUsuario (p2);
        p2.seguirUsuario (p1);
        System.out.println (p1.getUsuariosSeguidos () );
        try {
            ((Profesional) p2).unFollowUsuario (p3);
        }catch( NoFollowerException e){
            System.out.println ("El profesional no existe" );
        }
        System.out.println (p2.getUsuariosSeguidos () );
    }
}
