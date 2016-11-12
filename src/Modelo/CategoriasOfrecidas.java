/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santiago Gaviria Oliveros
 */
@Entity
@Table(name = "categoriasofrecidas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriasOfrecidas.findAll", query = "SELECT c FROM CategoriasOfrecidas c where c.proveedor.cedula=:cedulaPro"),
    @NamedQuery(name = "CategoriasOfrecidas.findByCategorias", query = "SELECT c FROM CategoriasOfrecidas c WHERE c.categorias = :categoriaCodigo"),
    @NamedQuery(name = "CategoriasOfrecidas.findByProveedores", query = "SELECT c FROM CategoriasOfrecidas c WHERE c.proveedor = :proveedorCedula"),})
public class CategoriasOfrecidas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CategoriasOfrecidasPK categoriasOfrecidasPK;
    @JoinColumn(name = "Proveedores_cedula", referencedColumnName = "cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proveedores proveedor;
    @JoinColumn(name = "Categorias_codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Categorias categorias;

    public CategoriasOfrecidas() {
    }

    public CategoriasOfrecidas(CategoriasOfrecidasPK categoriasOfrecidasPK) {
        this.categoriasOfrecidasPK = categoriasOfrecidasPK;
    }

    public CategoriasOfrecidas(String proveedor, Integer categorias) {
        this.categoriasOfrecidasPK = new CategoriasOfrecidasPK(proveedor, categorias);
    }

    public CategoriasOfrecidas(Proveedores proveedor, Categorias categorias) {
        this.proveedor = proveedor;
        this.categorias = categorias;
    }
    
    

    public CategoriasOfrecidasPK getCategoriasOfrecidasPK() {
        return categoriasOfrecidasPK;
    }

    public void setCategoriasOfrecidasPK(CategoriasOfrecidasPK categoriasOfrecidasPK) {
        this.categoriasOfrecidasPK = categoriasOfrecidasPK;
    }

    public Proveedores getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedores proveedor) {
        this.proveedor = proveedor;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoriasOfrecidasPK != null ? categoriasOfrecidasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriasOfrecidas)) {
            return false;
        }
        CategoriasOfrecidas other = (CategoriasOfrecidas) object;
        if ((this.categoriasOfrecidasPK == null && other.categoriasOfrecidasPK != null) || (this.categoriasOfrecidasPK != null && !this.categoriasOfrecidasPK.equals(other.categoriasOfrecidasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CategoriasOfrecidas{" + "categoriasOfrecidasPK=" + categoriasOfrecidasPK + '}';
    }

}
