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

/**
 *
 * @author 415pc13
 */
@ManagedBean
@ViewScoped
public class QuitarServicioBean implements Serializable {

    String NumeroAbonado;
    String CodigoPlan;

    public String getNumeroAbonado() {
        return NumeroAbonado;
    }

    public void setNumeroAbonado(String NumeroAbonado) {
        this.NumeroAbonado = NumeroAbonado;
    }

    public String getCodigoPlan() {
        return CodigoPlan;
    }

    public void setCodigoPlan(String CodigoPlan) {
        this.CodigoPlan = CodigoPlan;
    }

    public void quitar() {

        try {

            String path = "procedimientos/quitarservicio";
            String json = "{\"Quitarservicio\": {\"numeroabonado\": \"" + NumeroAbonado + "\",\"codigoservicio\": \"" + CodigoPlan + "\"}}";

            String resp = HTTPUtil.doPostEnviar(path, json);
            System.out.println(resp);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", resp));

            
            limpiar ();
        } catch (Exception ex) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Informacion", "Ha ocurrido un error inesperado"));

            Logger.getLogger(QuitarServicioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void limpiar() {
        
        setCodigoPlan("");
        setNumeroAbonado("");
    }

}
