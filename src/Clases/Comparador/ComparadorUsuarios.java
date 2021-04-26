package Clases.Comparador;


import Clases.Usuario;

import java.util.Comparator;

/**
 * todo PREGUNTAR A RAUL SI ESTO SE PODRÍA HACER EN LA CLASE EN LA QUE LO NECESITO
 */
public class ComparadorUsuarios implements Comparator<Usuario> {
        private boolean asc;
        public ComparadorUsuarios(boolean asc) {
            this.asc = asc;
        }
        @Override
        public int compare(Usuario o1, Usuario o2) {
            int ret;
            if (asc) {
                ret = o1.getNickName ().compareTo(o2.getNickName ());
            } else {
                ret = o2.getNickName ().compareTo(o1.getNickName ());
            }
            return ret;
        }
    }

