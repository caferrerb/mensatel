/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.eam.beans;
import co.edu.eam.util.HTTPUtil;
import co.edu.eam.util.Plan;
import com.google.gson.Gson;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

/**
 *
 * @author MAO
 */
@ManagedBean
@ViewScoped
public class GestionarPlanes implements  Serializable{
    
    
      public String idplan;
    public String nombrePlan;
    public String numEmails;
    public String numMensajes;
    public String numPush;
    public String numSms;
    public String valorPlan;

    
        Plan p = new Plan();
    public List<Plan> planes ;
   
    
    
    
       @PostConstruct
    public void postConstruct() {
        planes = p.planes();
       
    }

    public List<Plan> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plan> planes) {
        this.planes = planes;
    }
    
    
    
    public String getIdplan() {
        return idplan;
    }

    public void setIdplan(String idplan) {
        this.idplan = idplan;
    }

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

    
    public void guardar(){
        
          try {
              String path = "planes/crear";
             // String json="{\"idplan\":\""+getIdplan()+"\",\"nombre\":\""+nombrePlan+"\",\"numeromails\":\""+numEmails+"\",\"numeromsjs\":\""+numMensajes+"\",\"numeropush\":\""+numPush+"\",\"numerosms\":\""+numSms+"\",\"valorplan\":\""+valorPlan+"\"} ";
              String json="{\"idplan\":"+idplan+",\"nombre\":\""+nombrePlan+"\",\"numeromails\": "+numEmails+" ,\"numeromsjs\":"+numMensajes+",\"numeropush\":"+numPush+",\"numerosms\":"+numSms+",\"valorplan\":"+valorPlan+"}";
              System.out.println(json);
              String resp = HTTPUtil.doPostEnviar(path, json);
               System.out.println(json);
              System.out.println(resp);
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", resp));

             limpiar();
            
          } catch (Exception ex) {
              Logger.getLogger(GestionarPlanes.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }
    
    public void editar(){
    
          try {
              String path = "planes/editar";
              String json="{\"idplan\":"+idplan+",\"nombre\":\""+nombrePlan+"\",\"numeromails\": "+numEmails+" ,\"numeromsjs\":"+numMensajes+",\"numeropush\":"+numPush+",\"numerosms\":"+numSms+",\"valorplan\":"+valorPlan+"}";
              System.out.println(json);
              String resp = HTTPUtil.doPostEnviar(path, json);
               System.out.println(json);
            //  System.out.println(resp);
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", resp));

             limpiar();
            
          } catch (Exception ex) {
              Logger.getLogger(GestionarPlanes.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }
    public void buscar(){
    
          try {
              String path = "planes/buscar";
              String json="{\"idplan\":"+idplan+"}";
              System.out.println(json);
              String resp = HTTPUtil.doPostEnviar(path, json);
              System.out.println(json);
              System.out.println(resp);
              
              Gson gson = new Gson();
              Plan plan = gson.fromJson(resp, Plan.class);
              
              setNombrePlan(plan.nombre);
              setNumEmails(plan.numeromails);
              setNumMensajes(plan.numeromsjs);
              setNumSms(plan.numerosms);
              setNumPush(plan.numeropush);
              setValorPlan(plan.valorplan);
             
                   
              
              
          } catch (Exception ex) {
              Logger.getLogger(GestionarPlanes.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        
        
        
        
    }
    
    private void limpiar(){
        
        setIdplan("");
        setNombrePlan("");
        setNumEmails("");
        setNumMensajes("");
        setNumPush("");
        setNumSms("");
        setValorPlan("");
    }
    
}
