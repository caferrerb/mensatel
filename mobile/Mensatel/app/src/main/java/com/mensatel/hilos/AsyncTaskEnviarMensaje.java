package com.mensatel.hilos;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import layout.Fragment_Mensaje;

/**
 * Created by USUARIO on 29/10/2016.
 */

public class AsyncTaskEnviarMensaje extends AsyncTask<Void,String,Boolean> {

    private StringBuffer buffer = null;
    private final String ruta="http://174.142.65.144:8081/enviarmsj";
    private String numeroEmisor;
    private String numeroDestino;
    private String mensaje;
    private Fragment_Mensaje activity;
    private Snackbar snackbar;
    private View snackbarView;
    private ViewGroup container;
    JSONObject jsonobject;

    public AsyncTaskEnviarMensaje (String numEmisor, String numDestino, String mensaje, Fragment_Mensaje activity, Snackbar snackbar,View snack,ViewGroup container){
        this.mensaje=mensaje;
        this.numeroEmisor=numEmisor;
        this.numeroDestino=numDestino;
        this.activity=activity;
        this.snackbar=snackbar;
        this.snackbarView=snack;
        this.container=container;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
           /*Se define un objeto para la conexion*/
        HttpURLConnection conn = null;
        /*Se define un buffer para leer los resultados de la conexion*/
        BufferedReader reader = null;

        try{
            /*Se crea la conexion*/

            String jsonEnvio= "{\"Enviarmsj\":{\"abonadoorigen\":\""+numeroEmisor+"\",\"abonadodestino\":\""+numeroDestino+"\",\"mensaje\":\""+mensaje+"\"}}";
            JSONObject jObject = new JSONObject(jsonEnvio);
            /*Se establece un Objeto URL con la ruta definida*/
            URL url = new URL(ruta);
            /*Se añade la URL a la conexion*/
            conn = (HttpURLConnection) url.openConnection();
            /*Se define el tipo de conexion (GET - POST)*/
            conn.setRequestMethod("POST");
            /*Se añaden datos*/
            /*Se define en un objeto Uri.Builder para añadirle los datos que seran enviados*/
            Uri.Builder builder = new Uri.Builder().appendQueryParameter("Enviarmsj",jsonEnvio);

            /*Se codifican los datos añadidos con &&*/
            String query = builder.build().getEncodedQuery();

            /*Se define un OutputStream para añadir los datos definidos a la conexion como datos
            * de salida*/
            OutputStream os = conn.getOutputStream();
            /*Se pasan a un Buffer*/
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            /*Se añaden*/
            writer.write(query);
            /*Se confirma*/
            writer.flush();
            /*Se cierra la adicion*/
            writer.close();
            os.close();


            /*Se conecta, recibe datos y los lee*/

            /*Se ejecuta la conexion*/
            publishProgress("Se envian los datos");
            conn.connect();
            /*Con un InputStream Se obtienen los datos de la conexion*/
            InputStream stream = conn.getInputStream();
            /*Se define un reader para leer los datos, asociandolo al inputStream*/
            reader  = new BufferedReader(new InputStreamReader(stream));
            /*Se inicializa el buffer para almacenar como String los resultados*/
            buffer = new StringBuffer();
            /*Variable temporal para concatenar los datos leidos*/
            String line;
            /*Mientas lo que lea es diferente de vacio*/
            while((line = reader.readLine()) != null){
                /*Añadalos al buffer global*/
                buffer.append(line);
            }
        }catch (MalformedURLException e){
            publishProgress("Error mal estructura URL "+e.getMessage());
            e.printStackTrace();
            return false;
        }catch (IOException e){
            publishProgress("Error IO "+e.getMessage());
            e.printStackTrace();
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            /*Desconecta la conexion activa*/
            if(conn != null){
                conn.disconnect();
            }
            try{
                /*Cerramos los readers*/
                if(reader != null){
                    reader.close();
                }
            }catch (IOException e){
                publishProgress("Error al final "+e.getMessage());
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }
    protected void onProgressUpdate(String... values) {
        snackbar = Snackbar.make(container,values[0],Snackbar.LENGTH_SHORT);
        snackbarView = snackbar.getView();
        // snackbarView.setBackgroundColor(getResources().getColor(R.color.exito));
        snackbar.show();
    }


    @Override
    protected void onPostExecute(Boolean result) {
        try {

            if(result) {

                /*Como el resultado obtenido es un array JSON, se pasa el string JSON al array*/
                JSONArray jsonarray = new JSONArray(buffer.toString());

                /*Por cada elemento del JSON*/
                for (int i = 0; i < jsonarray.length(); i++) {
                    /*Se saca el objeto del array y se pasa a un objeto JSON*/
                    jsonobject = jsonarray.getJSONObject(i);
                    /*Se saca las variables del objeto*/
                    snackbar = Snackbar.make(container,"Operacion Exitosa!"+jsonobject.getString("respuesta"),Snackbar.LENGTH_SHORT);
                    snackbarView = snackbar.getView();

                    snackbar.show();

                }
            }else{
                snackbar = Snackbar.make(container,"Operacion Errada!"+jsonobject.getString("respuesta"),Snackbar.LENGTH_SHORT);
                snackbarView = snackbar.getView();
                // snackbarView.setBackgroundColor(getResources().getColor(R.color.exito));
                snackbar.show();
            }
        } catch (JSONException e) {

            snackbar = Snackbar.make(container,"Operacion Errada!"+e.getMessage(),Snackbar.LENGTH_SHORT);
            snackbarView = snackbar.getView();
            // snackbarView.setBackgroundColor(getResources().getColor(R.color.exito));
            snackbar.show();
            e.printStackTrace();
        }


    }
}
