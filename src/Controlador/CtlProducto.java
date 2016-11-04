/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ProductoDAO;
import Modelo.Administradores;
import Modelo.Categorias;
import Modelo.Productos;
import java.util.List;

/**
 *
 * @author Santiago Gaviria Oliveros
 */
public class CtlProducto {

    ProductoDAO dao;

    public CtlProducto() {
        dao = new ProductoDAO();
    }

    public boolean save(String nombre, String descripcion, String cedulaAdmin, int codigoCate) {
        Productos producto = new Productos(nombre, descripcion, new Administradores(cedulaAdmin), new Categorias(codigoCate));
        return dao.save(producto);
    }

    public Productos search(int codigo) {
        return dao.search(codigo);
    }

    public Productos searchCate(int codigo) {
        return dao.searchCate(codigo);
    }

    public boolean update(int codigo, String nombre, String descripcion, String cedulaAdmin, int codigoCate) {
        Productos producto = new Productos(codigo, nombre, descripcion, new Administradores(cedulaAdmin), new Categorias(codigoCate));
        return dao.update(producto);
    }

    public boolean delete(int codigo) {
        return dao.delete(codigo);
    }

    public List<Productos> list() {
        return dao.list();
    }

    public List<Productos> listCategoria(int codigo) {
        return dao.listCategoria(codigo);
    }

}
