package alfacom;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class TCPAlfacom implements Callable{

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		Map<String, String> map = (Map<String, String>) eventContext.getMessage().getPayload();
		return map.get("operador")+"|"+map.get("numeroorigen")+"|"+map.get("numerodestino")+"|"+cifrar(map.get("mensaje"))+"\n";
	}

	  public static String cifrar(String mensaje){
	        Base64.Encoder encoder = Base64.getEncoder();
	        String codificado = encoder.encodeToString(mensaje.getBytes(StandardCharsets.UTF_8));
	        return codificado;
	    }
	    
	    public static  String descifrar(String mensaje){
	        Base64.Decoder decoder = Base64.getDecoder();
	        byte[] decodedByteArray = decoder.decode(mensaje);
	        String desco = new String(decodedByteArray);
	        return desco;
	    }
}
