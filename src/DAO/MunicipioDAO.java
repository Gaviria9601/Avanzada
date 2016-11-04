/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Infraestructura.Conexion;
import Modelo.Municipios;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class MunicipioDAO extends Conexion {

    public MunicipioDAO() {
        conectar();
    }

    public List<Municipios> list(String nombre) {
        try {
            List<Municipios> list = entity.createNamedQuery("Municipios.findAllDepto", Municipios.class)
                    .setParameter("depaNombre", nombre).getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public Municipios searchMunNombre(String nombre) {
        try {
            Municipios adm = entity.createNamedQuery("Municipios.findByNombre", Municipios.class)
                    .setParameter("nombre", nombre).getSingleResult();
            return adm;
        } catch (Exception e) {
            return null;
        }

    }

}
