/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Conexion {

    String BD = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String pass = "$ergio1007+";

    public Connection getConnection() {

        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(BD, user, pass);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "error al conectar");
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

}
