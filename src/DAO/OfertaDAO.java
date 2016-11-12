/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Infraestructura.Conexion;
import Modelo.Ofertas;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class OfertaDAO extends Conexion {

    public OfertaDAO() {
        conectar();
    }

    public boolean save(Ofertas oferta) {
        try {
            conectar();
            entity.persist(oferta);
            entity.getTransaction().commit();
            desconectar();
            return true;
        } catch (Exception e) {
            return false;

        }
    }

    public Ofertas search(int codigooferta) {
        try {
            conectar();
            Ofertas oferta = entity.createNamedQuery("Ofertas.findByCodigooferta", Ofertas.class)
                    .setParameter("codigooferta", codigooferta).getSingleResult();
            desconectar();
            return oferta;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Ofertas searchValor(double valor) {
        try {
            conectar();
            Ofertas oferta = entity.createNamedQuery("Ofertas.findByValor", Ofertas.class)
                    .setParameter("valor", valor).getSingleResult();
            desconectar();
            return oferta;
        } catch (Exception e) {
            return null;
        }
    }

    public Ofertas searchOfertaSubasta(int subastasCodigosubasta) {
        try {
            conectar();
            Ofertas ofe = entity.createNamedQuery("Ofertas.findByOferta", Ofertas.class)
                    .setParameter("codsubasta", subastasCodigosubasta).getSingleResult();
            return ofe;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean update(Ofertas oferta) {
        try {
            conectar();
            if (search(oferta.getCodigooferta()) != null) {
                conectar();
                entity.merge(oferta);
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

    public boolean delete(int codigooferta) {
        try {
            conectar();
            Ofertas oferta = entity.find(Ofertas.class, codigooferta);
            entity.remove(oferta);
            entity.getTransaction().commit();
            desconectar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Ofertas> listarOfertaSolicitud(int subastasCodigosubasta) {
        try {
            conectar();
            List<Ofertas> list = entity.createNamedQuery("Ofertas.findByOferta", Ofertas.class)
                    .setParameter("codsubasta", subastasCodigosubasta)
                    .getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }

    }

    public List<Ofertas> list() {
        try {
            conectar();
            List<Ofertas> list = entity.createNamedQuery("Ofertas.findAll", Ofertas.class).getResultList();
            desconectar();
            return list;
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Ofertas> listPro(String cedula) {
        try {
            conectar();
            List<Ofertas> list = entity.createNamedQuery("Ofertas.findByOfertafull", Ofertas.class)
                    .setParameter("cedula", cedula)
                    .getResultList();
            desconectar();
            return list;
        } catch (Exception e) {
            return null;
        }
    }
}
