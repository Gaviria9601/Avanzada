/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Santiago Gaviria Oliveros
 */
@Embeddable
public class CategoriasOfrecidasPK implements Serializable{
    @Basic(optional = false)
    @Column(name = "Proveedores_cedula")
    private String proveedoresCedula;
    @Basic(optional = false)
    @Column(name = "Categorias_codigo")
    private Integer categoriasCodigo;

    public CategoriasOfrecidasPK(){
        
    }
    
    public CategoriasOfrecidasPK(String proveedoresCedula, Integer categoriasCodigo) {
        this.proveedoresCedula = proveedoresCedula;
        this.categoriasCodigo = categoriasCodigo;
    }

    public String getProveedoresCedula() {
        return proveedoresCedula;
    }

    public void setProveedoresCedula(String proveedoresCedula) {
        this.proveedoresCedula = proveedoresCedula;
    }

    public Integer getCategoriasCodigo() {
        return categoriasCodigo;
    }

    public void setCategoriasCodigo(Integer categoriasCodigo) {
        this.categoriasCodigo = categoriasCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proveedoresCedula != null ? proveedoresCedula.hashCode() : 0);
        hash += (categoriasCodigo != null ? categoriasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriasOfrecidasPK)) {
            return false;
        }
        CategoriasOfrecidasPK other = (CategoriasOfrecidasPK) object;
        if ((this.proveedoresCedula == null && other.proveedoresCedula != null) || (this.proveedoresCedula != null && !this.proveedoresCedula.equals(other.proveedoresCedula))) {
            return false;
        }
        if ((this.categoriasCodigo == null && other.categoriasCodigo != null) || (this.categoriasCodigo != null && !this.categoriasCodigo.equals(other.categoriasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CategoriasOfrecidasPK{" + "proveedoresCedula=" + proveedoresCedula + ", categoriasCodigo=" + categoriasCodigo + '}';
    }
    
    
    
    
}
