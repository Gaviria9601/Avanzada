/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Infraestructura.Conexion;
import Modelo.Departamentos;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DepartamentoDAO extends Conexion {

    public DepartamentoDAO() {
        conectar();
    }

    public List<Departamentos> list() {
        try {
            conectar();
            List<Departamentos> list = entity.createNamedQuery("Departamentos.findAll", Departamentos.class).getResultList();
            return list;
        } catch (Exception e) {
            desconectar();
            return null;
        }
    }
}
