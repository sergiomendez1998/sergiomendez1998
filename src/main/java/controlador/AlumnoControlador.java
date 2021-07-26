/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import alumnos.Alumnos;
import consultas.AlumnosDAO;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Data;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Named
@ViewScoped
@Data
public class AlumnoControlador implements Serializable {

    private String nombre;
    private String apellido;
    private int edad;
    private Date fechaNacimiento;
    private String peso;
    private String altura;
    private String familia;
    private String madreEncargada;
    private String grado;
    private String razonCita;
    private Date fechaIngreso;

    private Alumnos newAlumno;

    @Inject
    private AlumnosDAO alumnosDAO;

    private List<Alumnos> alumnos;

    @PostConstruct
    public void init() {
        this.alumnosDAO = new AlumnosDAO();
        this.alumnos = alumnosDAO.mostrarDatos();

    }

    public void insertAppoitments() throws IOException {

        newAlumno = new Alumnos(nombre, apellido, edad, fechaNacimiento, peso, altura, familia, madreEncargada, grado, razonCita, fechaIngreso);
        alumnosDAO.guardarCitas(newAlumno);
        addMessage("Confirmed", "You have saved the appointment successfully!!");

    }

    public List<Alumnos> getAlumnos() {
        return alumnos;
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    public String deleteRow(int id) throws SQLException, IOException {
        alumnosDAO.deleteData(id);
        addMessage("Confirmed", "You have deleted the row successfully!!");
        return "mostrarDatos.xhtml?faces-redirect=true";
    }

    public void cargarData(Alumnos alumnos) {
        this.newAlumno = alumnos;
    }

}
