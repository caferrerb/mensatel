package test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.eam.ingesoft.aplicacionsoa.cliente.servicios.pagoservicios.dto.RespuestaConsultaFacturaMovil;
import co.edu.eam.ingesoft.aplicacionsoa.cliente.servicios.pagoservicios.invocador.InvocadorFacturaMovil;
import co.edu.eam.ingesoft.aplicacionsoa.cliente.util.HTTPUtil;

public class Main {

	public static void main(String[] args) throws Exception {

		consultarfactura();

		crearCuentaTest();

	}

	private static void consultarfactura() throws Exception {
		RespuestaConsultaFacturaMovil resp=new InvocadorFacturaMovil().consultarFactura("324234234");
		if(resp!=null){
			System.out.println(resp.getNumero());
			System.out.println(resp.getValor());
		}

	}

	private static void crearCuentaTest() throws Exception {
		String path = "crearclientee";
		Map<String, String> parametros = new HashMap<>();
		// numeroCuenta,cedulaCliente,saldoInicial
		parametros.put("nombre", "Claudia");
		parametros.put("cedula", "1094345567");

		String resp = HTTPUtil.doPost(path, parametros);
		System.out.println(resp);
	}
}
