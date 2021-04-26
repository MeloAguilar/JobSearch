package Intrfaces;

import Clases.Empresa;
import Clases.Profesional;
import Clases.Usuario;

import java.util.ArrayList;
import java.util.List;

public interface UsuarioImp {

    private static List<Usuario> getUltimosSeguidos(List<Usuario> lista){
        ArrayList<Usuario> usuariosFinales = new ArrayList<> (  );
        usuariosFinales = this.getListaSeguidos ();
        int contador = 0;
        for(Usuario usuario: lista){
            if(usuario instanceof Profesional){
                usuariosFinales.add (usuario);
                contador++;
            }
        }if(contador > 2){
            do{
                usuariosFinales.remove (0);
                contador--;
            }while(contador > 2);
        }
        return usuariosFinales;
    }
}
