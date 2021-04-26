package Clases.Interfaces;

import Clases.Usuario;

import java.util.List;

public interface UsuarioImp {

    public List<Usuario> getUltimosSeguidos();


    public abstract List<Usuario> imprimirSugerenciaDePerfiles();

    public List<Usuario> seguirUsuario(Usuario usuario);
}
