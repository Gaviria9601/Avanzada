/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.CategoriaOfrecidaDAO;
import Modelo.CategoriasOfrecidas;
import Modelo.CategoriasOfrecidasPK;
import java.util.List;

/**
 *
 * @author Santiago Gaviria Oliveros
 */
public class CtlCategoriaOfrecida {

    CategoriaOfrecidaDAO dao;

    public CtlCategoriaOfrecida() {
        dao = new CategoriaOfrecidaDAO();
    }

    public boolean save(String cedulaProvee, int codigo) {
        CategoriasOfrecidas cateOfre = new CategoriasOfrecidas(cedulaProvee, codigo);
        return dao.save(cateOfre);
    }

    public boolean delete(String cedulaProvee, int codigo) {
        return dao.delete(cedulaProvee,codigo);

    }

    public List<CategoriasOfrecidas> list(String cedulaPro) {
        return dao.list(cedulaPro);
    }

}
