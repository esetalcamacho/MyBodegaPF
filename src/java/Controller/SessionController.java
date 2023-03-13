/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("sessionController")
@ViewScoped

public class SessionController implements Serializable{

    
    public void validarSesion(){
            Object usuarioLog = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogueado");
            try { 
                if(usuarioLog == null){
                FacesContext.getCurrentInstance().getExternalContext().redirect("/MyBodegaPF/faces/permisoDenegado.xhtml");
                }
            } catch (IOException ex) {
                //Logger.getLogger(SessionController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error, no existe la sesion:"+ex.getMessage());
            }
    }
}
