/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.eam.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "mensajeteletrim")
@SequenceGenerator(name = "mensajesecuencia", sequenceName = "mensajesecuencia", initialValue = 1, allocationSize = 1)
public class MensajeTeletrim implements Serializable {

    //Atributos
    @Id
    @Column(name = "idmensaje")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "mensajesecuencia")
    private int id;
    @Column(name = "numeroabonado")
    @Basic(optional = false)
    private String numeroAbonado;
    @Column(name = "fecha")
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToOne(cascade = CascadeType.ALL)
    private Mensaje mensaje;

    //Metodo constructor
    public MensajeTeletrim() {
        super();
    }

//    public MensajeTeletrim(String numeroAbonado, Date fecha, Mensaje mensaje) {
//        this.numeroAbonado = numeroAbonado;
//        this.fecha = fecha;
//        this.mensaje = mensaje;
//    }

    //Metodos Accesores y Modificadores
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroAbonado() {
        return numeroAbonado;
    }

    public void setNumeroAbonado(String numeroAbonado) {
        this.numeroAbonado = numeroAbonado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

}
