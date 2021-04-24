package Clases;

import java.util.*;

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
        usuariosSeguidos = new ArrayList<> (  );
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
     *
     * Método que oculta la contraseña del cliente al mostrarse su método toString.
     * Esta propiedad se podrá consultar mediante get, pero me parecía un poco mejor
     * hacerla de esta manera, ya que si queremos ver los datos no necesitamos ver su contraseña.
     * Precondiciones: ninguna
     * Postcondiciones: Devolverá un String passWordOculta, con tantos "*" como caracteres tenga
     * la contraseña del usuario.
     * @return passWordOculta
     */
    public String ocultarPassword() {
        String passWordOculta = "";
        for (int i = 0; i < passWord.length ( ); i++){
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

    public abstract ArrayList<Usuario> seguirUsuario(Usuario usuario);



    @Override
    public String toString() {
        return "Usuario: " + nickName +
                "\nSector: " + sector +
                "\nPassWord: " + this.ocultarPassword () +
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
}
