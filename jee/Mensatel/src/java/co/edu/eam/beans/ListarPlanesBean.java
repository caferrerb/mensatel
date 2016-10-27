/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.beans;

import co.edu.eam.util.HTTPUtil;
import co.edu.eam.util.Plan;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
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

public class ListarPlanesBean implements Serializable {

    public String idplan;
    
    

    public String getIdplan() {
        return idplan;
    }

    public void setIdplan(String idplan) {
        this.idplan = idplan;
    }
     Plan p = new Plan();
    public List<Plan> planes ;
   
    
    
    
       @PostConstruct
    public void postConstruct() {
        // Postcontruct que me carga el listado de los colores marcas y categorias el abrir la aplicacino
        planes = p.planes();
       
    }

    private void limpiar() {
        setIdplan("");

    }

    public List<Plan> getPlanes() {
      
        return planes;
    }

    public void setPlanes(List<Plan> planes) {
        this.planes = planes;
    }

    public Plan getP() {
        return p;
    }

    public void setP(Plan p) {
        this.p = p;
    }
    

}
