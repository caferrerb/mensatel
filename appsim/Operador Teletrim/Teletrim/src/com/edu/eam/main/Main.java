/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.eam.main;

import com.edu.eam.bo.MensajeBO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.ws.Endpoint;

/**
 *
 * @author USUARIO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TeletrimPU");
        EntityManager em = emf.createEntityManager();
        MensajeBO bo;
        try {
            bo = new MensajeBO();
            Endpoint.publish("http://174.142.65.144:47210/Teletrim/teletrimWS", bo);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
//        Date fecha = new Date();
//                //Obtenemos la fecha y la hora con el formato yyyy - MM - dd HH:mm:ss
//                DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd'/'HH:mm:ss");
//                String g = fechaHora.format(fecha);
//                System.out.println("-"+g);
    }
}
