/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByUsuIdentificacion", query = "SELECT u FROM Usuario u WHERE u.usuIdentificacion = :usuIdentificacion")
    , @NamedQuery(name = "Usuario.findByUsuContrase\u00f1a", query = "SELECT u FROM Usuario u WHERE u.usuContrase\u00f1a = :usuContrase\u00f1a")
    , @NamedQuery(name = "Usuario.findByUsuNombre", query = "SELECT u FROM Usuario u WHERE u.usuNombre = :usuNombre")
    , @NamedQuery(name = "Usuario.findByUsuApellido", query = "SELECT u FROM Usuario u WHERE u.usuApellido = :usuApellido")
    , @NamedQuery(name = "Usuario.findByUsuEmail", query = "SELECT u FROM Usuario u WHERE u.usuEmail = :usuEmail")
    , @NamedQuery(name = "Usuario.findValidarUsuario", query = "SELECT u FROM Usuario u WHERE u.usuEmail = :usuEmail and u.usuContrase\u00f1a = :usuContrase\u00f1a")})
    
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "UsuIdentificacion")
    private String usuIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "UsuContrase\u00f1a")
    private String usuContraseña;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "UsuNombre")
    private String usuNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "UsuApellido")
    private String usuApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "UsuEmail")
    private String usuEmail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdentificacion")
    private Collection<Registro> registroCollection;

    public Usuario() {
    }

    public Usuario(String usuIdentificacion) {
        this.usuIdentificacion = usuIdentificacion;
    }

    public Usuario(String usuIdentificacion, String usuContraseña, String usuNombre, String usuApellido, String usuEmail) {
        this.usuIdentificacion = usuIdentificacion;
        this.usuContraseña = usuContraseña;
        this.usuNombre = usuNombre;
        this.usuApellido = usuApellido;
        this.usuEmail = usuEmail;
    }

    public String getUsuIdentificacion() {
        return usuIdentificacion;
    }

    public void setUsuIdentificacion(String usuIdentificacion) {
        this.usuIdentificacion = usuIdentificacion;
    }

    public String getUsuContraseña() {
        return usuContraseña;
    }

    public void setUsuContraseña(String usuContraseña) {
        this.usuContraseña = usuContraseña;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuApellido() {
        return usuApellido;
    }

    public void setUsuApellido(String usuApellido) {
        this.usuApellido = usuApellido;
    }

    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    @XmlTransient
    public Collection<Registro> getRegistroCollection() {
        return registroCollection;
    }

    public void setRegistroCollection(Collection<Registro> registroCollection) {
        this.registroCollection = registroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuIdentificacion != null ? usuIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuIdentificacion == null && other.usuIdentificacion != null) || (this.usuIdentificacion != null && !this.usuIdentificacion.equals(other.usuIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Usuario[ usuIdentificacion=" + usuIdentificacion + " ]";
    }
    
}
