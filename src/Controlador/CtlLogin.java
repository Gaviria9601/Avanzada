/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.LoginDAO;

/**
 *
 * @author Santiago Gaviria Oliveros
 */
public class CtlLogin {
    
    LoginDAO dao;
    
    public CtlLogin(){
        dao = new LoginDAO();
    }
    
    public String ingresar(String nickname, String contrasenia) {
        return dao.ingresar(nickname, contrasenia);
    } 
    
}
