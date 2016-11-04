/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Infraestructura.Conexion;
import Modelo.Administradores;
import java.util.List;

/**
 *
 * @author Santiago Gaviria Oliveros
 */
public class AdministradorDAO extends Conexion {

    public AdministradorDAO() {
        conectar();
    }

    public boolean save(Administradores administrador) {
        try {
            entity.persist(administrador);
            entity.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Administradores search(String cedula) {
        try {
            Administradores adm = entity.createNamedQuery("Administradores.findByCedula", Administradores.class)
                    .setParameter("cedula", cedula).getSingleResult();
            return adm;
        } catch (Exception e) {
            return null;
        }
    }

    public Administradores searchNombre(String nombre) {
        try {
            Administradores adm = entity.createNamedQuery("Administradores.findByNombre", Administradores.class)
                    .setParameter("nombre", nombre).getSingleResult();
            return adm;
        } catch (Exception e) {
            return null;
        }
    }

    public Administradores searchLogin(String nickname, String contrasenia) {
        try {
            Administradores adm = entity.createNamedQuery("Administradores.findByNombreyContrasenia", Administradores.class)
                    .setParameter("nombre", nickname)
                    .setParameter("contrasenia", contrasenia).getSingleResult();
            return adm;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean update(Administradores administradores) {
        try {
            //Si lo encuentra lo actualiza, si no existe lo crea
            entity.merge(administradores);
            entity.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(String cedula) {
        try {
            Administradores emp = entity.find(Administradores.class, cedula);
            entity.remove(emp);
            entity.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Administradores> list() {
        try {
            List<Administradores> list = entity.createNamedQuery("Administradores.findAll", Administradores.class).getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

}
