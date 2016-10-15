package co.edu.eam.soa.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import co.edu.eam.soa.util.Constantes;

public class HiloGestionaReq implements Runnable {
	
	private Socket con;
	private BufferedReader entradaTxt;
	private PrintStream salidaTxt;
	
	//private int puerto_abonado;
	
	//private Map<String, String> map_abonados = new HashMap<String, String>();
	//final Map<String, Socket> map_sockets = new HashMap<String, Socket>();
	
	public HiloGestionaReq(Socket con) {
		super();
		this.con = con;
		//this.puerto_abonado = puerto_abonado;
		
		//map_abonados = new Utilidades().fileToMap("lista_abonados.txt");
		
		//Se inicializan el flujo de entrada y salida
		try {
			salidaTxt = new PrintStream(con.getOutputStream());
			entradaTxt = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} catch (IOException ex) {
			System.out.println("Error al crear los stream de entrada y salida : " + ex.getMessage());
		}
	}

	public void run() {
		
		boolean conectado = true;
        
        while (conectado) {
        	
        	try {
				String msj = entradaTxt.readLine();
				
				String[] respuesta = msj.split("@");
				
				//[0] : mensaje o la palabra "abonado"
				//[1] : el numero del abonado
				
				//Funcionalidad para almacenar los abonados conectados 
				if(respuesta[0].equals("abonado")){
					
					//Se almacena en el mapa de sockets para su posterior envio de 
					//mensajes
					Constantes.LISTA_SOCKETS.put(respuesta[1], con);
					salidaTxt.println("Se ha almacenado abonado: "+respuesta[1]);
				}
				//Se conecta la solicitud de envio
				else{
					
					
				}
				

			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				String ipLan = getLocalAddress().getHostAddress();
            	String ipDesconectado = con.getInetAddress().getHostAddress();
            	
            	if(ipDesconectado.equals("127.0.0.1")){
            		ipDesconectado = ipLan;
				}
            	
            	System.out.println("Abonado con la IP " + ipDesconectado + " desconectado.");
                
                //cambia el flag para detener el bucle del hilo
                conectado = false; 
                       
                try {
                	// Si se ha producido un error al recibir datos del cliente se cierra la conexion con el.
                    entradaTxt.close();
                    salidaTxt.close();
                } catch (IOException ex2) {
                	System.out.println("Error al cerrar los stream de entrada y salida :" + ex2.getMessage());
                }
			}
        
        }
		
	}
	
	/**
	 * Devuelve la ip de la conexion LAN dada por el router no el localhost
	 * @return
	 */
	private  InetAddress getLocalAddress(){
        try {
            Enumeration<NetworkInterface> b = NetworkInterface.getNetworkInterfaces();
            while( b.hasMoreElements()){
                for ( InterfaceAddress f : b.nextElement().getInterfaceAddresses())
                    if ( f.getAddress().isSiteLocalAddress())
                        return f.getAddress();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }

}

