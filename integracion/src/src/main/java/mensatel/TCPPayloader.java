package mensatel;

import java.util.Map;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class TCPPayloader implements Callable{

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		Map<String, String> map = (Map<String, String>) eventContext.getMessage().getPayload();
		return map.get("mensaje")+"@"+map.get("numerodestino")+"\n";
	}

}
