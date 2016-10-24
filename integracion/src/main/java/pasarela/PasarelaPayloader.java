package pasarela;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class PasarelaPayloader implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		// Se extrae la variable correo de flowvars
		Map<String, String> map = (Map<String, String>) eventContext.getMessage().getInvocationProperty("pago");
		String valor = map.get("valor").toString();
		String numT = map.get("numtarjeta").toString();
		String apiKey = "4Vj8eK4rloUd272L48hsrarnUA";
		String merchanId = "508029";
		String moneda = "COP";
		// Codigo unico
		String referenecia = java.util.UUID.randomUUID().toString();
		int fin = referenecia.indexOf("-");
		// Cadena a codificar
		String codigo = apiKey + "~" + merchanId + "~" + referenecia.substring(0, fin) + "~" + valor + "~" + moneda;
		// Cadena codificadaa
		String firma = cifrarMD5(codigo);
		String sucursal = sucursal(numT);
		// Se crea el objeto en el que se retornara el mapa
		Map<String, String> ma = new LinkedHashMap<>();
		ma.put("referencia", referenecia.substring(0,fin));
		ma.put("firma",firma);
		ma.put("codigo", codigo);
		ma.put("sucursal", sucursal);
		return ma;
	}
	
	public String sucursal(String tarjeta){
		String in = tarjeta.substring(0,1);
		if(in.equalsIgnoreCase("4")){
			return "VISA";
		}else if(in.equalsIgnoreCase("5")){
			return "MASTERCARD";
		}else if(in.equalsIgnoreCase("3")){
			return "AMEX";
		}
		return null;
	}

	public String cifrarMD5(String codigo) {

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] b = md.digest(codigo.getBytes());
			int size = b.length;
			StringBuffer h = new StringBuffer(size);
			// algoritmo y arreglo md5
			for (int i = 0; i < size; i++) {
				int u = b[i] & 255;
				if (u < 16) {
					h.append("0" + Integer.toHexString(u));
				} else {
					h.append(Integer.toHexString(u));
				}
			}
			// clave encriptada
			return h.toString();
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
