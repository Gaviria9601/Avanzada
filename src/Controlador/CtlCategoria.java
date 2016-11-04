/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.CategoriaDAO;
import Modelo.Categorias;
import java.util.List;

/**
 *
 * @author Santiago Gaviria Oliveros
 */
public class CtlCategoria {

    CategoriaDAO dao;

    public CtlCategoria() {
        dao = new CategoriaDAO();
    }

    public boolean save(String nombre, String descripcion) {
        Categorias cate = new Categorias(nombre, descripcion);
        return dao.save(cate);
    }

    public Categorias search(int codigo) {
        return dao.search(codigo);
    }
    
    public Categorias searchNombre(String nombre) {
        return dao.searchNombre(nombre);
    }

    public boolean update(int codigo,String nombre, String descripcion) {
        Categorias cate = new Categorias(codigo,nombre, descripcion);
        return dao.update(cate);
    }

    public boolean delete(int codigo) {
        return dao.delete(codigo);
    }

    public List<Categorias> list() {
        return dao.list();
    }

    public Categorias BuscarDes(String nombre) {
        return dao.searchNombre(nombre);
    }

}
