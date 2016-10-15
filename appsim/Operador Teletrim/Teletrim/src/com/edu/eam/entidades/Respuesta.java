/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.eam.entidades;

/**
 *
 * @author USUARIO
 */
public class Respuesta {

    //Atributos
    private String codigo;
    private String mensaje;

    //Metodo contructor
    public Respuesta() {
        super();
    }

    public Respuesta(String codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    //Metodos Accesores y Modificadores
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
