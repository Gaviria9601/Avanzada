/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Infraestructura.Conexion;
import Modelo.Proveedores;
import java.util.List;

/**
 *
 * @author Santiago Gaviria Oliveros
 */
public class ProveedorDAO extends Conexion {

    public ProveedorDAO() {
        conectar();
    }

    public boolean save(Proveedores proveedor) {
        try {
            conectar();
            entity.persist(proveedor);
            entity.getTransaction().commit();
            desconectar();
            return true;
        } catch (Exception e) {
            desconectar();
            return false;
        }
    }

    public Proveedores search(String cedula) {
        try {
             conectar();
            Proveedores proveedor = entity.createNamedQuery("Proveedores.findByCedula", Proveedores.class)
                    .setParameter("cedula", cedula).getSingleResult();
            desconectar();
            return proveedor;
        } catch (Exception e) {
            desconectar();
            return null;
        }
    }
    
     public Proveedores searchLogin(String nickname, String contrasenia ){
        try{
            Proveedores proveedor = entity.createNamedQuery("Proveedores.findByNicknameyContrasenia", Proveedores.class)
                    .setParameter("nickname", nickname)
                    .setParameter("contrasenia", contrasenia).getSingleResult();
            return proveedor;
        }catch(Exception e){
            return null;
        }
    }

    public boolean update(Proveedores proveedores) {
        try {
            conectar();
            entity.merge(proveedores);
            entity.getTransaction().commit();
            desconectar();
            return false;
        } catch (Exception e) {
            desconectar();
            return false;
        }
    }

    public boolean delete(String cedula) {
        try {
            conectar();
            Proveedores proveedor = entity.find(Proveedores.class, cedula);
            entity.remove(proveedor);
            entity.getTransaction().commit();
            desconectar();
            return true;
        } catch (Exception e) {
            desconectar();
            return false;
        }
    }

    public List<Proveedores> list() {
        try {
            conectar();
            List<Proveedores> list = entity.createNamedQuery("Proveedores.findByCedula", Proveedores.class).getResultList();
            desconectar();
            return list;
        } catch (Exception e) {
            desconectar();
            return null;
        }
    }

}
