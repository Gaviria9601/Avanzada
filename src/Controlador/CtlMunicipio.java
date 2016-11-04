/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.MunicipioDAO;
import Modelo.Municipios;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CtlMunicipio {

    MunicipioDAO dao;

    public CtlMunicipio() {
        dao = new MunicipioDAO();
    }

    public List<Municipios> list(String nombre) {
        return dao.list(nombre);
    }
    
    public Municipios searchMunNombre(String nombre){
        return dao.searchMunNombre(nombre);
    }
    
}
