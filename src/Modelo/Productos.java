/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Santiago Gaviria Oliveros
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByCodigo", query = "SELECT p FROM Productos p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Productos.findByNombreproducto", query = "SELECT p FROM Productos p WHERE p.nombreproducto = :nombreproducto"),
    @NamedQuery(name = "Productos.findByDescripcion", query = "SELECT p FROM Productos p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Productos.findByCodCate", query = "SELECT p FROM Productos p WHERE p.categorias_Codigo.codigo = :codCate")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "nombreproducto")
    private String nombreproducto;
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "categorias_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Categorias categorias_Codigo;
    @JoinColumn(name = "administradores_cedula", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Administradores administradoresCedula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productosCodigo")
    private Collection<Subastas> subastasCollection;

    public Productos() {
    }

    public Productos(Integer codigo) {
        this.codigo = codigo;
    }

    public Productos(String nombreproducto, String descripcion, Administradores admin, Categorias cate) {
        this.nombreproducto = nombreproducto;
        this.descripcion = descripcion;
        this.administradoresCedula = admin;
        this.categorias_Codigo = cate;
    }

    public Productos(int codigo, String nombreproducto, String descripcion, Administradores admin, Categorias cate) {
        this.codigo = codigo;
        this.nombreproducto = nombreproducto;
        this.descripcion = descripcion;
        this.administradoresCedula = admin;
        this.categorias_Codigo = cate;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categorias getCategoriasCodigo() {
        return categorias_Codigo;
    }

    public void setCategoriasCodigo(Categorias categoriasCodigo) {
        this.categorias_Codigo = categoriasCodigo;
    }

    public Administradores getAdministradoresCedula() {
        return administradoresCedula;
    }

    public void setAdministradoresCedula(Administradores administradoresCedula) {
        this.administradoresCedula = administradoresCedula;
    }

    @XmlTransient
    public Collection<Subastas> getSubastasCollection() {
        return subastasCollection;
    }

    public void setSubastasCollection(Collection<Subastas> subastasCollection) {
        this.subastasCollection = subastasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Productos[ codigo=" + codigo + " ]";
    }

}
