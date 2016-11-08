/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.OfertaDAO;
import Modelo.Ofertas;
import Modelo.Proveedores;
import Modelo.Subastas;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CtlOferta {

    OfertaDAO ofertaDao;

    public CtlOferta() {
        ofertaDao = new OfertaDAO();
    }

    public boolean saveOferta(int codigooferta, double valor, Date fechaoferta, String detallesoferta, Subastas subastasCodigosubasta, Proveedores proveedoresCedula) {
        Ofertas oferta = new Ofertas(codigooferta, valor, fechaoferta, detallesoferta, subastasCodigosubasta, proveedoresCedula);
        return ofertaDao.save(oferta);
    }

    public Ofertas searchOferta(int codigooferta) {
        return ofertaDao.search(codigooferta);
    }

    public Ofertas searchOfertaSubasta(int subastasCodigosubasta) {
        return ofertaDao.searchOfertaSubasta(subastasCodigosubasta);
    }

    public boolean updateOferta(int codigooferta, double valor, Date fechaoferta, String detallesoferta, Subastas subastasCodigosubasta, Proveedores proveedoresCedula) {
        Ofertas oferta = new Ofertas(codigooferta, valor, fechaoferta, detallesoferta, subastasCodigosubasta, proveedoresCedula);
        return ofertaDao.update(oferta);
    }

    public boolean deleteOferta(int codigooferta) {
        return ofertaDao.delete(codigooferta);
    }

    public List<Ofertas> listOferta() {
        return ofertaDao.list();
    }

    public List<Ofertas> listOfertaSolicitud(int subastasCodigosubasta) {
        return ofertaDao.listarOfertaSolicitud(subastasCodigosubasta);
    }

}
