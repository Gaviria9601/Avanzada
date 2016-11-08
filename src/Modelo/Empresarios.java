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
@Table(name = "empresarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresarios.findAll", query = "SELECT e FROM Empresarios e"),
    @NamedQuery(name = "Empresarios.findByCedula", query = "SELECT e FROM Empresarios e WHERE e.cedula = :cedula"),
    @NamedQuery(name = "Empresarios.findByNombrecompleto", query = "SELECT e FROM Empresarios e WHERE e.nombrecompleto = :nombrecompleto"),
    @NamedQuery(name = "Empresarios.findByNicknameyContrasenia", query = "SELECT e FROM Empresarios e WHERE e.nickname = :nickname AND e.contrasenia = :contrasenia"),
    @NamedQuery(name = "Empresarios.findByNickname", query = "SELECT e FROM Empresarios e WHERE e.nickname = :nickname"),
    @NamedQuery(name = "Empresarios.findByDireccion", query = "SELECT e FROM Empresarios e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Empresarios.findByNombreentidad", query = "SELECT e FROM Empresarios e WHERE e.nombreentidad = :nombreentidad")})
public class Empresarios implements Serializable {

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
    @JoinColumn(name = "municipios_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Municipios municipiosId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresariosCedula")
    private Collection<Subastas> subastasCollection;

    public Empresarios() {
    }

    public Empresarios(String cedula) {
        this.cedula = cedula;
    }

    public Empresarios(String cedula, String nombrecompleto, String nickname, String contrasenia, String direccion, String nombreentidad, Municipios idmunicpio) {
        this.cedula = cedula;
        this.nombrecompleto = nombrecompleto;
        this.nickname = nickname;
        this.contrasenia = contrasenia;
        this.nombreentidad = nombreentidad;
        this.municipiosId = idmunicpio;
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

    public Municipios getMunicipiosId() {
        return municipiosId;
    }

    public void setMunicipiosId(Municipios municipiosId) {
        this.municipiosId = municipiosId;
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
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresarios)) {
            return false;
        }
        Empresarios other = (Empresarios) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Empresarios[ cedula=" + cedula + " ]";
    }

}
