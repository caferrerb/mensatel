package com.example.caferrerb.testpushfirebase;

import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;

import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private class MailSender extends AsyncTask<String, Long, String> {

        private String asunto,mensaje,destinatario;
        protected String doInBackground(String... params) {
            HttpURLConnection con=null;
            try {
                String url = "http://174.142.65.144:18000/rest/mailer/enviarmail?asunto=%s&mensaje=%s&destinatario=%s";

                URL obj = new URL(String.format(url,asunto,mensaje,destinatario));
                 con = (HttpURLConnection) obj.openConnection();

                // optional default is GET
                con.setRequestMethod("GET");

                int responseCode = con.getResponseCode();
                return responseCode+"";

            } catch (Exception exception) {
                return null;
            }finally {
             con.disconnect();
            }
        }

       public MailSender(String as,String dest,String msj){
           this.asunto=as;
           this.destinatario=dest;
           this.mensaje=msj;
       }

        protected void onPostExecute(String response) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

    try {
        EditText editmail = (EditText) findViewById(R.id.editmail);
        MailSender sender = new MailSender("DEvice ID app prueba Mensatel", editmail.getText().toString(), FirebaseInstanceId.getInstance().getToken());
        sender.execute();
        Snackbar.make(view, "Enviando correo.......", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        }catch (Exception exc){
        Snackbar.make(view, "Error:"+exc.getMessage(), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        }
            }
        });

        TextView textView = (TextView) findViewById(R.id.idDevice);
        textView.setText(FirebaseInstanceId.getInstance().getToken());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
