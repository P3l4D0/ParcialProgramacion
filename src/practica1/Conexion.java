package practica1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    String bd = "practica1";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;

    public Conexion(String bd) {
        this.bd = bd;
    }

    public Connection conectar() {
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url + bd, user, password);
            System.out.println(bd + "SE CONECTÓ A LA BD ");
            return cx;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("NO SE CONECTÓ A LA BD " + bd);
        }
        return null;
    }

    public void desconectar() {
        try {
            if (cx != null) {
                cx.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Conexion conexion = new Conexion("practica1");
        // Aquí puedes usar la conexión para realizar operaciones en la base de datos
        // ...
        conexion.desconectar(); // No olvides cerrar la conexión al final
    }
}

