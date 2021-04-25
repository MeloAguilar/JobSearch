package Clases;

import com.sun.jdi.Type;

import java.util.*;

import static java.lang.Integer.parseInt;

public abstract class Usuario {

    private String nombre;
    private String sector;
    private String nickName;
    private String passWord;
    private ArrayList<Usuario> usuariosSeguidos;

    public Usuario(String nombre, String sector, String nickName, String passWord) {
        this.nombre = nombre;
        this.sector = sector;
        this.nickName = nickName;
        this.passWord = passWord;
        usuariosSeguidos = new ArrayList<> ( );
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


    /**
     * <h1>ocultaarPassword();</h1>
     * <p>
     * Método que oculta la contraseña del cliente al mostrarse su método toString.
     * Esta propiedad se podrá consultar mediante get, pero me parecía un poco mejor
     * hacerla de esta manera, ya que si queremos ver los datos no necesitamos ver su contraseña.
     * Precondiciones: ninguna
     * Postcondiciones: Devolverá un String passWordOculta, con tantos "*" como caracteres tenga
     * la contraseña del usuario.
     *
     * @return passWordOculta
     */
    public String ocultarPassword() {
        String passWordOculta = "";
        for (int i = 0; i < passWord.length ( ); i++) {
            passWordOculta += "*";
        }
        return passWordOculta;
    }

    public ArrayList<Usuario> getUsuariosSeguidos() {
        return this.usuariosSeguidos;
    }

    public void setUsuariosSeguidos(ArrayList<Usuario> usuariosSeguidos) {
        this.usuariosSeguidos = usuariosSeguidos;
    }

    /**
     * <h1>seguirUsuario(Usuario)</h1>
     * <p>
     * Método que añade a un usuario previamente introducido por
     * parámetro a la lista de usuarios seguidos por el usuario
     * que llama al método en caso de que el usuario no se
     * encuentre en la lista de ususarios seguidos.
     * Precondiciones: el parámetro Usuario debe ser diferente de null.
     * Postcondiciones: Devolverá la lista de usuarios seguidos por el usuario
     * que llama al método.
     *
     * @param usuario Usuario previamente construido.
     * @return ArrayList<Usuario> usuariosSeguidos.
     */
    public ArrayList<Usuario> seguirUsuario(Usuario usuario) {
        boolean exit = false;
        int contador = 0;
        do {
            for (Usuario x : this.getUsuariosSeguidos ( )) {
                if (x.equals (usuario)) {
                    exit = true;
                }

            }
            contador++;
            if (this.getUsuariosSeguidos ( ).isEmpty ( ) || contador > 0) {
                this.getUsuariosSeguidos ( ).add (usuario);
                exit = true;
            }
        } while (!exit);
        return this.getUsuariosSeguidos ( );
    }


    @Override
    public String toString() {
        return "\n*************************************************************" +
                "\nUsuario: " + nickName +
                "\nSector: " + sector +
                "\nPassWord: " + this.ocultarPassword ( ) +
                "\nNombre: " + nombre;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return getNickName ( ).equals (usuario.getNickName ( ));
    }

    @Override
    public int hashCode() {
        return Objects.hash (getNickName ( ));
    }

    /**
     * Método para comparar dos usuarios mediante su nickName,
     * ya que los nickNames deben ser únicos y no se pueden modificar por
     * el usuario siempre será su identificación como usuario, ya sea
     * Empresa o profesional.
     *
     * @param o1
     * @param o2
     * @return <ol>
     *          <li>0: </li>
     * </ol>
     */
    public int compare(Usuario o1, Usuario o2) {
        return o1.getNickName ( ).compareTo (o2.getNickName ( ));
    }


    public abstract void imprimirSugerenciaDePerfiles(ArrayList<Usuario> lista);
}
