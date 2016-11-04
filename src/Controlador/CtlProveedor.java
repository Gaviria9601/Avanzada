/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ProveedorDAO;
import Modelo.Municipios;
import Modelo.Proveedores;
import java.util.List;

/**
 *
 * @author Santiago Gaviria Oliveros
 */
public class CtlProveedor {
    
    ProveedorDAO dao;
    
    public CtlProveedor(){
        dao = new ProveedorDAO();
    }
    
     public boolean save(String cedula, String nombreCompleto, String nickname, String contrasenia,String direccion, String nombreEntidad,int Municipio) {
         Proveedores proveedor= new Proveedores(cedula, nombreCompleto, nickname, contrasenia,direccion,nombreEntidad, new Municipios(Municipio));
        return dao.save(proveedor);
    }

    public Proveedores search(String cedula) {
        return dao.search(cedula);
    }
    
    public Proveedores searchLogin(String nickname,String contrasenia) {
        return dao.searchLogin(nickname, contrasenia);
    }

    public boolean update(String cedula, String nombreCompleto, String nickname, String contrasenia,String direccion, String nombreEntidad,int Municipio) {
        Proveedores proveedor = new Proveedores(cedula, nombreCompleto, nickname, contrasenia,direccion, nombreEntidad, new Municipios(Municipio));
        return dao.update(proveedor);
    }

    public boolean delete(String cedula) {
        return dao.delete(cedula);
    }

    public List<Proveedores> list() {
        return dao.list();
    }
    
}
