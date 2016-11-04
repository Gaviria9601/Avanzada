/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.AdministradorDAO;
import Modelo.Administradores;
import java.util.List;

/**
 *
 * @author Santiago Gaviria Oliveros
 */
public class CtlAdministrador {
    
    AdministradorDAO dao;
    
    public CtlAdministrador(){
        dao = new AdministradorDAO();
    }
    
     public boolean save(String cedula, String nombreCompleto, String correo, String telefono, String contrasenia) {
        Administradores administrador= new Administradores(cedula, nombreCompleto, correo, telefono, contrasenia);
        return dao.save(administrador);
    }

    public Administradores search(String cedula) {
        return dao.search(cedula);
    }
    
    public Administradores searchNombre(String nombre) {
        return dao.searchNombre(nombre);
    }
    
    public Administradores searchLogin(String cedula,String contrasenia) {
        return dao.searchLogin(cedula, contrasenia);
    }

    public boolean update(String cedula, String nombreCompleto, String correo, String telefono, String contrasenia) {
        Administradores administrador= new Administradores(cedula, nombreCompleto, correo, telefono, contrasenia);
        return dao.update(administrador);
    }

    public boolean delete(String cedula) {
        return dao.delete(cedula);
    }

    public List<Administradores> list() {
        return dao.list();
    }
    
}
