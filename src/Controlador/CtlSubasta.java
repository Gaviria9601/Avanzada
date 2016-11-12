/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.SubastaDAO;
import Modelo.CategoriasOfrecidas;
import Modelo.Empresarios;
import Modelo.Productos;
import Modelo.Subastas;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Santiago Gaviria Oliveros
 */
public class CtlSubasta {

    SubastaDAO dao;

    public CtlSubasta() {
        dao = new SubastaDAO();
    }

    public boolean save(int cantidad, boolean estado, Date fechaInicio, Date fechaFinal, Date fechEntrega, String Descripcion, String Empresario,
            int codigo) {
        Subastas subasta = new Subastas(cantidad, estado, fechaInicio, fechaFinal, fechEntrega, Descripcion,
                new Empresarios(Empresario), new Productos(codigo));
        return dao.save(subasta);
    }

    public Subastas search(int codigo) {
        return dao.search(codigo);
    }

    public List<Subastas> searchEnd(Date fecha) {
        return dao.searchEnd(fecha);
    }

    public boolean update(int codigoSubasta, int cantidad, boolean estado, Date fechaInicio, Date fechaFinal, Date fechEntrega, String Descripcion, String Empresario,
            int codigo) {
        Subastas subasta = new Subastas(codigoSubasta, cantidad, estado, fechaInicio, fechaFinal, fechEntrega, Descripcion,
                new Empresarios(Empresario), new Productos(codigo));
        return dao.update(subasta);
    }

    public boolean delete(int codigo) {
        return dao.delete(codigo);
    }

    public List<Subastas> list(String cedula) {
        return dao.list(cedula);
    }

    public List<Subastas> listSubastasArea(List<CategoriasOfrecidas> codigoArea, String cedula) {
        return dao.listSubastasArea(codigoArea, cedula);
    }

   
}
