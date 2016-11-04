/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Infraestructura.Conexion;
import Modelo.Empresarios;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class EmpresarioDAO extends Conexion {

    public EmpresarioDAO() {
        conectar();
    }

    public boolean save(Empresarios empresario) {
        try {
            conectar();
            entity.persist(empresario);
            entity.getTransaction().commit();
            desconectar();
            return true;
        } catch (Exception e) {
            desconectar();
            return false;
        }
    }

    public Empresarios search(String cedula) {
        try {
            Empresarios emp = entity.createNamedQuery("Empresarios.findByCedula", Empresarios.class)
                    .setParameter("cedula", cedula).getSingleResult();
            desconectar();
            return emp;
        } catch (Exception e) {
            desconectar();
            return null;
        }
    }
    
    public Empresarios searchLogin(String nickname, String contrasenia ){
        try{
            Empresarios emp = entity.createNamedQuery("Empresarios.findByNicknameyContrasenia", Empresarios.class)
                    .setParameter("nickname", nickname)
                    .setParameter("contrasenia", contrasenia).getSingleResult();
            return emp;
        }catch(Exception e){
            return null;
        }
    }

    public boolean update(Empresarios empresario) {
        try {
            //Si lo encuentra lo actualiza, si no existe lo crea
            entity.merge(empresario);
            entity.getTransaction().commit();
            desconectar();
            return true;
        } catch (Exception e) {
            desconectar();
            return false;
        }
    }

    public boolean delete(String cedula) {
        try {
            Empresarios emp = entity.find(Empresarios.class, cedula);
            entity.remove(emp);
            entity.getTransaction().commit();
            desconectar();
            return true;
        } catch (Exception e) {
            desconectar();
            return false;
        }
    }

    public List<Empresarios> list() {
        try {
            List<Empresarios> list = entity.createNamedQuery("Empresarios.findAll", Empresarios.class).getResultList();
            desconectar();
            return list;
        } catch (Exception e) {
            desconectar();
            return null;
        }
    }
}
