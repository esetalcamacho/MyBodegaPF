/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findByIdProductos", query = "SELECT p FROM Productos p WHERE p.idProductos = :idProductos")
    , @NamedQuery(name = "Productos.findByProNombre", query = "SELECT p FROM Productos p WHERE p.proNombre = :proNombre")
    , @NamedQuery(name = "Productos.findByProCantidad", query = "SELECT p FROM Productos p WHERE p.proCantidad = :proCantidad")
    , @NamedQuery(name = "Productos.findByProPrecio", query = "SELECT p FROM Productos p WHERE p.proPrecio = :proPrecio")
    , @NamedQuery(name = "Productos.findByProUnidadMedida", query = "SELECT p FROM Productos p WHERE p.proUnidadMedida = :proUnidadMedida")
    , @NamedQuery(name = "Productos.findByProObservaciones", query = "SELECT p FROM Productos p WHERE p.proObservaciones = :proObservaciones")
    , @NamedQuery(name = "Productos.findByProStatus", query = "SELECT p FROM Productos p WHERE p.proStatus = :proStatus")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProductos")
    private Integer idProductos;
    @Size(max = 50)
    @Column(name = "ProNombre")
    private String proNombre;
    @Column(name = "ProCantidad")
    private Integer proCantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ProPrecio")
    private BigDecimal proPrecio;
    @Size(max = 10)
    @Column(name = "ProUnidadMedida")
    private String proUnidadMedida;
    @Size(max = 500)
    @Column(name = "ProObservaciones")
    private String proObservaciones;
    @Size(max = 50)
    @Column(name = "ProStatus")
    private String proStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venProducto")
    private Collection<Ventas> ventasCollection;
    @OneToMany(mappedBy = "fkProducto")
    private Collection<Inventario> inventarioCollection;

    public Productos() {
    }

    public Productos(Integer idProductos) {
        this.idProductos = idProductos;
    }

    public Integer getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(Integer idProductos) {
        this.idProductos = idProductos;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public Integer getProCantidad() {
        return proCantidad;
    }

    public void setProCantidad(Integer proCantidad) {
        this.proCantidad = proCantidad;
    }

    public BigDecimal getProPrecio() {
        return proPrecio;
    }

    public void setProPrecio(BigDecimal proPrecio) {
        this.proPrecio = proPrecio;
    }

    public String getProUnidadMedida() {
        return proUnidadMedida;
    }

    public void setProUnidadMedida(String proUnidadMedida) {
        this.proUnidadMedida = proUnidadMedida;
    }

    public String getProObservaciones() {
        return proObservaciones;
    }

    public void setProObservaciones(String proObservaciones) {
        this.proObservaciones = proObservaciones;
    }

    public String getProStatus() {
        return proStatus;
    }

    public void setProStatus(String proStatus) {
        this.proStatus = proStatus;
    }

    @XmlTransient
    public Collection<Ventas> getVentasCollection() {
        return ventasCollection;
    }

    public void setVentasCollection(Collection<Ventas> ventasCollection) {
        this.ventasCollection = ventasCollection;
    }

    @XmlTransient
    public Collection<Inventario> getInventarioCollection() {
        return inventarioCollection;
    }

    public void setInventarioCollection(Collection<Inventario> inventarioCollection) {
        this.inventarioCollection = inventarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductos != null ? idProductos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.idProductos == null && other.idProductos != null) || (this.idProductos != null && !this.idProductos.equals(other.idProductos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Productos[ idProductos=" + idProductos + " ]";
    }
    
}
