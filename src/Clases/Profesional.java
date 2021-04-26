package Clases;

import Excepciones.NoFollowerException;

import java.util.*;
import java.util.stream.Collectors;

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
     * que llama al método.<br/>
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
     * la solicitud.<br/>
     * Precondiciones: empresa y informacionAdicional deben ser diferentes de null.
     * Postcondiciones: ninguna
     *
     * @param empresa:              Empresa a la que se enviará la solicitud
     * @param informacionAdicional: informacion adicional que añade el usuario Profesional.
     */
    public Solicitud enviarSolicitud(Empresa empresa, String informacionAdicional ,String puesto) {
        Solicitud solicittud = new Solicitud (this, empresa, informacionAdicional, puesto);
        solicitudes.add (solicittud);
        empresa.getSolicitudes ( ).add (solicittud);
        return solicittud;
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


    /**
     * <h3>getUltimosSeguidos()</h3>
     *
     * Método que devuelve una lista con los dos últimos
     * usuarios seguidos por el Profesional que llama
     * al método.<br/>
     * Precondiciones: La lista de usuarios seguidos debe ser,
     * como mínimo, de longitud 1.
     * Postcondiciones: Devolverá una lista de Empresas con
     * longitud máxima de 2.
     * @return usuariosFinales:
     */
    @Override
    public List<Usuario> getUltimosSeguidos() {
        ArrayList<Usuario> usuariosFinales = new ArrayList<> (  );
        int contador = this.getListaSeguidos ().size ( );
        while (contador > 2) {
            for (Usuario usuario : this.getListaSeguidos ()) {
                if(!(usuario instanceof Empresa)) {
                    usuariosFinales.add (this.getListaSeguidos ().get (contador-1));
                    contador--;

                }
            }//endForEach
            while (contador > 2){
                usuariosFinales.remove (0);
                contador--;
            }
        }
        return usuariosFinales;
    }


    /**
     * <h1>imprimirSugerenciaDePerfiles()</h1>
     *
     * Método que crea una lista de Usuario, recorre
     * un lista de usuarios seguidos, si es un
     * Usuario de tipo Empresa, lo añade
     * a la lista creada, la ordena por orden alfabético
     * y la devuelve.<br/>
     * Precondiciones: el atributo listaSeguidos debe tener,
     * como mínimo longitud 1.
     * Postcondiciones: ninguna
     * @return List<Usuario> perfilesSugeridos.
     */
    @Override
    public List<Usuario> imprimirSugerenciaDePerfiles() {
        ArrayList<Usuario> ultimosDosSugeridos = (ArrayList<Usuario>) this.getUltimosSeguidos ();
        ArrayList<Usuario> perfilesSugeridos = new ArrayList<> (  );
        for(Usuario usuario : ultimosDosSugeridos){
            for(Usuario usuario2 : usuario.getListaSeguidos()){
                if(usuario2 instanceof Empresa){
                    perfilesSugeridos.add(usuario);

                }
            }

        }
        perfilesSugeridos.sort(Comparator.comparing(Usuario::getNickName));
        perfilesSugeridos = (ArrayList<Usuario>) ultimosDosSugeridos.stream().distinct().collect(Collectors.toList());
         return perfilesSugeridos;
    }

}
