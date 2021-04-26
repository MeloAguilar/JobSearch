package Main;

import Clases.Empresa;
import Clases.Profesional;
import Clases.Solicitud;
import Clases.Usuario;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Usuario p1 = new Profesional ("Pepe","Inmobiliario", "PepeLCrack","PepeFollanca", "Lameortos");
        Usuario p2 = new Profesional ("Juani", "Inmobiliaria", "Gerani", "Chupacabras", "Randomio");
        Usuario p3 = new Empresa ("Charo", "Inmobiliaria", "Espero", "Chupas", 50000);
        Usuario p4 = new Empresa ("Flores Mari", "Floristeria", "FloresMari", "Rosita",15000);

        p1.seguirUsuario (p2);
        p2.seguirUsuario (p1);
        p4.seguirUsuario (p3);


         ((Profesional) p1).enviarSolicitud((Empresa)p3, "Cocino bien","Chapero");
        ((Profesional) p2).enviarSolicitud ((Empresa) p3,"No se hace na", "Esquilador ovejil");
        p3.seguirUsuario (p1);
        p3.seguirUsuario (p2);
        p3.seguirUsuario (p4);
        p1.seguirUsuario (p4);
        p1.seguirUsuario (p3);
        p1.seguirUsuario (p2);
        p2.seguirUsuario (p1);
        p2.seguirUsuario (p3);
        p2.seguirUsuario (p4);
        p4.seguirUsuario (p1);
        p4.seguirUsuario (p2);
        p4.seguirUsuario (p3);
        ArrayList<Usuario> usuariosQueSigue = ((Empresa) p3).recogerUsuariosQueHanEnviadoSolicitud ();
        System.out.println (usuariosQueSigue );
        System.out.println (((Empresa) p3).recogerUsuariosQueHanEnviadoSolicitud () );
        System.out.println (p3.getListaSeguidos () );
        System.out.println ("POLLAS EN VINAGRE" );
        System.out.println (p3.getUltimosSeguidos () );
        p3.imprimirSugerenciaDePerfiles ();

    }
}
