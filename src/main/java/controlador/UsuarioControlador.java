/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Usuarios.Usuario;
import consultas.UsuariosDAO;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import lombok.Data;
import lombok.Getter;
import org.primefaces.PrimeFaces;

/**
 *
 * @Sergio santos mendez gonzalez
 */
@Named
@ViewScoped
@Data
public class UsuarioControlador implements Serializable {

    private String username;
    private String password;
    private Usuario us;
    private String usuarioLogueado;

    @Getter
    private UsuariosDAO validar;

    @PostConstruct
    public void init() {

        this.validar = new UsuariosDAO();
        setUsuarioLogueado(validar.getUsuarioL());

    }

    public String validarSesion() {

        try {
            us = validar.selectUser(username, password);

            if (us.getUsername().equalsIgnoreCase(username)) {

                if (us.getPassword().equals(password)) {
                    addMessage("Confirmed", "You have login in successfully!!");
                    FacesContext.getCurrentInstance().getExternalContext().redirect("faces/menu.xhtml");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public String logout() throws IOException {
        setUsuarioLogueado("");
        setUsername("");
        setPassword("");
 
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
        return "Login-Page.xhtml?faces-redirect=true";
    }

    public void showMessage() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Login failed: ", "Username Or Password Incorrect!!");
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public String gotoHome() throws IOException {
        
       return "menu.xhtml?faces-redirect=true";
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }


    public void addNewFromDataTable() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/add-student.xhtml");

    }

}
