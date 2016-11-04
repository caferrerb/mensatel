/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.beans;

import co.edu.eam.util.HTTPUtil;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author GERMAN
 */
@ManagedBean
@Named(value = "AbonadosBean")
@ViewScoped
public class RegistrarAbonadosBean implements Serializable {
    
    public String numero;
    public String documento;
    public String tipodoc;
    
    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public String getDocumento() {
        return documento;
    }
    
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    public String getTipodoc() {
        return tipodoc;
    }
    
    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }
    
    public void enviar() {
        
        try {
            System.out.println(documento);
            System.out.println(numero);
            System.out.println(tipodoc);
            
            String path = "procedimientos/registrarabonado";

            //String json="{'Registroabonado':{'numero':'"+numero+"','doc':'"+documento+"', 'tipodoc':'"+tipodoc+"'}}";
            //String json="{"+"Registroabonado"+ ":" +"{"+"numero"+numero+",";
            String json;
            json = "{\"Registroabonado\":{ \"numero\":\"" + numero + "\",\"doc\": \"" + documento + "\", \"tipodoc\":\"" + tipodoc + "\" }}";
            String resp = HTTPUtil.doPostEnviar(path, json);
            System.out.println(resp);
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", resp));
                limpiar();
        } catch (Exception ex) {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Informacion", "Ha ocurrido un error inesperado, por favor verifique que los datos sean correctos"));
            Logger.getLogger(RegistrarAbonadosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void limpiar() {
        setDocumento("");
        setTipodoc("");
        setNumero("");
    }
    
}
