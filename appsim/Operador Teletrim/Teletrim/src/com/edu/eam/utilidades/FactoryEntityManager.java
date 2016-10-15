/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.eam.utilidades;

import javax.persistence.Persistence;

/**
 *
 * @author USUARIO
 */
public class FactoryEntityManager {

    //Creacion entity
    private static javax.persistence.EntityManager em;

    public FactoryEntityManager() {
        em = Persistence.createEntityManagerFactory("TeletrimPU")
                .createEntityManager();

    }

    //Metodo Accesor 

    public static javax.persistence.EntityManager getEm() {
        if (FactoryEntityManager.em == null) {
            new FactoryEntityManager();
        }
        return FactoryEntityManager.em;
    }

}
