package test;

import java.sql.*;

public class TestMysqlJDBC {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
//            Class.forName("com.mysql.cj.jdbc.Driver");//Se puede requerir para aplicaciones web
            try {
                Connection conexion = DriverManager.getConnection(url, "root", "");
                Statement instruccion = conexion.createStatement();
                var sql = "SELECT * FROM persona";
                ResultSet resultado = instruccion.executeQuery(sql);
                while(resultado.next()){
                    System.out.print("Id Persona: " + resultado.getInt("id_persona"));
                    System.out.print(", nombre: " + resultado.getString("nombre"));
                    System.out.print(", apellido: " + resultado.getString("apellido"));
                    System.out.print(", email: " + resultado.getString("email"));
                    System.out.println(", telefono: " + resultado.getString("telefono"));
                }
                resultado.close();
                instruccion.close();
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
    }

}

