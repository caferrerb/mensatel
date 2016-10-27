/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.util;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MAO
 */
public class Plan {

    public String idplan;
    public String nombre;
    public String numeromails;
    public String numeromsjs;
    public String numeropush;
    public String numerosms;
    public String valorplan;

    public String getIdplan() {
        return idplan;
    }

    public void setIdplan(String idplan) {
        this.idplan = idplan;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeromails() {
        return numeromails;
    }

    public void setNumeromails(String numeromails) {
        this.numeromails = numeromails;
    }

    public String getNumeromsjs() {
        return numeromsjs;
    }

    public void setNumeromsjs(String numeromsjs) {
        this.numeromsjs = numeromsjs;
    }

    public String getNumeropush() {
        return numeropush;
    }

    public void setNumeropush(String numeropush) {
        this.numeropush = numeropush;
    }

    public String getNumerosms() {
        return numerosms;
    }

    public void setNumerosms(String numerosms) {
        this.numerosms = numerosms;
    }

    public String getValorplan() {
        return valorplan;
    }

    public void setValorplan(String valorplan) {
        this.valorplan = valorplan;
    }

    public List<Plan> planes() {

        try {
            Gson json = new Gson();
            String path = "planes/listar";
            String respuesta = HTTPUtil.doGetListar(path);

            Plan[] planesitos = new Plan[1000];
            planesitos = json.fromJson(respuesta, planesitos.getClass());

            planesitos = json.fromJson(respuesta, planesitos.getClass());
            List<Plan> planes = Arrays.asList(planesitos);

            return planes;
        } catch (Exception ex) {
            Logger.getLogger(Plan.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
