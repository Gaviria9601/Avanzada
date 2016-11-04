/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Infraestructura.Conexion;
import Modelo.Categorias;
import java.util.List;

/**
 *
 * @author Santiago Gaviria Oliveros
 */
public class CategoriaDAO extends Conexion {

    public CategoriaDAO() {
        conectar();
    }

    public boolean save(Categorias categoria) {
        try {
            conectar();
            entity.persist(categoria);
            entity.getTransaction().commit();
            desconectar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Categorias search(int codigo) {
        try {
            conectar();
            Categorias categoria = entity.createNamedQuery("Categorias.findByCodigo", Categorias.class)
                    .setParameter("codigo", codigo).getSingleResult();
            desconectar();
            return categoria;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Categorias searchNombre(String nombre) {
        try {
            conectar();
            Categorias categoria = entity.createNamedQuery("Categorias.findByNombre", Categorias.class)
                    .setParameter("nombre", nombre).getSingleResult();
            desconectar();
            return categoria;
        } catch (Exception e) {
            return null;
        }
    }



    public boolean update(Categorias categoria) {
        try {
            if (search(categoria.getCodigo()) != null) {
                conectar();
                entity.merge(categoria);
                entity.getTransaction().commit();
                desconectar();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(int codigo) {
        try {
            conectar();
            Categorias categoria = entity.find(Categorias.class, codigo);
            entity.remove(categoria);
            entity.getTransaction().commit();
            desconectar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Categorias> list() {
        try {
            conectar();
            List<Categorias> list = entity.createNamedQuery("Categorias.findAll", Categorias.class).getResultList();
            desconectar();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

}
