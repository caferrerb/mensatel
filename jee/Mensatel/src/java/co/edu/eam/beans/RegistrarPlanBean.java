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
 * @author GERMAN
 */
@ManagedBean
@ViewScoped
public class RegistrarPlanBean implements Serializable {

    public String idplan;
    public String nombrePlan;
    public String numEmails;
    public String numMensajes;
    public String numPush;
    public String numSms;
    public String valorPlan;

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public String getNumEmails() {
        return numEmails;
    }

    public void setNumEmails(String numEmails) {
        this.numEmails = numEmails;
    }

    public String getNumMensajes() {
        return numMensajes;
    }

    public void setNumMensajes(String numMensajes) {
        this.numMensajes = numMensajes;
    }

    public String getNumPush() {
        return numPush;
    }

    public void setNumPush(String numPush) {
        this.numPush = numPush;
    }

    public String getNumSms() {
        return numSms;
    }

    public void setNumSms(String numSms) {
        this.numSms = numSms;
    }

    public String getValorPlan() {
        return valorPlan;
    }

    public void setValorPlan(String valorPlan) {
        this.valorPlan = valorPlan;
    }

    public String getIdplan() {
        return idplan;
    }

    public void setIdplan(String idplan) {
        this.idplan = idplan;
    }
    
    public void guardar(){
    }
    
    public void editar(){}
    public void buscar(){}
    
    private void limpiar(){
        
        setNombrePlan("");
        setNumEmails("");
        setNumMensajes("");
        setNumPush("");
        setNumSms("");
        setValorPlan("");
    }
}
