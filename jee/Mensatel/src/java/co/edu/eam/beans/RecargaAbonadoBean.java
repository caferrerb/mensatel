/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.eam.beans;

import co.edu.eam.util.HTTPUtil;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

/**
 *
 * @author MAO
 */
@ManagedBean
@ViewScoped
public class RecargaAbonadoBean implements Serializable{
        public String numero;
    public String plan;
    public String monto;
    public String numTarjeta;
    public String CodigoSeguridad;
     public String año;
    public String mes;
    public String Fecha;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getCodigoSeguridad() {
        return CodigoSeguridad;
    }

    public void setCodigoSeguridad(String CodigoSeguridad) {
        this.CodigoSeguridad = CodigoSeguridad;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }      
 

  
    public void enviardatos(){
            try {
                String path = "procedimientos/recargarabonado";
                
                Fecha=año+"/"+mes;
                String json;
                json ="{\"Recargarabonado\":{ \"numero\":\""+numero+"\",\"plan\":\""+plan+"\",\"monto\":\""+monto+"\",\"numTarjeta\":\""+numTarjeta+"\",\"codigoseguridad\":\""+CodigoSeguridad+"\",\"fechaex\":\""+Fecha+"\"}}";
                
                String resp = HTTPUtil.doPostEnviar(path, json);
                System.out.println(resp);
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", resp));
               
                if (resp.equals(" {\"codigo\":\"COD-0000\",\"mensaje\":\"operacion exitosa\"}")) {
                    limpiar();
                }

            } catch (Exception ex) {
                Logger.getLogger(RecargaAbonadoBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
       
    }

    private void limpiar() {
        setAño("");
        setMonto("");
        setPlan("");
        setNumTarjeta("");
        setNumero("");
        setMes("");
        setFecha("");
        setCodigoSeguridad("");
    }
    
}
