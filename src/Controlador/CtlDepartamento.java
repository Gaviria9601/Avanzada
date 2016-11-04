/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DepartamentoDAO;
import Modelo.Departamentos;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CtlDepartamento {

    DepartamentoDAO dao;

    public CtlDepartamento() {
        dao = new DepartamentoDAO();
    }

    public List<Departamentos> list() {
        return dao.list();
    }
}
