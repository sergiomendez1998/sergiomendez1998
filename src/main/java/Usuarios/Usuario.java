/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Usuarios;

import lombok.Data;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Data
public class Usuario {
    private int id;
    private String  username;
    private String password;
    private String nombre;
  
       
    public Usuario(){
    
    }

    public Usuario(String username, String password , String nombre) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
    }
    
    
    
}
