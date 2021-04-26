package Clases;

import Excepciones.NoFollowerException;

import java.util.*;

public class Profesional extends Usuario {

    private String apellidos;
    private ArrayList<Solicitud> solicitudes;

    public Profesional(String nombre, String sector, String nickName, String passWord, String apellidos) {
        super (nombre, sector, nickName, passWord);
        this.apellidos = apellidos;
        solicitudes = new ArrayList<> ( );
    }


    /**
     * <h1>unFollowUsuario(Usuario)</h1>
     * <p>
     * Método que borra a un usuario introducido mediante
     * parámetro de la lista de usuarios seguidos por el objeto
     * que llama al método.
     * Precondiciones: usuario debe ser distinto de null
     * Postcondiciones: devolverá la lista de usuariosSeguidos por el
     * objeto que llama al método.
     *
     * @param usuario: Usuario a borrar de la lista usuariosSeguidos
     * @return ArrayList<Usuario> usuariosSeguidos.
     * @throws NoFollowerException: Se lanzará si
     */
    public ArrayList<Usuario> unFollowUsuario(Usuario usuario) throws NoFollowerException {
        for (Usuario x : this.getListaSeguidos ( )) {
            if (x.getNickName ( ).equals (usuario.getNickName ( ))) {
                getListaSeguidos ( ).remove (x);
            }
        }
        if (!this.getListaSeguidos ( ).contains (usuario)) {
            throw new NoFollowerException ( );
        }
        return this.getListaSeguidos ( );
    }

    public ArrayList<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }


    /**
     * <h1>enviarSolicitud(Empresia, String);</h1>
     * <p>
     * Método que crea una solicitud a partir de un parámetro Empresa y un String
     * que sirve para dar información adicional sobre el usuario que genera
     * la solicitud.
     * Precondiciones: empresa y informacionAdicional deben ser diferentes de null.
     * Postcondiciones: ninguna
     *
     * @param empresa:              Empresa a la que se enviará la solicitud
     * @param informacionAdicional: informacion adicional que añade el usuario Profesional.
     */
    public void enviarSolicitud(Empresa empresa, String informacionAdicional) {
        Solicitud solicittud = new Solicitud (this, empresa, informacionAdicional);
        solicitudes.add (solicittud);
        empresa.getSolicitudes ( ).add (solicittud);
    }


    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return super.toString ( ) +
                "\nApellidos: " + apellidos +
                "\n*************************************************************";
    }


    @Override
    public List<Usuario> getUltimosSeguidos() {
        ArrayList<Usuario> usuariosFinales = new ArrayList<> ( );
        int contador = this.getListaSeguidos ().size ( );
        do {
            for (Usuario usuario : this.getListaSeguidos ()) {
                if(usuario instanceof Empresa || contador > 2) {
                    usuariosFinales.remove (usuario);
                    contador--;
                }//endIf
            }//endForEach
        } while (contador > 2);
        return usuariosFinales;
    }



    @Override
    public List<Usuario> imprimirSugerenciaDePerfiles() {
        ArrayList<Usuario> perfilesSugeridos = new ArrayList<> (  );
        for(Usuario usuario : this.getListaSeguidos ()){
            for(Usuario usuario2 : usuario.getListaSeguidos()){
                if(usuario2 instanceof Empresa){
                    perfilesSugeridos.add(usuario);

                }
            }
            System.out.println(perfilesSugeridos);
        }

        return perfilesSugeridos;
    }

}
