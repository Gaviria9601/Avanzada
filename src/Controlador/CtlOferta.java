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

    public boolean saveOferta(double valor, Date fechaoferta, String detallesoferta, int subastasCodigosubasta, String proveedoresCedula) {
        Ofertas oferta = new Ofertas(valor, fechaoferta, detallesoferta, new Subastas(subastasCodigosubasta), new Proveedores(proveedoresCedula),"Participando");
        return ofertaDao.save(oferta);
    }

    public Ofertas searchOferta(int codigooferta) {
        return ofertaDao.search(codigooferta);
    }

    public Ofertas searchOfertaSubasta(int subastasCodigosubasta) {
        return ofertaDao.searchOfertaSubasta(subastasCodigosubasta);
    }

    public boolean updateOferta(int codigooferta, double valor, Date fechaoferta, String detallesoferta, Subastas subastasCodigosubasta, Proveedores proveedoresCedula,String res) {
        Ofertas oferta = new Ofertas(codigooferta, valor, fechaoferta, detallesoferta, subastasCodigosubasta, proveedoresCedula,res);
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

    public List<Ofertas> listPro(String cedula) {
        return ofertaDao.listPro(cedula);
    }

}
