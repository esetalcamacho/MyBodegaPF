 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author stive
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "MyBodegaPFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    // Validar Usuario
    
    public List<Usuario> validarUsuario(String usuEmail, String usuContraseña){
        String consultaSql ="SELECT * FROM Usuario where usuEmail='"+usuEmail+"' and usuContraseña='"+usuContraseña+"' ";
        
        List<Usuario> usuarioLogin = null;
        
        try {
            usuarioLogin = getEntityManager().createNativeQuery(consultaSql, Usuario.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error, no se pudo realizar la consulta"+e.getMessage());
        }
        //List<Usuario> usuarioLogin = getEntityManager().createNamedQuery("nombreConsultat", Usuario.class).setParameter
        //("nomParametro",usuEmail).setParameter("nomPrametro", usuContraseña).getResultList();
        
        return usuarioLogin;
    }
    
}
