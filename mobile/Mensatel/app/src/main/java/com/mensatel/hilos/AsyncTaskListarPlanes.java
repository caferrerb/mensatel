package com.mensatel.hilos;

import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.mensatel.mensatel.R;

import org.json.JSONArray;
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
import java.util.ArrayList;
import java.util.HashMap;

import layout.Fragment_Recargar;

/**
 * Created by Francisco on 05/11/2016.
 */
public class AsyncTaskListarPlanes extends AsyncTask<Void, String, Boolean> {

    private StringBuffer buffer = null;
    private static final String USER_AGENT = "Mozilla/5.0";

    private static String IP = "174.142.65.144";
    private static String PUERTO = "8081";
    private String path = "planes/listar";
    private final String ruta = "http://174.142.65.144:8081/procedimientos/recargarabonado";
    private HashMap<String,String> map;
    private Spinner spinner;
    private Fragment_Recargar activity;
    private Snackbar snackbar;
    private View snackbarView;
    private ViewGroup container;
    JSONObject jsonobject;

    public AsyncTaskListarPlanes(HashMap<String,String> map,Spinner spiner,Fragment_Recargar activity, Snackbar snackbar, View snack, ViewGroup container) {
        this.spinner=spiner;
        this.map=map;
        this.activity = activity;
        this.snackbar = snackbar;
        this.snackbarView = snack;
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

        String jsonEnvio = "";

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

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            buffer = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                buffer.append(inputLine);
            }
            in.close();


           /* JSONObject jObject = new JSONObject(jsonEnvio);
            /*Se establece un Objeto URL con la ruta definida*/
           /* URL url = new URL(ruta);
            /*Se añade la URL a la conexion*/
            //conn = (HttpURLConnection) url.openConnection();
            /*Se define el tipo de conexion (GET - POST)*/
            //conn.setRequestMethod("POST");

            /*Se añaden datos*/
            /*Se define en un objeto Uri.Builder para añadirle los datos que seran enviados*/
            // Uri.Builder builder = new Uri.Builder().query(jsonEnvio);

            /*Se codifican los datos añadidos con &&*/
            // String query = builder.build().getQuery();

            /*Se define un OutputStream para añadir los datos definidos a la conexion como datos
            * de salida*/
            //OutputStream os = conn.getOutputStream();
            /*Se pasan a un Buffer*/
            // BufferedWriter writer = new BufferedWriter(
            //     new OutputStreamWriter(os, "UTF-8"));
            /*Se añaden*/
            //writer.write(jsonEnvio);
            /*Se confirma*/
            //writer.flush();
            /*Se cierra la adicion*/
            //writer.close();
            //  os.close();


            /*Se conecta, recibe datos y los lee*/

            /*Se ejecuta la conexion*/
            //  publishProgress("Se envian los datos"+responseCode);
            // conn.connect();
            /*Con un InputStream Se obtienen los datos de la conexion*/
            //InputStream stream = conn.getInputStream();
            /*Se define un reader para leer los datos, asociandolo al inputStream*/
            //reader = new BufferedReader(new InputStreamReader(stream));
            /*Se inicializa el buffer para almacenar como String los resultados*/
            //buffer = new StringBuffer();
            /*Variable temporal para concatenar los datos leidos*/
            //String line;
            /*Mientas lo que lea es diferente de vacio*/
            /*while ((line = reader.readLine()) != null) {
                //Añadalos al buffer global*/
               /* buffer.append(line);
                Log.d("r",line);
            }
        } catch (MalformedURLException e) {
            publishProgress("Error mal estructura URL " + e.getMessage());
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            publishProgress("Error IO " + e.getMessage());
            e.printStackTrace();
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            /*Desconecta la conexion activa*/
            /*if (conn != null) {
                conn.disconnect();
            }
            try {
                /*Cerramos los readers*/
              /*  if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                publishProgress("Error al final " + e.getMessage());
                e.printStackTrace();
                return false;
            }

        }*/
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
/*
    public static String doPostEnviar(String path, String json) throws Exception {
        URL obj = new URL("http://" + IP + ":" + PUERTO + "/" + path);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Content-Type", "application/json");

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(json);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + obj.toString());
        System.out.println("Post parameters : " + json);
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
*/

    @Override
    protected void onPostExecute(Boolean result) {
        try {

            if (result) {

                /*Como el resultado obtenido es un array JSON, se pasa el string JSON al array*/
                JSONArray jsonarray = new JSONArray(buffer.toString());
                ArrayList<String> nombre = new ArrayList<>();
                /*Por cada elemento del JSON*/
                for (int i = 0; i < jsonarray.length(); i++) {

                    /*Se saca el objeto del array y se pasa a un objeto JSON*/
                    jsonobject = jsonarray.getJSONObject(i);
                    map.put(jsonobject.getString("nombre"),String.valueOf(jsonobject.getInt("idplan")));
                    nombre.add(jsonobject.getString("nombre"));


                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity.getActivity(),
                        android.R.layout.simple_spinner_item, nombre);
                spinner.setAdapter(adapter);
            } else {

                    snackbar = Snackbar.make(container, "Operacion Fallida!", Snackbar.LENGTH_SHORT);
                    snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(activity.getResources().getColor(R.color.error));
                    snackbar.show();



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
