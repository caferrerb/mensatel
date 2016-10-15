/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.eam.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "mensaje")
@SequenceGenerator(name = "msjsecuencia", sequenceName = "msjsecuencia", initialValue = 1, allocationSize = 1)
@XmlRootElement
public class Mensaje implements Serializable {

    //Atributos
    @Id
    @Column(name = "idmensaje")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "msjsecuencia")
    private int id;
    @Column(name = "operadororigen")
    @Basic(optional = false)
    private String operadororigen;
    @Column(name = "operadordestino")
    @Basic(optional = false)
    private String operadordestino;
    @Column(name = "abonadoorigen")
    @Basic(optional = false)
    private String abonadoorigen;
    @Column(name = "abonadodestino")
    @Basic(optional = false)
    private String abonadodestino;
    @Column(name = "mensaje")
    @Basic(optional = false)
    private String mensaje;

    //Metodo constructor
    public Mensaje() {
        super();
    }

//    public Mensaje(String operadororigen, String operadordestino, String abonadoorigen, String abonadodestino, String mensaje) {
//        this.operadororigen = operadororigen;
//        this.operadordestino = operadordestino;
//        this.abonadoorigen = abonadoorigen;
//        this.abonadodestino = abonadodestino;
//        this.mensaje = mensaje;
//    }

    //Metodos Accesores y Modificadores
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperadororigen() {
        return operadororigen;
    }

    public void setOperadororigen(String operadororigen) {
        this.operadororigen = operadororigen;
    }

    public String getOperadordestino() {
        return operadordestino;
    }

    public void setOperadordestino(String operadordestino) {
        this.operadordestino = operadordestino;
    }

    public String getAbonadoorigen() {
        return abonadoorigen;
    }

    public void setAbonadoorigen(String abonadoorigen) {
        this.abonadoorigen = abonadoorigen;
    }

    public String getAbonadodestino() {
        return abonadodestino;
    }

    public void setAbonadodestino(String abonadodestino) {
        this.abonadodestino = abonadodestino;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
