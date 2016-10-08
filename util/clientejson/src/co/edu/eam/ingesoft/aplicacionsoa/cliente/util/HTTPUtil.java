package co.edu.eam.ingesoft.aplicacionsoa.cliente.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class HTTPUtil {

	private static final String USER_AGENT = "Mozilla/5.0";

	private static String IP = "192.175.105.16";
	private static String PUERTO = "8090";

	/**
	 * metodo para hacer un post.
	 * 
	 * @param url
	 * @param parametros
	 * @return
	 * @throws Exception
	 */
	public static String doPost(String path, Map<String, String> parametros) throws Exception {
		URL obj = new URL("http://" + IP + ":" + PUERTO + "/" + path);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		StringBuilder urlParameters = new StringBuilder();
		for (Map.Entry<String, String> param : parametros.entrySet()) {
			urlParameters.append(param.getKey()).append("=").append(param.getValue()).append("&");
		}
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters.toString());
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + obj.toString());
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		return (response.toString());
	}

	/**
	 * metodo para hacer un post.
	 * 
	 * @param url
	 * @param parametros
	 * @return
	 * @throws Exception
	 */
	public static String doGet(String path, Map<String, String> parametros) throws Exception {

		StringBuilder urlParameters = new StringBuilder();
		for (Map.Entry<String, String> param : parametros.entrySet()) {
			urlParameters.append(param.getKey()).append("=").append(param.getValue()).append("&");
		}
		URL obj = new URL("http://" + IP + ":" + PUERTO + "/" + path + "?" + urlParameters);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + obj.toString());
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		// print result
		return (response.toString());
	}

}
