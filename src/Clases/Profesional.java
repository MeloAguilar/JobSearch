package Clases;

import Excepciones.NoEmployeeException;
import Excepciones.NoFollowerException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;

public class Profesional extends Usuario{

    private String apellidos;
    private ArrayList<Solicitud> solicitudes;

    public Profesional(String nombre, String sector, String nickName, String passWord, String apellidos) {
        super (nombre, sector, nickName, passWord);
        this.apellidos = apellidos;
        solicitudes = new ArrayList<> (  );
    }


    /**
     * <h1>seguirUsuario(Usuario)</h1>
     *
     * Método que añade a un usuario previamente introducido por
     * parámetro a la lista de usuarios seguidos por el usuario
     * que llama al método en caso de que el usuario no se
     * encuentre en la lista de ususarios seguidos.
     * Precondiciones: el parámetro Usuario debe ser diferente de null.
     * Postcondiciones: Devolverá la lista de usuarios seguidos por el usuario
     * que llama al método.
     * @param usuario Usuario previamente construido.
     * @return ArrayList<Usuario> usuariosSeguidos.
     */
    @Override
    public ArrayList<Usuario> seguirUsuario(Usuario usuario) {
        boolean exit = false;
        do {
            for (Usuario x : this.getUsuariosSeguidos ( )) {
                if (!x.equals (usuario)) {
                    this.getUsuariosSeguidos ( ).add (usuario);
                     exit = true;
                }
            }
            if (this.getUsuariosSeguidos ( ).isEmpty ( )) {
                this.getUsuariosSeguidos ( ).add (usuario);
                exit = true;
            }
        } while (!exit);
        return this.getUsuariosSeguidos ( );
    }


    /**
     * <h1>unFollowUsuario(Usuario)</h1>
     *
     * Método que borra a un usuario introducido mediante
     * parámetro de la lista de usuarios seguidos por el objeto
     * que llama al método.
     * Precondiciones: usuario debe ser distinto de null
     * Postcondiciones: devolverá la lista de usuariosSeguidos por el
     * objeto que llama al método.
     * @param usuario: Usuario a borrar de la lista usuariosSeguidos
     * @return ArrayList<Usuario> usuariosSeguidos.
     * @throws NoFollowerException: Se lanzará si
     */
    public ArrayList<Usuario> unFollowUsuario(Usuario usuario) throws NoFollowerException {
        for (Usuario x : this.getUsuariosSeguidos ( )) {
            if (x.getNickName ( ).equals (usuario.getNickName ( ))) {
                getUsuariosSeguidos ( ).remove (x);
            }
        }if(!this.getUsuariosSeguidos ().contains (usuario)){
            throw new NoFollowerException ();
        }
        return this.getUsuariosSeguidos ( );
    }

    public ArrayList<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }


    /**
     * <h1>enviarSolicitud(Empresia, String);</h1>
     *
     * Método que crea una solicitud a partir de un parámetro Empresa y un String
     * que sirve para dar información adicional sobre el usuario que genera
     * la solicitud.
     * Precondiciones: empresa y informacionAdicional deben ser diferentes de null.
     * Postcondiciones: ninguna
     * @param empresa: Empresa a la que se enviará la solicitud
     * @param informacionAdicional: informacion adicional que añade el usuario Profesional.
     */
    public void enviarSolicitud(Empresa empresa, String informacionAdicional) {
        Solicitud solicittud = new Solicitud (this, empresa, informacionAdicional);
        solicitudes.add (solicittud);
        empresa.getSolicitudes ().add (solicittud);
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
                "\nApellidos: " + apellidos;
    }
}
