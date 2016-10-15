package co.edu.eam.soa.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket soc=new Socket("localhost", 6000);
		PrintStream salida=new PrintStream(soc.getOutputStream());
		BufferedReader entrada=new BufferedReader(new InputStreamReader(soc.getInputStream()));
		
		salida.println(new Date().toString()+"@00001");
		System.out.println(entrada.readLine());
	}

}
