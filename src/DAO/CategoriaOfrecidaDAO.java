/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Infraestructura.Conexion;
import Modelo.Categorias;
import Modelo.CategoriasOfrecidas;
import Modelo.CategoriasOfrecidasPK;
import Modelo.Proveedores;
import java.util.List;

/**
 *
 * @author Santiago Gaviria Oliveros
 */
public class CategoriaOfrecidaDAO extends Conexion {

    public CategoriaOfrecidaDAO() {
        conectar();
    }

    public boolean save(CategoriasOfrecidas categoriaOfre) {
        try {
            conectar();
            entity.persist(categoriaOfre);
            entity.getTransaction().commit();
            desconectar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(String cedula, int codigo) {
        System.out.println(cedula + "-" + codigo);
        try {
            conectar();
            CategoriasOfrecidasPK catePk = new CategoriasOfrecidasPK(cedula, codigo);
            CategoriasOfrecidas cate = entity.find(CategoriasOfrecidas.class,catePk);
            entity.remove(cate);
            entity.getTransaction().commit();
            desconectar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<CategoriasOfrecidas> list(String cedulaPro) {
        try {
            conectar();
            List<CategoriasOfrecidas> list = entity.createNamedQuery("CategoriasOfrecidas.findAll", CategoriasOfrecidas.class)
                    .setParameter("cedulaPro", cedulaPro)
                    .getResultList();
            desconectar();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

}
