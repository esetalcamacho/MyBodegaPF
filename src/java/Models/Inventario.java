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
 * @author stive
 */
@Entity
@Table(name = "inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i")
    , @NamedQuery(name = "Inventario.findByIdBodega", query = "SELECT i FROM Inventario i WHERE i.idBodega = :idBodega")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBodega")
    private Integer idBodega;
    @OneToMany(mappedBy = "fkBodega")
    private Collection<Ventas> ventasCollection;
    @JoinColumn(name = "fk_RegUserID", referencedColumnName = "RegUserID")
    @ManyToOne
    private Registro fkRegUserID;
    @JoinColumn(name = "fk_Producto", referencedColumnName = "idProductos")
    @ManyToOne
    private Productos fkProducto;
    @JoinColumn(name = "fk_Movimientos", referencedColumnName = "idMovimientos")
    @ManyToOne
    private Movimientos fkMovimientos;

    public Inventario() {
    }

    public Inventario(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public Integer getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    @XmlTransient
    public Collection<Ventas> getVentasCollection() {
        return ventasCollection;
    }

    public void setVentasCollection(Collection<Ventas> ventasCollection) {
        this.ventasCollection = ventasCollection;
    }

    public Registro getFkRegUserID() {
        return fkRegUserID;
    }

    public void setFkRegUserID(Registro fkRegUserID) {
        this.fkRegUserID = fkRegUserID;
    }

    public Productos getFkProducto() {
        return fkProducto;
    }

    public void setFkProducto(Productos fkProducto) {
        this.fkProducto = fkProducto;
    }

    public Movimientos getFkMovimientos() {
        return fkMovimientos;
    }

    public void setFkMovimientos(Movimientos fkMovimientos) {
        this.fkMovimientos = fkMovimientos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBodega != null ? idBodega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.idBodega == null && other.idBodega != null) || (this.idBodega != null && !this.idBodega.equals(other.idBodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Inventario[ idBodega=" + idBodega + " ]";
    }
    
}
