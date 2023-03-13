/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stive
 */
@Entity
@Table(name = "registro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registro.findAll", query = "SELECT r FROM Registro r")
    , @NamedQuery(name = "Registro.findByRegUserID", query = "SELECT r FROM Registro r WHERE r.regUserID = :regUserID")
    , @NamedQuery(name = "Registro.findByRegRol", query = "SELECT r FROM Registro r WHERE r.regRol = :regRol")})
public class Registro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "RegUserID")
    private String regUserID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "RegRol")
    private String regRol;
    @OneToMany(mappedBy = "fkRegUserID")
    private Collection<Inventario> inventarioCollection;
    @JoinColumn(name = "fk_Identificacion", referencedColumnName = "UsuIdentificacion")
    @ManyToOne(optional = false)
    private Usuario fkIdentificacion;

    public Registro() {
    }

    public Registro(String regUserID) {
        this.regUserID = regUserID;
    }

    public Registro(String regUserID, String regRol) {
        this.regUserID = regUserID;
        this.regRol = regRol;
    }

    public String getRegUserID() {
        return regUserID;
    }

    public void setRegUserID(String regUserID) {
        this.regUserID = regUserID;
    }

    public String getRegRol() {
        return regRol;
    }

    public void setRegRol(String regRol) {
        this.regRol = regRol;
    }

    @XmlTransient
    public Collection<Inventario> getInventarioCollection() {
        return inventarioCollection;
    }

    public void setInventarioCollection(Collection<Inventario> inventarioCollection) {
        this.inventarioCollection = inventarioCollection;
    }

    public Usuario getFkIdentificacion() {
        return fkIdentificacion;
    }

    public void setFkIdentificacion(Usuario fkIdentificacion) {
        this.fkIdentificacion = fkIdentificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regUserID != null ? regUserID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registro)) {
            return false;
        }
        Registro other = (Registro) object;
        if ((this.regUserID == null && other.regUserID != null) || (this.regUserID != null && !this.regUserID.equals(other.regUserID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Registro[ regUserID=" + regUserID + " ]";
    }
    
}
