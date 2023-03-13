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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stive
 */
@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findByIdClientes", query = "SELECT c FROM Clientes c WHERE c.idClientes = :idClientes")
    , @NamedQuery(name = "Clientes.findByCliNombre", query = "SELECT c FROM Clientes c WHERE c.cliNombre = :cliNombre")
    , @NamedQuery(name = "Clientes.findByCliDireccion", query = "SELECT c FROM Clientes c WHERE c.cliDireccion = :cliDireccion")
    , @NamedQuery(name = "Clientes.findByCliTelefon", query = "SELECT c FROM Clientes c WHERE c.cliTelefon = :cliTelefon")
    , @NamedQuery(name = "Clientes.findByCliCiudad", query = "SELECT c FROM Clientes c WHERE c.cliCiudad = :cliCiudad")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idClientes")
    private Integer idClientes;
    @Size(max = 60)
    @Column(name = "CliNombre")
    private String cliNombre;
    @Size(max = 200)
    @Column(name = "CliDireccion")
    private String cliDireccion;
    @Size(max = 60)
    @Column(name = "CliTelefon")
    private String cliTelefon;
    @Size(max = 50)
    @Column(name = "CliCiudad")
    private String cliCiudad;
    @OneToMany(mappedBy = "fkClientes")
    private Collection<Ventas> ventasCollection;

    public Clientes() {
    }

    public Clientes(Integer idClientes) {
        this.idClientes = idClientes;
    }

    public Integer getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(Integer idClientes) {
        this.idClientes = idClientes;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    public String getCliTelefon() {
        return cliTelefon;
    }

    public void setCliTelefon(String cliTelefon) {
        this.cliTelefon = cliTelefon;
    }

    public String getCliCiudad() {
        return cliCiudad;
    }

    public void setCliCiudad(String cliCiudad) {
        this.cliCiudad = cliCiudad;
    }

    @XmlTransient
    public Collection<Ventas> getVentasCollection() {
        return ventasCollection;
    }

    public void setVentasCollection(Collection<Ventas> ventasCollection) {
        this.ventasCollection = ventasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClientes != null ? idClientes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.idClientes == null && other.idClientes != null) || (this.idClientes != null && !this.idClientes.equals(other.idClientes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Clientes[ idClientes=" + idClientes + " ]";
    }
    
}
