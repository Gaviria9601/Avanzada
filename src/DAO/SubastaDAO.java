/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Infraestructura.Conexion;
import Modelo.CategoriasOfrecidas;
import Modelo.Subastas;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Santiago Gaviria Oliveros
 */
public class SubastaDAO extends Conexion {

    public SubastaDAO() {
        conectar();
    }

    public boolean save(Subastas subasta) {
        try {
            conectar();
            this.entity.persist(subasta);
            this.entity.getTransaction().commit();
            desconectar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Subastas search(int codigo) {
        try {
            conectar();
            Subastas producto = entity.createNamedQuery("Subastas.findByCodigosubasta", Subastas.class)
                    .setParameter("codigosubasta", codigo).getSingleResult();
            desconectar();
            return producto;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Subastas> searchEnd(Date fecha) {
        try {
            conectar();
            List<Subastas> list = entity.createNamedQuery("Subastas.findByFechafinal", Subastas.class)
                    .setParameter("fechafinal", fecha).getResultList();
            desconectar();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean update(Subastas subasta) {
        try {
            conectar();
            if (search(subasta.getCodigosubasta()) != null) {
                conectar();
                entity.merge(subasta);
                entity.getTransaction().commit();
                desconectar();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(int codigo) {
        try {
            conectar();
            Subastas subasta = entity.find(Subastas.class, codigo);
            entity.remove(subasta);
            entity.getTransaction().commit();
            desconectar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Subastas> list(String cedula) {
        try {
            conectar();
            List<Subastas> list = entity.createNamedQuery("Subastas.findAllEmpre", Subastas.class)
                    .setParameter("cedula", cedula)
                    .getResultList();
            desconectar();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Subastas> listSubastasArea(List<CategoriasOfrecidas> codigoArea, String cedula) {
        List<Subastas> listRetorno = new ArrayList<>();
        try {
            conectar();
            for (int i = 0; i < codigoArea.size(); i++) {
                List<Subastas> list = entity.createNamedQuery("Subastas.findAllArea", Subastas.class)
                        .setParameter("areacodigo", codigoArea.get(i).getCategorias().getCodigo())
                        .setParameter("cedula", cedula)
                        .getResultList();
                listRetorno.addAll(list);
            }

            return listRetorno;
        } catch (Exception e) {
            return null;
        }
    }
    
    

}
