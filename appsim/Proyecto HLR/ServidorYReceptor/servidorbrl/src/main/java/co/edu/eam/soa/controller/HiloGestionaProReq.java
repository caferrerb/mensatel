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

import co.edu.eam.soa.util.Constantes;

public class HiloGestionaProReq implements Runnable {
	
	private Socket con;
	private BufferedReader entradaTxt;
	private PrintStream salidaTxt;
	
	public HiloGestionaProReq(Socket con){
		super();
		this.con = con;
		
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
        
        //while (conectado) {
        	
        	try {
				String msj = entradaTxt.readLine();
				
				if(msj != null){
					
					String[] respuesta = msj.split("@");
					
					if(respuesta.length == 2){
						
						//[0] : mensaje o la palabra "abonado"
						//[1] : el numero del abonado
						
							
						//validar si el abonado está en la lista de abonados
						if(Constantes.LISTA_SOCKETS.containsKey(respuesta[1])){
							
							PrintStream salidaTxtBeeper = new PrintStream(Constantes.LISTA_SOCKETS.get(respuesta[1]).getOutputStream());
							salidaTxtBeeper.println(respuesta[0]);
							
							salidaTxt.println("1#@#"+respuesta[1]+"#@#Mensaje recibido...");
						}else{
							salidaTxt.println("-1#@#"+respuesta[1]+"#@#Abonado "+respuesta[1]+" fuera de línea...");
						}
						
					}else{
						//Si no viene el @
						salidaTxt.println("-1#@#"+respuesta[1]+"#@#La estructura del mensaje y numero de abonado no es correcta. Puede faltar el simbolo arroba..");
					}
					
				}else{
					//Si el mensaje es null o vacio
					salidaTxt.println("Error. El mensaje está vacío");
				}
				
				
				conectado = false; 
				

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				String ipLan = getLocalAddress().getHostAddress();
            	String ipDesconectado = con.getInetAddress().getHostAddress();
            	
            	if(ipDesconectado.equals("127.0.0.1")){
            		ipDesconectado = ipLan;
				}
            	
            	System.out.println("Productor con la IP " + ipDesconectado + " desconectado.");
                
                //cambia el flag para detener el bucle del hilo
                conectado = false; 
                       
                try {
                	// Si se ha producido un error al recibir datos del cliente se cierra la conexion con el.
                    entradaTxt.close();
                    salidaTxt.close();
                } catch (IOException ex2) {
                	System.out.println("Error al cerrar los stream de entrada y salida :" + ex2.getMessage());
                }
			}finally{
				try {
					con.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
        
        //}
		
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
