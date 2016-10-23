/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.eam.beans;

import co.edu.eam.util.HTTPUtil;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author MAO
 */
@ManagedBean
@ViewScoped
public class UsuariosBean  implements Serializable{
    
    public String nombre;
    public String apellido;
    public String ciudad;
    public String correo;
    public String doc;
    public String tipodoc;
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getCiudad() {
        return ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getDoc() {
        return doc;
    }
    
    public void setDoc(String doc) {
        this.doc = doc;
    }
    
    public String getTipodoc() {
        return tipodoc;
    }
    
    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }
    
    public void enviarUsuario() {
        
        try {
          
            
            String path = "procedimientos/registrarusuario";    
            String json;
            json = "{\"Registrousuario\":{ \"nombre\":\""+nombre+"\", \"apellido\":\""+apellido+"\", \"ciudad\":\""+ciudad+"\", \"correo\":\""+correo+"\", \"doc\": \""+doc+"\", \"tipodoc\":\""+tipodoc+"\" }}";
            String resp = HTTPUtil.doPostEnviar(path, json);
                 
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", resp));
                limpiar();
       
        } catch (Exception ex) {
            Logger.getLogger(AbonadosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void limpiar() {
        setDoc("");
        setTipodoc("");
        setNombre("");
        setCiudad("");
        setApellido("");
        setCorreo("");
    }
    
}
