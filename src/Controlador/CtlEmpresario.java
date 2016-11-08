/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.EmpresarioDAO;
import Modelo.Empresarios;
import Modelo.Municipios;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CtlEmpresario {
    EmpresarioDAO dao;

    public CtlEmpresario() {
        dao = new EmpresarioDAO();
    }
    
    public boolean save(String cedula, String nombrecompleto, String nickname, String contrasenia,String direccion, String nombreentidad, int municipiosId) {
        Empresarios empresario = new Empresarios(cedula, nombrecompleto, nickname, contrasenia,direccion, nombreentidad, new Municipios(municipiosId));
        return dao.save(empresario);
    }

    public Empresarios search(String cedula) {
        return dao.search(cedula);
    }
    
    public Empresarios searchNombre(String nombre) {
        return dao.searchNombre(nombre);
    }
    
    public Empresarios searchLogin(String nickname,String contrasenia) {
        return dao.searchLogin(nickname, contrasenia);
    }

    public boolean update(String cedula, String nombrecompleto, String nickname, String contrasenia,String direccion, String nombreentidad, int municipiosId) {
        Empresarios empresario = new Empresarios(cedula, nombrecompleto, nickname, contrasenia,direccion, nombreentidad, new Municipios(municipiosId));
        return dao.update(empresario);
    }

    public boolean delete(String cedula) {
        return dao.delete(cedula);
    }

    public List<Empresarios> list() {
        return dao.list();
    }
    
    
}
