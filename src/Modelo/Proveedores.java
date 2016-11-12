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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "proveedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p"),
    @NamedQuery(name = "Proveedores.findByCedula", query = "SELECT p FROM Proveedores p WHERE p.cedula = :cedula"),
    @NamedQuery(name = "Proveedores.findByNickname", query = "SELECT p FROM Proveedores p WHERE p.nickname = :nickname"),
    @NamedQuery(name = "Proveedores.findByNombrecompleto", query = "SELECT p FROM Proveedores p WHERE p.nombrecompleto = :nombrecompleto"),
    @NamedQuery(name = "Proveedores.findByNicknameyContrasenia", query = "SELECT p FROM Proveedores p WHERE p.nickname = :nickname AND p.contrasenia=:contrasenia"),
    @NamedQuery(name = "Proveedores.findByDireccion", query = "SELECT p FROM Proveedores p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Proveedores.findByNombreentidad", query = "SELECT p FROM Proveedores p WHERE p.nombreentidad = :nombreentidad")})
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @Column(name = "nombrecompleto")
    private String nombrecompleto;
    @Basic(optional = false)
    @Column(name = "nickname")
    private String nickname;
    @Basic(optional = false)
    @Column(name = "contrasenia")
    private String contrasenia;
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "nombreentidad")
    private String nombreentidad;
    @ManyToMany(mappedBy = "proveedoresCollection")
    private Collection<Categorias> categoriasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedoresCedula")
    private Collection<Ofertas> ofertasCollection;
    @JoinColumn(name = "municipios_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Municipios municipiosId;

    public Proveedores() {
    }

    public Proveedores(String cedula) {
        this.cedula = cedula;
    }

    public Proveedores(String cedula, String nombrecompleto, String nickname, String contrasenia, String direccion, String nombreentidad, Municipios idMunicipio) {
        this.cedula = cedula;
        this.nombrecompleto = nombrecompleto;
        this.nickname = nickname;
        this.contrasenia = contrasenia;
        this.nombreentidad = nombreentidad;
        this.municipiosId = idMunicipio;
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreentidad() {
        return nombreentidad;
    }

    public void setNombreentidad(String nombreentidad) {
        this.nombreentidad = nombreentidad;
    }

    @XmlTransient
    public Collection<Categorias> getCategoriasCollection() {
        return categoriasCollection;
    }

    public void setCategoriasCollection(Collection<Categorias> categoriasCollection) {
        this.categoriasCollection = categoriasCollection;
    }

    @XmlTransient
    public Collection<Ofertas> getOfertasCollection() {
        return ofertasCollection;
    }

    public void setOfertasCollection(Collection<Ofertas> ofertasCollection) {
        this.ofertasCollection = ofertasCollection;
    }

    public Municipios getMunicipiosId() {
        return municipiosId;
    }

    public void setMunicipiosId(Municipios municipiosId) {
        this.municipiosId = municipiosId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Proveedores[ cedula=" + cedula + " ]";
    }

}
