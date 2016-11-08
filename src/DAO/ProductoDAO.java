/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Infraestructura.Conexion;
import Modelo.Productos;
import java.util.List;

/**
 *
 * @author Santiago Gaviria Oliveros
 */
public class ProductoDAO extends Conexion {

    public ProductoDAO() {
        conectar();
    }

    public boolean save(Productos producto) {
        try {
            conectar();
            this.entity.persist(producto);
            this.entity.getTransaction().commit();
            desconectar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Productos search(int codigo) {
        try {
            conectar();
            Productos producto = entity.createNamedQuery("Productos.findByCodigo", Productos.class)
                    .setParameter("codigo", codigo).getSingleResult();
            desconectar();
            return producto;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Productos searchNombre(String nombre) {
        try {
            conectar();
            Productos producto = entity.createNamedQuery("Productos.findByNombreproducto", Productos.class)
                    .setParameter("nombreproducto", nombre).getSingleResult();
            desconectar();
            return producto;
        } catch (Exception e) {
            return null;
        }
    }

    public Productos searchCate(int codigo) {
        try {
            conectar();
            Productos producto = entity.createNamedQuery("Productos.findByCodCate", Productos.class)
                    .setParameter("codCate", codigo).getSingleResult();
            desconectar();
            return producto;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean update(Productos producto) {
        try {
            if (search(producto.getCodigo()) != null) {
                conectar();
                entity.merge(producto);
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
            Productos producto = entity.find(Productos.class, codigo);
            entity.remove(producto);
            entity.getTransaction().commit();
            desconectar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Productos> list() {
        try {
            conectar();
            List<Productos> list = entity.createNamedQuery("Productos.findAll", Productos.class).getResultList();
            desconectar();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Productos> listCategoria(String nombre) {
        try {
            conectar();
            List<Productos> list = entity.createNamedQuery("Productos.findByNomCate", Productos.class)
                    .setParameter("nombre", nombre).getResultList();
            desconectar();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

}
