package co.edu.eam.util;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.eam.util.RespuestaConsultaFacturaMovil;
import co.edu.eam.util.ExcepcionNegocio;
import co.edu.eam.util.HTTPUtil;

public class InvocadorFacturaMovil {

	/**
	 * Metodo para consultar una factura movil
	 * 
	 * @param numeroRef,
	 *            numero de la referencia.
	 * @return
	 * @throws Exception
	 */
	public RespuestaConsultaFacturaMovil consultarFactura(String numeroRef) throws Exception {
		String path = "consultarfactura";
		Map<String, String> parametros = new HashMap<>();
		parametros.put("referencia", numeroRef);

		String resp = HTTPUtil.doGet(path, parametros);
		System.out.println(resp);

		ObjectMapper mapper = new ObjectMapper();
		// read JSON from a file

		Map<String, Object> map = mapper.readValue(resp.getBytes(), new TypeReference<Map<String, Object>>() {
		});

		Map<String, Object> respMap = (Map<String, Object>) (map.get("resp"));
		if ("00".equals(respMap.get("codigo"))) {
			String numero = respMap.get("numero").toString();
			String valor = respMap.get("valor").toString();
			return new RespuestaConsultaFacturaMovil(numero, valor);
		} else {
			throw new ExcepcionNegocio("<explicar razon, o mostrar mensaje que llega>");
		}

	}
}
