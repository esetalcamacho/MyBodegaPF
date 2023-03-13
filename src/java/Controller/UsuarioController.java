package Controller;

import Models.Usuario;
import Controller.util.JsfUtil;
import Controller.util.JsfUtil.PersistAction;
import Models.UsuarioFacade;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    @EJB
    private Models.UsuarioFacade ejbFacade;
    private List<Usuario> items = null;
    private Usuario selected;
    private String usuEmail;
    private String usuContraseña;

    public UsuarioController() {
    }
    
    // Metodo Inicio Sesion
    
    public String iniciarSesion() {
        //System.out.println("Usuario:"+this.usuEmail+ " Clave:"+usuContraseña);
        String redireccionar = null;        
        //Usuario Facade Conexion
        List<Usuario> usuarioLogin = getFacade().validarUsuario(usuEmail, encriptarMD5(usuContraseña));
        if (usuarioLogin.isEmpty()){
            JsfUtil.addErrorMessage("Usuario o clave incorrecta");
        }
        else {
            //El usuario existe en la BD
            JsfUtil.addSuccessMessage("Usuario o clave correcta");
            //Guardar el usuario loggeado
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogueado", usuarioLogin);
            redireccionar = "Views/Principal?faces-redirect=true";
        }
        
        return redireccionar;
    }
    
    // Cierre de sesion
    
    public void cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession(); 
    }
    
    
    // Usuario Loggeado
    
    public String mostrarLogueado(){
        List<Usuario> datosLogueado = (List<Usuario>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogueado");
        //String nombreUsuario = datosLogueado.get(0).getUsuNombre();
        //String apellidoUsuario = datosLogueado.get(0).getUsuApellido();
        return datosLogueado.get(0).getUsuNombre()+" "+datosLogueado.get(0).getUsuApellido(); 
    }
    
    // Registrar Uusuario
    
    public void registrar(){
        // Capturar los datos del formulario
        // Aqui se encripta la contraseña
        String usuContraseña = selected.getUsuContraseña();
        String claveEncriptada = encriptarMD5(usuContraseña);
        selected.setUsuContraseña(claveEncriptada);
        
        ejbFacade.create(selected); // Se envia la informacion a la base de datos
        JsfUtil.addSuccessMessage("El registro ha sido exitosos");
        selected = null;
    }
    
    // Encriptar contraseña
    
    public static String encriptarMD5(String input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
 
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
 
    
    
    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    public String getUsuContraseña() {
        return usuContraseña;
    }

    public void setUsuContraseña(String usuContraseña) {
        this.usuContraseña = usuContraseña;
    }
   

    public Usuario getSelected() {
        return selected;
    }

    public void setSelected(Usuario selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private UsuarioFacade getFacade() {
        return ejbFacade;
    }

    public Usuario prepareCreate() {
        selected = new Usuario();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/config/Bundle").getString("UsuarioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/config/Bundle").getString("UsuarioUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/config/Bundle").getString("UsuarioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Usuario> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/config/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/config/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Usuario getUsuario(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<Usuario> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Usuario> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Usuario.class)
    public static class UsuarioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsuarioController controller = (UsuarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuarioController");
            return controller.getUsuario(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Usuario) {
                Usuario o = (Usuario) object;
                return getStringKey(o.getUsuIdentificacion());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Usuario.class.getName()});
                return null;
            }
        }

    }

}
