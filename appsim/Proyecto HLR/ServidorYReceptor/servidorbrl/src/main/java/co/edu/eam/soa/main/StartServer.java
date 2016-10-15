package co.edu.eam.soa.main;
import co.edu.eam.soa.controller.Server;
import co.edu.eam.soa.controller.ServerProductor;

public class StartServer {

	public static void main(String[] args) {
		
		Server server = new Server();
		new Thread(server).start();
		
		ServerProductor serverProductor = new ServerProductor();
		new Thread(serverProductor).start();

	}

}
