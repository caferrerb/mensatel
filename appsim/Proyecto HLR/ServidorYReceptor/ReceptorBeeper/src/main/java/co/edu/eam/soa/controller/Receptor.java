package co.edu.eam.soa.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

public class Receptor implements Runnable {
	
	private Properties propiedades;
	private String ip_host;
	private int puerto_host;
	private String num_abonado;
	
	private Socket con;
	private PrintStream salidaTxt;
	private BufferedReader entradaTxt;
	
	public Receptor(){
			propiedades = new Properties();
		
		/**Cargamos el archivo desde la ruta especificada*/
		try {
			propiedades
			     .load(getClass().getResourceAsStream("/co/edu/eam/soa/config/beeperConfig.properties"));
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("Archivo de propiedades con encontrado");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ip_host = propiedades.getProperty("ip_host");
		puerto_host = Integer.parseInt(propiedades.getProperty("port"));
		num_abonado = propiedades.getProperty("num_abonado");
		
		try {
			con = new Socket(ip_host, puerto_host);
			salidaTxt = new PrintStream(con.getOutputStream());
			entradaTxt = new BufferedReader(new 
						InputStreamReader(con.getInputStream()));
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void run() {
		
		salidaTxt.println("abonado@"+num_abonado);
		String respuesta;
		try {
			respuesta = entradaTxt.readLine();
			System.out.println("Respuesta Servidor: "+respuesta);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		boolean conectado = true;
		while(conectado){
			
			try {
				String mensaje = entradaTxt.readLine();
				System.out.println("Mensaje recibido: "+mensaje);
			} catch (IOException e) {
				System.out.println("RECEPTOR CLASS: "+e.getMessage());
				//e.printStackTrace();
				
				
			}
			
		}
		
	}

}
