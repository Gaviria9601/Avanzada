/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Santiago Gaviria Oliveros
 */
@Entity
@Table(name = "subastas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subastas.findAll", query = "SELECT s FROM Subastas s where s.estado='TRUE'"),
    @NamedQuery(name = "Subastas.findAllEmpre", query = "SELECT s FROM Subastas s where s.estado='TRUE' and s.empresariosCedula.cedula=:cedula"),
    @NamedQuery(name = "Subastas.findAllArea", query = "select s from Subastas s join s.productosCodigo po join po.categorias_Codigo ca join ca.proveedoresCollection pro where ca.codigo=:areacodigo and pro.cedula=:cedula and s.estado=true"),
    @NamedQuery(name = "Subastas.findByCodigosubasta", query = "SELECT s FROM Subastas s WHERE s.codigosubasta = :codigosubasta"),
    @NamedQuery(name = "Subastas.findByCantidadproductos", query = "SELECT s FROM Subastas s WHERE s.cantidadproductos = :cantidadproductos"),
    @NamedQuery(name = "Subastas.findByEstado", query = "SELECT s FROM Subastas s WHERE s.estado = :estado"),
    @NamedQuery(name = "Subastas.findByFechainicio", query = "SELECT s FROM Subastas s WHERE s.fechainicio = :fechainicio"),
    @NamedQuery(name = "Subastas.findByFechafinal", query = "SELECT s FROM Subastas s WHERE s.fechafinal <= :fechafinal"),
    @NamedQuery(name = "Subastas.findByFechaentrega", query = "SELECT s FROM Subastas s WHERE s.fechaentrega = :fechaentrega"),
    @NamedQuery(name = "Subastas.findByDescripcion", query = "SELECT s FROM Subastas s WHERE s.descripcion = :descripcion")})
public class Subastas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigosubasta")
    private Integer codigosubasta;
    @Basic(optional = false)
    @Column(name = "cantidadproductos")
    private int cantidadproductos;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Basic(optional = false)
    @Column(name = "fechafinal")
    @Temporal(TemporalType.DATE)
    private Date fechafinal;
    @Basic(optional = false)
    @Column(name = "fechaentrega")
    @Temporal(TemporalType.DATE)
    private Date fechaentrega;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subastas_codigosubasta")
    private Collection<Ofertas> ofertasCollection;
    @JoinColumn(name = "productos_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Productos productosCodigo;
    @JoinColumn(name = "empresarios_cedula", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Empresarios empresariosCedula;

    public Subastas() {
    }

    public Subastas(Integer codigosubasta) {
        this.codigosubasta = codigosubasta;
    }

    public Subastas(int cantidadproductos, boolean estado, Date fechainicio, Date fechafinal, Date fechaentrega, String descripcion,
            Empresarios empre, Productos pro) {
        this.cantidadproductos = cantidadproductos;
        this.estado = estado;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.fechaentrega = fechaentrega;
        this.descripcion = descripcion;
        this.empresariosCedula = empre;
        this.productosCodigo = pro;

    }

    public Subastas(int codigoSub, int cantidadproductos, boolean estado, Date fechainicio, Date fechafinal, Date fechaentrega, String descripcion,
            Empresarios empre, Productos pro) {
        this.codigosubasta = codigoSub;
        this.cantidadproductos = cantidadproductos;
        this.estado = estado;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.fechaentrega = fechaentrega;
        this.descripcion = descripcion;
        this.empresariosCedula = empre;
        this.productosCodigo = pro;

    }

    public Integer getCodigosubasta() {
        return codigosubasta;
    }

    public void setCodigosubasta(Integer codigosubasta) {
        this.codigosubasta = codigosubasta;
    }

    public int getCantidadproductos() {
        return cantidadproductos;
    }

    public void setCantidadproductos(int cantidadproductos) {
        this.cantidadproductos = cantidadproductos;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }

    public Date getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(Date fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Ofertas> getOfertasCollection() {
        return ofertasCollection;
    }

    public void setOfertasCollection(Collection<Ofertas> ofertasCollection) {
        this.ofertasCollection = ofertasCollection;
    }

    public Productos getProductosCodigo() {
        return productosCodigo;
    }

    public void setProductosCodigo(Productos productosCodigo) {
        this.productosCodigo = productosCodigo;
    }

    public Empresarios getEmpresariosCedula() {
        return empresariosCedula;
    }

    public void setEmpresariosCedula(Empresarios empresariosCedula) {
        this.empresariosCedula = empresariosCedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigosubasta != null ? codigosubasta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subastas)) {
            return false;
        }
        Subastas other = (Subastas) object;
        if ((this.codigosubasta == null && other.codigosubasta != null) || (this.codigosubasta != null && !this.codigosubasta.equals(other.codigosubasta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Subastas[ codigosubasta=" + codigosubasta + " ]";
    }

}
