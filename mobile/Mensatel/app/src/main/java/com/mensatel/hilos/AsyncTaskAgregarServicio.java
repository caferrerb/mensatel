package com.mensatel.hilos;

import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.mensatel.mensatel.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import layout.Fragment_AgregarServicio;
import layout.Fragment_Mensaje;

/**
 * Created by USUARIO on 09/11/2016.
 */

public class AsyncTaskAgregarServicio extends AsyncTask<Void, String, Boolean> {

    private StringBuffer buffer = null;
    private static final String USER_AGENT = "Mozilla/5.0";

    private static String IP = "174.142.65.144";
    private static String PUERTO = "8081";
    private String path = "procedimientos/agregarservicio";
    private final String ruta = "http://174.142.65.144:8081/procedimientos/agregarservicio";
    private String numero;
    private String servicio;
    private Fragment_AgregarServicio activity;
    private Snackbar snackbar;
    private View snackbarView;
    private ViewGroup container;
    JSONObject jsonobject;


    public AsyncTaskAgregarServicio(String servicio,String numero, Fragment_AgregarServicio activity, Snackbar snackbar, View snackbarView, ViewGroup container) {
        this.servicio = servicio;
        this.numero = numero;
        this.activity = activity;
        this.snackbar = snackbar;
        this.snackbarView = snackbarView;
        this.container = container;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
           /*Se define un objeto para la conexion*/
        HttpURLConnection conn = null;
        /*Se define un buffer para leer los resultados de la conexion*/
        BufferedReader reader = null;

        /*try {
        /*Se crea la conexion*/

        String jsonEnvio = "{\"Agregarservicio\":{\"numeroabonado\":\"" + numero + "\",\"codigoservicio\":\"" + servicio + "\"}}";

        URL obj = null;
        try {
            obj = new URL("http://" + IP + ":" + PUERTO + "/" + path);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("Content-Type", "application/json");

            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(jsonEnvio);
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            publishProgress("Se envian los datos");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            buffer = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                buffer.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    protected void onProgressUpdate(String... values) {
        snackbar = Snackbar.make(container, values[0], Snackbar.LENGTH_SHORT);
        snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(activity.getResources().getColor(R.color.exito));
        snackbar.show();
        Log.d("Value", values[0]);
    }

    protected void onPostExecute(Boolean result) {
        try {

            if (result) {

                /*Como el resultado obtenido es un array JSON, se pasa el string JSON al array*/
                JSONObject jsonarray = new JSONObject(buffer.toString());

                /*Por cada elemento del JSON*/

                if( jsonarray.has("respuesta")){
                    jsonobject=jsonarray;
                    if(!jsonobject.getString("codigo").equalsIgnoreCase("COD-0000")) {
                        snackbar = Snackbar.make(container, "Operacion Fallida! " + jsonobject.getString("respuesta"), Snackbar.LENGTH_SHORT);
                        snackbarView = snackbar.getView();
                        snackbarView.setBackgroundColor(activity.getResources().getColor(R.color.error));
                        snackbar.show();

                    }else {
                        snackbar = Snackbar.make(container, "Operacion Exitosa! " + jsonarray.getString("respuesta"), Snackbar.LENGTH_SHORT);
                        snackbarView = snackbar.getView();
                        snackbarView.setBackgroundColor(activity.getResources().getColor(R.color.exito));
                        snackbar.show();
                    }
                }else {
                    if(jsonarray.getString("codigo").equalsIgnoreCase("COD-0000")) {
                        snackbar = Snackbar.make(container, "Operacion Exitosa! " + jsonarray.getString("mensaje"), Snackbar.LENGTH_SHORT);
                        snackbarView = snackbar.getView();
                        snackbarView.setBackgroundColor(activity.getResources().getColor(R.color.exito));
                        snackbar.show();

                    }else {
                        snackbar = Snackbar.make(container, "Operacion Fallida! " + jsonarray.getString("mensaje"), Snackbar.LENGTH_SHORT);
                        snackbarView = snackbar.getView();
                        snackbarView.setBackgroundColor(activity.getResources().getColor(R.color.error));
                        snackbar.show();
                    }
                }
            }
        } catch (JSONException e) {

            snackbar = Snackbar.make(container, "Operacion Errada!" + e.getMessage(), Snackbar.LENGTH_SHORT);
            snackbarView = snackbar.getView();
            snackbarView.setBackgroundColor(activity.getResources().getColor(R.color.error));
            snackbar.show();
            e.printStackTrace();
        }


    }
}
