package test;

import datos.*;
import java.util.*;
import domain.Persona;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestManejoPersonas {

    public static void main(String[] args) {

        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {//es true por default
                conexion.setAutoCommit(false); //Para que no haga el commit automatico
            }

            PersonaDAO personaDao = new PersonaDAO(conexion); //le pasamos conexion para poder hacer commit o rollback

//            Persona cambioPersona = new Persona();
//            cambioPersona.setIdPersona(2);
//            cambioPersona.setNombre("Larka");
//            cambioPersona.setApellido("Gomez");
//            cambioPersona.setEmail("lgomez@mail.com");
//            cambioPersona.setTelefono("79846513");
            Persona cambioPersona2 = new Persona(2, "Larka", "Gomez", "lgomez@mail.com", "789465163");

            personaDao.actualizar(cambioPersona2, 2);

            Persona nuevaPersona = new Persona("Carlos", "Ramirez", "cramirez@mail.com", "456123798");
            personaDao.insertar(nuevaPersona);

            conexion.commit(); //guardamos todos los updates de la BBDD

            System.out.println("Se ha hecho commit de la transaccion");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

}
