package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.mensatel.hilos.AsyncTaskEnviarMensaje;
import com.mensatel.mensatel.R;

import java.util.regex.Pattern;

public class Fragment_Mensaje extends Fragment {


    //Referencias de campos
    private TextInputLayout tilNumero, tilDestino, tilMensaje;
    Button btnEnviar, btnCancelar;
    Snackbar snackbar;
    View snackbarView;

    private AsyncTaskEnviarMensaje enviar;

    private OnFragmentInteractionListener mListener;

    public Fragment_Mensaje() {

        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_mensaje, container, false);
        btnEnviar = (Button) view.findViewById(R.id.btnEnviar);
        tilDestino = (TextInputLayout) view.findViewById(R.id.til_numeroDestino);
        tilNumero = (TextInputLayout) view.findViewById(R.id.til_numero);
        tilMensaje = (TextInputLayout) view.findViewById(R.id.til_mensaje);
        btnCancelar = (Button) view.findViewById(R.id.btnCancelarEnvio);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarCampos();
                snackbar = Snackbar.make(container, "Operacion Cancelada", Snackbar.LENGTH_SHORT);
                snackbarView = snackbar.getView();
                snackbarView.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                snackbar.show();
            }
        });
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean val = validarDatos();
                if (val) {
                    try {
                        String mensaje = tilMensaje.getEditText().getText().toString();
                        String numero = tilNumero.getEditText().getText().toString();
                        String destino = tilDestino.getEditText().getText().toString();
                        enviar = new AsyncTaskEnviarMensaje(numero,destino,mensaje,Fragment_Mensaje.this,snackbar,snackbarView,container);
                        enviar.execute();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    snackbar = Snackbar.make(container, "Verifique sus datos!", Snackbar.LENGTH_SHORT);
                    snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(getResources().getColor(R.color.error));
                    snackbar.show();
                }
            }
        });

        return view;
    }

    public boolean validarNum(String numero, String destino) {
        Pattern pattern = Pattern.compile("[0-9]{10}");
        if (!pattern.matcher(numero).matches() || !pattern.matcher(destino).matches()) {
            tilNumero.setError("Numero Invalido");
            tilDestino.setError("Numero Invalido");
            return false;
        } else {
            tilNumero.setError(null);
            tilDestino.setError(null);
        }
        return true;
    }

    private void limpiarCampos() {
        tilDestino.getEditText().setText("");
        tilMensaje.getEditText().setText("");
        tilNumero.getEditText().setText("");
        tilNumero.setError(null);
        tilDestino.setError(null);
        tilMensaje.setError(null);
    }

    private boolean validarDatos() {
        String mensaje = tilMensaje.getEditText().getText().toString();
        String numero = tilNumero.getEditText().getText().toString();
        String destino = tilDestino.getEditText().getText().toString();

        boolean a = validarNum(numero, destino);
        boolean b = validarMensaje(mensaje);

        if (a && b) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validarMensaje(String mensaje) {
        if (mensaje.length() > 130 || mensaje.isEmpty()) {
            tilMensaje.setError("Mensaje Invalido");
        } else {
            tilMensaje.setError(null);
        }

        return true;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
