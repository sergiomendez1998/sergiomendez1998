/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import alumnos.Alumnos;
import conexionDB.Conexion;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @Sergiomendezgzalez@gmail.com
 */
@RequestScoped
public class AlumnosDAO implements Serializable {

    private final Conexion co = new Conexion();
    private final String insertarToStudenents = "INSERT INTO estudiantes (nombre, apellido, edad, fecha_nacimiento, peso, altura, familia, madre_encargada, grado, razon_cita, fecha_ingreso) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String mostrarDatos = "SELECT * FROM estudiantes";
    private final String delete = "DELETE FROM estudiantes WHERE id =?";

    public void guardarCitas(Alumnos alumnos) throws IOException {

        String fechaNaci = Convertidor.getStringFromDate(alumnos.getFechaNacimiento());
        Date fechaN = Convertidor.getDateFromYYYYMMDD(fechaNaci);

        String fechIngreso = Convertidor.getStringFromDate(alumnos.getFechaIngreso());
        Date fechaI = Convertidor.getDateFromYYYYMMDD(fechIngreso);

        java.sql.Date fechaIng = Convertidor.convertidortoSql(fechaI);
        java.sql.Date fechaNacimie = Convertidor.convertidortoSql(fechaN);

        try (Connection connection = co.getConnection();
                PreparedStatement pr = connection.prepareStatement(insertarToStudenents)) {

            pr.setString(1, alumnos.getNombre());
            pr.setString(2, alumnos.getApellido());
            pr.setInt(3, alumnos.getEdad());
            pr.setDate(4, fechaNacimie);
            pr.setString(5, alumnos.getPeso());
            pr.setString(6, alumnos.getAltura());
            pr.setString(7, alumnos.getFamilia());
            pr.setString(8, alumnos.getMadreEncargada());
            pr.setString(9, alumnos.getGrado());
            pr.setString(10, alumnos.getRazonCita());
            pr.setDate(11, fechaIng);
            pr.executeUpdate();
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Alumnos> mostrarDatos() {
        List<Alumnos> alumnos = new ArrayList<>();

        try (Connection connection = co.getConnection();
                PreparedStatement ps = connection.prepareStatement(mostrarDatos)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                Date fecha = rs.getDate("fecha_nacimiento");
                String peso = rs.getString("peso");
                String altura = rs.getString("altura");
                String familia = rs.getString("familia");
                String madreE = rs.getString("madre_encargada");
                String grado = rs.getString("grado");
                String razonC = rs.getString("razon_cita");
                Date fechaI = rs.getDate("fecha_ingreso");
                alumnos.add(new Alumnos(id, nombre, apellido, edad, fecha, peso, altura, familia, madreE, grado, razonC, fechaI));

            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alumnos;
    }

    public void deleteData(int id) throws SQLException {

        try (Connection connection = co.getConnection();
                PreparedStatement ps = connection.prepareStatement("DELETE FROM estudiantes WHERE id =" + id);) {
            ps.executeUpdate();
        }

      
    }
    
    

}
