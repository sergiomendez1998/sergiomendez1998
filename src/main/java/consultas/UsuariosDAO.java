/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import Usuarios.Usuario;
import conexionDB.Conexion;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@RequestScoped
public class UsuariosDAO implements Serializable {

    private static String usuarioL;

    public String getUsuarioL() {
        return usuarioL;
    }

    public void setUsuarioL(String usuarioL) {
        UsuariosDAO.usuarioL = usuarioL;
    }

    private final Conexion co = new Conexion();
    private  Usuario user;
    private final String pedirDatos = "Select id, nombre, username, password From usuarios WHERE username=?  and password =?";

    public Usuario selectUser(String usern, String pw) throws IOException {



        try (Connection connection = co.getConnection();
                PreparedStatement ps = connection.prepareStatement(pedirDatos)) {
            ps.setString(1, usern);
            ps.setString(2, pw);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String u = rs.getString("username");
                String p = rs.getString("password");
                String n = rs.getString("nombre");

                user = new Usuario(u, p, n);
            }
            
            ps.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        setUsuarioL(user.getNombre());
        System.out.println(getUsuarioL());

        return user;

    }

}
