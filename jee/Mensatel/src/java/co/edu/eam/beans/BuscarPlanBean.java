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

public class BuscarPlanBean implements Serializable {

    public String idplan;

    public String getIdplan() {
        return idplan;
    }

    public void setIdplan(String idplan) {
        this.idplan = idplan;
    }

    private void limpiar() {
        setIdplan("");

    }

}
