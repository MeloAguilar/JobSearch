package Clases;

import Clases.Comparador.ComparadorUsuarios;
import Excepciones.NoEmployeeException;

import java.util.*;

public class Empresa extends Usuario {

    //Atributos
    private double facturacionAnualMedia;
    private ArrayList<Profesional> trabajadores;
    private ArrayList<Solicitud> solicitudes;

    public Empresa(String nombre, String sector, String nickName, String passWord, double facturacionAnualMedia) {
        super (nombre, sector, nickName, passWord);
        this.facturacionAnualMedia = facturacionAnualMedia;
        this.trabajadores = new ArrayList<> ( );
        this.solicitudes = new ArrayList<> ( );
    }


    //Métodos


    public ArrayList<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public double getFacturacionAnualMedia() {
        return facturacionAnualMedia;
    }

    public void setFacturacionAnualMedia(double facturacionAnualMedia) {
        this.facturacionAnualMedia = facturacionAnualMedia;
    }

    public ArrayList<Profesional> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(ArrayList<Profesional> trabajadores) {
        this.trabajadores = trabajadores;
    }


    /**
     * <h1>ContratarProfesional(Profesional);</h1>
     * <p>
     * Método que añade a un Usuario de tipo Profesional a la lista trabajadores
     * Precondiciones: profesional debe encontrarse en la lista de trabajadores
     *
     * @param profesional: Usuario de tipo Profesional a añadir a la lista de trabajadores.
     * @return ArrayList<Profesionales> trabajadores.
     */
    public ArrayList<Profesional> contratarProfesional(Profesional profesional) {
        trabajadores.add (profesional);
        return trabajadores;
    }


    /**
     * <h1>despedirProfesional(Profesional);</h1>
     * <p>
     * Método que borra a un objeto Profesional de la lista "trabajadores",
     * si este no existe, lanzará una NoEmployeeException.
     * Precondiciones: nignuna
     * Postcondiciones: devolverá la lista de trabajadores
     *
     * @param profesional: Profesional a borrar de la lista de trabajadores
     * @return trabajadores
     * @throws NoEmployeeException: Excepción que se lanza cuando el profesional
     *                              introducido como parámetro no coicide con ninguno de los trabajadores de la lista.
     */
    public ArrayList<Profesional> despedirProfesional(Profesional profesional) throws NoEmployeeException {
        this.trabajadores.removeIf (profesional1 -> profesional1.equals (profesional));
        if (!this.trabajadores.contains (profesional)) {
            throw new NoEmployeeException ( );
        }
        return this.trabajadores;
    }


    /**
     * <h1>rechazarSolicitud(Solicitud)</h1>
     * <p>
     * Método que borra de la lista de solicitudes, tanto de la empresa
     * como del profesional, una solicitud dada como parámetro
     * Precondiciones: Solicitud debe ser un objeto de tipo Solicitud previamente construido.
     * Postcondiciones: Borrará la solicitud relacionada con una empresa y un profesional
     *
     * @param solicitud: objeto a borrar de la lista de solicitudes.
     */
    public void rechazarSolicitud(Solicitud solicitud) {
        for (Solicitud solicitud1 : solicitudes) {
            if (solicitud1.equals (solicitud)) {
                solicitudes.remove (solicitud1);
                solicitud.getProfesional ( ).getSolicitudes ( ).remove (solicitud1);
            }
        }
    }


    @Override
    public List<Usuario> getUltimosSeguidos() {
        ArrayList<Usuario> usuariosFinales = new ArrayList<> ( );
        int contador = this.getListaSeguidos ().size ( );
        do {
            for (Usuario usuario : this.getListaSeguidos ()) {
                if(usuario instanceof Profesional || contador > 2) {
                    usuariosFinales.remove (usuario);
                    contador--;
                }
            }//endForEach
        } while (contador > 2);
        return usuariosFinales;
    }




    /**
     * Método que recorre la lista de solicitudes enviadas a un Usuario de tipo
     * Empresa y guarda a los Usuarios de tipo Profesional en otra lista para devolverla después.
     * Precondiciones: La lista de solicitudes de la empresa debe tener tamaño 1 o más.
     * Poscondiciones: Devolverá una lista con los Profesionales que han enviado una solicitud
     *
     * @return
     */
    public ArrayList<Usuario> recogerUsuariosQueHanEnviadoSolicitud() {
        ArrayList<Usuario> profesionalesConSolicitud = new ArrayList<> ( );
        for (Solicitud solicitud : this.getSolicitudes ( )) {
            profesionalesConSolicitud.add (solicitud.getProfesional ( ));
        }
        Collections.sort (profesionalesConSolicitud, new ComparadorUsuarios (true));
        return profesionalesConSolicitud;
    }


    @Override
    public List<Usuario> imprimirSugerenciaDePerfiles() {
        ArrayList<Usuario> perfilesSugeridos = new ArrayList<> (  );
        for(Usuario usuario : this.getListaSeguidos ()){
            for(Usuario usuario2 : usuario.getListaSeguidos()){
                if(usuario2 instanceof Profesional){
                    perfilesSugeridos.add(usuario2);
                }
            }
            System.out.println(perfilesSugeridos);
            for(Solicitud solicitud:this.getSolicitudes()){
                System.out.println(solicitud);
            }
        }

        return perfilesSugeridos;
    }

    @Override
    public String toString() {
        return super.toString ( ) +
                "\nFacturación Anual Media: " + facturacionAnualMedia +
                "\nListado de trabajadores: " + trabajadores +
                "\n*************************************************************";
    }
}
