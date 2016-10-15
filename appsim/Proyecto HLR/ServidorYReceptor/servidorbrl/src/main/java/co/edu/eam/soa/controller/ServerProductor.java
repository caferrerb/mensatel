package co.edu.eam.soa.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ServerProductor implements Runnable {

	private Executor pool;
	private int numThreads;
	private Properties propiedades;
	private int puerto_productor;

	public ServerProductor() {
		propiedades = new Properties();

		/** Cargamos el archivo desde la ruta especificada */
		try {
			propiedades.load(new FileInputStream("serverConfig.properties"));
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			System.out.println("Archivo de propiedades con encontrado");
		} catch (IOException e) {
			e.printStackTrace();
		}

		numThreads = Integer.parseInt(propiedades.getProperty("max-thread-pool"));
		puerto_productor = Integer.parseInt(propiedades.getProperty("port_productor"));
	}

	public void run() {
		pool = Executors.newFixedThreadPool(numThreads);

		try {
			ServerSocket serverSock = new ServerSocket(puerto_productor);
			while (true) {

				System.out.println("Esperando solicitud de Productores...");
				Socket con = serverSock.accept();

				String ip = con.getInetAddress().getCanonicalHostName();


				System.out.println("Productor con la IP " + ip + " conectado.");

				HiloGestionaProReq hilo = new HiloGestionaProReq(con);
				pool.execute(hilo);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Devuelve la ip de la conexion LAN dada por el router no el localhost
	 * 
	 * @return
	 */
	private InetAddress getLocalAddress() {
		try {
			Enumeration<NetworkInterface> b = NetworkInterface.getNetworkInterfaces();
			while (b.hasMoreElements()) {
				for (InterfaceAddress f : b.nextElement().getInterfaceAddresses())
					if (f.getAddress().isSiteLocalAddress())
						return f.getAddress();
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return null;
	}

}
