/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stive
 */
@Entity
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v")
    , @NamedQuery(name = "Ventas.findByIdVentas", query = "SELECT v FROM Ventas v WHERE v.idVentas = :idVentas")
    , @NamedQuery(name = "Ventas.findByVenPrecioTotal", query = "SELECT v FROM Ventas v WHERE v.venPrecioTotal = :venPrecioTotal")
    , @NamedQuery(name = "Ventas.findByVenFecha", query = "SELECT v FROM Ventas v WHERE v.venFecha = :venFecha")
    , @NamedQuery(name = "Ventas.findByVenStatus", query = "SELECT v FROM Ventas v WHERE v.venStatus = :venStatus")
    , @NamedQuery(name = "Ventas.findByVenObservaciones", query = "SELECT v FROM Ventas v WHERE v.venObservaciones = :venObservaciones")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVentas")
    private Integer idVentas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VenPrecioTotal")
    private Double venPrecioTotal;
    @Column(name = "VenFecha")
    @Temporal(TemporalType.DATE)
    private Date venFecha;
    @Size(max = 20)
    @Column(name = "VenStatus")
    private String venStatus;
    @Size(max = 500)
    @Column(name = "VenObservaciones")
    private String venObservaciones;
    @JoinColumn(name = "fkClientes", referencedColumnName = "idClientes")
    @ManyToOne
    private Clientes fkClientes;
    @JoinColumn(name = "fkBodega", referencedColumnName = "idBodega")
    @ManyToOne
    private Inventario fkBodega;
    @JoinColumn(name = "VenProducto", referencedColumnName = "idProductos")
    @ManyToOne(optional = false)
    private Productos venProducto;

    public Ventas() {
    }

    public Ventas(Integer idVentas) {
        this.idVentas = idVentas;
    }

    public Integer getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(Integer idVentas) {
        this.idVentas = idVentas;
    }

    public Double getVenPrecioTotal() {
        return venPrecioTotal;
    }

    public void setVenPrecioTotal(Double venPrecioTotal) {
        this.venPrecioTotal = venPrecioTotal;
    }

    public Date getVenFecha() {
        return venFecha;
    }

    public void setVenFecha(Date venFecha) {
        this.venFecha = venFecha;
    }

    public String getVenStatus() {
        return venStatus;
    }

    public void setVenStatus(String venStatus) {
        this.venStatus = venStatus;
    }

    public String getVenObservaciones() {
        return venObservaciones;
    }

    public void setVenObservaciones(String venObservaciones) {
        this.venObservaciones = venObservaciones;
    }

    public Clientes getFkClientes() {
        return fkClientes;
    }

    public void setFkClientes(Clientes fkClientes) {
        this.fkClientes = fkClientes;
    }

    public Inventario getFkBodega() {
        return fkBodega;
    }

    public void setFkBodega(Inventario fkBodega) {
        this.fkBodega = fkBodega;
    }

    public Productos getVenProducto() {
        return venProducto;
    }

    public void setVenProducto(Productos venProducto) {
        this.venProducto = venProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVentas != null ? idVentas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.idVentas == null && other.idVentas != null) || (this.idVentas != null && !this.idVentas.equals(other.idVentas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Ventas[ idVentas=" + idVentas + " ]";
    }
    
}
