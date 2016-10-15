/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.eam.bo;

import com.csvreader.CsvWriter;
import com.edu.eam.entidades.Mensaje;
import com.edu.eam.entidades.MensajeTeletrim;
import com.edu.eam.entidades.Respuesta;
import com.edu.eam.utilidades.FactoryEntityManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author USUARIO
 */
@WebService(name = "teletrimWS")
public class MensajeBO {

    //Unidad de persistencia
    private EntityManager em;
    private Respuesta resp;
    private Properties p;

    //Metodo constructor
    public MensajeBO() throws IOException {
        em = FactoryEntityManager.getEm();
        //Cargamos el archivo
        p = new Properties();
        p.load(new FileInputStream("propiedades.properties"));
    }

    /**
     * Metodo encargado de almacenar un mensaje enviado al operador Teletrim
     *
     * @param numeroAbonado, numero del abonado a enviar
     * @param mensaje, mensaje al abonado a enviar
     * @return mensaje de respuesta
     */
    @WebMethod(operationName = "enviarmsjabonado", action = "enviarmsjabonado")
    public Respuesta enviarmsjabonado(@WebParam(name = "numeroAbonado") String numeroAbonado,
            @WebParam(name = "mensaje") Mensaje mensaje) {
        try {
            if (mensaje.getOperadordestino().isEmpty()
                    || mensaje.getAbonadoorigen().isEmpty()
                    || mensaje.getOperadororigen().isEmpty()
                    || mensaje.getAbonadodestino().isEmpty()
                    || mensaje.getMensaje().isEmpty()
                    || numeroAbonado.isEmpty()) {
                resp = new Respuesta();
                resp.setCodigo("200");
                resp.setMensaje("Error en la transaccion");
                return resp;
            } else {
                Date fecha = new Date();
                //Obtenemos la fecha y la hora con el formato yyyy - MM - dd HH:mm:ss
                DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd'/'HH:mm:ss");
                DateFormat fechaN = new SimpleDateFormat("yyyy-MM-dd");
                String formatoFecha = fechaHora.format(fecha);
                String nombre = fechaN.format(fecha) + "Teletrim.csv";
                MensajeTeletrim msj = new MensajeTeletrim();
                msj.setNumeroAbonado(numeroAbonado);
                msj.setMensaje(mensaje);
                msj.setFecha(fecha);
                em.getTransaction().begin();
                em.persist(msj);
                em.getTransaction().commit();
                if (escribirArchivo(formatoFecha, mensaje, nombre)) {
                    if (cargarFTP(nombre)) {
                    //Mensaje
                    resp = new Respuesta();
                    resp.setCodigo("201");
                    resp.setMensaje("Transaccion Exitosa");
                    return resp;
                } else {
                    resp = new Respuesta();
                    resp.setCodigo("200");
                    resp.setMensaje("Error en la transaccion");
                    return resp;
                }
                } else {
                    resp = new Respuesta();
                    resp.setCodigo("200");
                    resp.setMensaje("Error en la transaccion");
                    return resp;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp = new Respuesta();
            resp.setCodigo("200");
            resp.setMensaje("Error en la transaccion");
            return resp;
        }
    }

    /**
     * Metodo encargado de escribir un archivo cvs
     *
     * @param fecha, fecha del mensaje
     * @param mensaje, mensaje a escribir
     * @return true si fue exitoso
     */
    @WebMethod(exclude = true)
    public boolean escribirArchivo(String fecha, Mensaje mensaje, String nombre) {
//        try {
//            //Verificamos si ya existe un archivo con este nombre
//            boolean existe = new File(p.getProperty("rut") + nombre).exists();
//            if (existe) {
//                CsvWriter escritor = new CsvWriter(new FileWriter(p.getProperty("rut") + nombre, true), ',');
//                //Añadimos las lineas
//                escritor.write(fecha);
//                escritor.write(mensaje.getOperadororigen());
//                escritor.write(mensaje.getOperadordestino());
//                escritor.write(mensaje.getAbonadoorigen());
//                escritor.write(mensaje.getAbonadodestino());
//                escritor.endRecord();
//                //Cerramos el escritor
//                escritor.close();
//                return true;
//            } else {
//                //De lo contrario escribimos el archivo
//                CsvWriter escritor = new CsvWriter(new FileWriter(p.getProperty("rut") + nombre, true), ',');
//                escritor.write("Fecha/Hora");
//                escritor.write("OperadorOrigen");
//                escritor.write("OperadorDestino");
//                escritor.write("AbonadoOrigen");
//                escritor.write("AbonadoDestino");
//                escritor.endRecord();
//                //Añadimos las lineas
//                escritor.write(fecha);
//                escritor.write(mensaje.getOperadororigen());
//                escritor.write(mensaje.getOperadordestino());
//                escritor.write(mensaje.getAbonadoorigen());
//                escritor.write(mensaje.getAbonadodestino());
//                escritor.endRecord();
//                //Cerramos el escritor
//                escritor.close();
//                return true;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
        return true;
    }

    @WebMethod(exclude = true)
    public boolean cargarFTP(String nombre) {
//        //nombre del archivo
//        String nombre = fecha + "-Mensaje.csv";
        //Cliente FTP
//        FTPClient ftpClient = new FTPClient();
//        try {
//            //Accedemos a la conexion
//            ftpClient.connect(p.getProperty("server"), Integer.parseInt(p.getProperty("puerto")));
//            boolean log = ftpClient.login(p.getProperty("user"), p.getProperty("password"));
//            System.out.println("Login-" + log);
//
//            ftpClient.enterLocalPassiveMode();
//
//            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//
//            // APPROACH #1: uploads first file using an InputStream
//            File firstLocalFile = new File(p.getProperty("up")+nombre);
//
//            InputStream inputStream = new FileInputStream(firstLocalFile);
//
//            System.out.println("Iniciando subida");
//            boolean done = ftpClient.storeFile(nombre, inputStream);
//            inputStream.close();
//            if (done) {
//                System.out.println("Subida exitosa!");
//                return true;
//            } else {
//                return false;
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            return false;
//        }
        return true;
    }
}
