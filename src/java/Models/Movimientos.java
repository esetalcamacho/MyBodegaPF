/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stive
 */
@Entity
@Table(name = "movimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimientos.findAll", query = "SELECT m FROM Movimientos m")
    , @NamedQuery(name = "Movimientos.findByIdMovimientos", query = "SELECT m FROM Movimientos m WHERE m.idMovimientos = :idMovimientos")
    , @NamedQuery(name = "Movimientos.findByMovFechaSalida", query = "SELECT m FROM Movimientos m WHERE m.movFechaSalida = :movFechaSalida")
    , @NamedQuery(name = "Movimientos.findByMovFechaIngreso", query = "SELECT m FROM Movimientos m WHERE m.movFechaIngreso = :movFechaIngreso")
    , @NamedQuery(name = "Movimientos.findByMovCantidadSalida", query = "SELECT m FROM Movimientos m WHERE m.movCantidadSalida = :movCantidadSalida")
    , @NamedQuery(name = "Movimientos.findByMovCantidadIngreso", query = "SELECT m FROM Movimientos m WHERE m.movCantidadIngreso = :movCantidadIngreso")
    , @NamedQuery(name = "Movimientos.findByMovHora", query = "SELECT m FROM Movimientos m WHERE m.movHora = :movHora")})
public class Movimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMovimientos")
    private Integer idMovimientos;
    @Column(name = "MovFechaSalida")
    @Temporal(TemporalType.DATE)
    private Date movFechaSalida;
    @Column(name = "MovFechaIngreso")
    @Temporal(TemporalType.DATE)
    private Date movFechaIngreso;
    @Column(name = "MovCantidadSalida")
    private Integer movCantidadSalida;
    @Column(name = "MovCantidadIngreso")
    private Integer movCantidadIngreso;
    @Column(name = "MovHora")
    @Temporal(TemporalType.TIME)
    private Date movHora;
    @OneToMany(mappedBy = "fkMovimientos")
    private Collection<Inventario> inventarioCollection;

    public Movimientos() {
    }

    public Movimientos(Integer idMovimientos) {
        this.idMovimientos = idMovimientos;
    }

    public Integer getIdMovimientos() {
        return idMovimientos;
    }

    public void setIdMovimientos(Integer idMovimientos) {
        this.idMovimientos = idMovimientos;
    }

    public Date getMovFechaSalida() {
        return movFechaSalida;
    }

    public void setMovFechaSalida(Date movFechaSalida) {
        this.movFechaSalida = movFechaSalida;
    }

    public Date getMovFechaIngreso() {
        return movFechaIngreso;
    }

    public void setMovFechaIngreso(Date movFechaIngreso) {
        this.movFechaIngreso = movFechaIngreso;
    }

    public Integer getMovCantidadSalida() {
        return movCantidadSalida;
    }

    public void setMovCantidadSalida(Integer movCantidadSalida) {
        this.movCantidadSalida = movCantidadSalida;
    }

    public Integer getMovCantidadIngreso() {
        return movCantidadIngreso;
    }

    public void setMovCantidadIngreso(Integer movCantidadIngreso) {
        this.movCantidadIngreso = movCantidadIngreso;
    }

    public Date getMovHora() {
        return movHora;
    }

    public void setMovHora(Date movHora) {
        this.movHora = movHora;
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
        hash += (idMovimientos != null ? idMovimientos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimientos)) {
            return false;
        }
        Movimientos other = (Movimientos) object;
        if ((this.idMovimientos == null && other.idMovimientos != null) || (this.idMovimientos != null && !this.idMovimientos.equals(other.idMovimientos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Movimientos[ idMovimientos=" + idMovimientos + " ]";
    }
    
}
