/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alumnos;


import java.util.Date;
import lombok.Data;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Data
public class Alumnos {
    
 private int id;
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
 
 private Date fechaAtendida;
 private String cometario;
 private String recetaMedica;
 
 
 public Alumnos(){}

    public Alumnos(String nombre, String apellido, int edad, Date fechaNacimiento, String peso, String altura, String familia, String madreEncargada, String grado, String razonCita, Date fechaIngreso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.altura = altura;
        this.familia = familia;
        this.madreEncargada = madreEncargada;
        this.grado = grado;
        this.razonCita = razonCita;
        this.fechaIngreso = fechaIngreso;
    }

    public Alumnos(int id, String nombre, String apellido, int edad, Date fechaNacimiento, String peso, String altura, String familia, String madreEncargada, String grado, String razonCita, Date fechaIngreso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.altura = altura;
        this.familia = familia;
        this.madreEncargada = madreEncargada;
        this.grado = grado;
        this.razonCita = razonCita;
        this.fechaIngreso = fechaIngreso;
    }

 

}
