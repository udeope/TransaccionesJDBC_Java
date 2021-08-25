package test;

import datos.*;
import domain.*;
import java.util.*;

public class TestManejoUsuarios {

    public static void main(String[] args) {

        UsuarioDAO usuarioDao = new UsuarioDAO();

        usuarioDao.seleccionar();

//       Usuario userNuevo = new Usuario("Paquito", "6969");
//       usuarioDao.insertar(userNuevo);
//        Usuario userModified = new Usuario(4,"Pauitito", "2323");
//        usuarioDao.actualizar(userModified);
        Usuario userEliminated = new Usuario(4);

        usuarioDao.eliminar(userEliminated);

        List<Usuario> usuarios = usuarioDao.seleccionar();
        usuarios.forEach(user -> {
            System.out.println("user = " + user);
        });

    }
}
