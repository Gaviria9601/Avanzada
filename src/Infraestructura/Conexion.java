/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestructura;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Santiago Gaviria Oliveros
 */
public abstract class Conexion {
    
    protected EntityManagerFactory factory;
    protected EntityManager entity;

    public void conectar() {
        factory = Persistence.createEntityManagerFactory("AvanzadaPU");
        entity = factory.createEntityManager();
        entity.getTransaction().begin();
    }

    public void desconectar() {
        entity.close();
        factory.close();
    }
    
}
