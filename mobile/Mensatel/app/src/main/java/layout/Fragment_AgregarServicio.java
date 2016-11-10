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
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.mensatel.hilos.AsyncTaskAgregarServicio;
import com.mensatel.mensatel.R;

import java.util.regex.Pattern;

import fr.ganfra.materialspinner.MaterialSpinner;

/**
 *
 */
public class Fragment_AgregarServicio extends Fragment {

    MaterialSpinner spinnerServicio;
    Button btnAgregar, btnCancelar;
    Snackbar snackbar;
    View snackbarView;
    private TextInputLayout tilServicio;

    private OnFragmentInteractionListener mListener;
    AsyncTaskAgregarServicio agregarServicio;

    public Fragment_AgregarServicio() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vw =inflater.inflate(R.layout.fragment_fragment__agregar_servicio, container, false);

        ArrayAdapter<CharSequence> adapterA = ArrayAdapter.createFromResource(getActivity(),
                R.array.ServiciosSuplementario, android.R.layout.simple_spinner_item);

        spinnerServicio = (MaterialSpinner) vw.findViewById(R.id.spinnerServicio);
        spinnerServicio.setAdapter(adapterA);
        spinnerServicio.setSelection(0);

        tilServicio = (TextInputLayout) vw.findViewById(R.id.til_abonadoS);

        btnCancelar = (Button) vw.findViewById(R.id.btnCancelarRegistro);
        btnAgregar = (Button) vw.findViewById(R.id.btnAgregar);

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

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero = tilServicio.getEditText().getText().toString();
                boolean val = validar(numero);
                if(val){
                    String serv;
                    if (spinnerServicio.getSelectedItem().equals("Mail")){
                        serv="3";
                    }else if (spinnerServicio.getSelectedItem().equals("Sms")){
                        serv="1";
                    }else {
                        serv="2";
                    }

                    agregarServicio = new AsyncTaskAgregarServicio(serv,numero,Fragment_AgregarServicio.this,snackbar,snackbarView,container);
                    agregarServicio.execute();
                }else {
                    snackbar = Snackbar.make(container, "Verifique sus datos!", Snackbar.LENGTH_SHORT);
                    snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(getResources().getColor(R.color.error));
                    snackbar.show();
                }
            }
        });
        return vw;
    }

    private boolean validar(String numero) {
        boolean a = validarNum(numero);
        boolean b = valSpinner();

        if (a&&b){
            return true;
        }else {
            return false;
        }
    }

    private boolean valSpinner() {
        if (spinnerServicio.getSelectedItem().equals("Seleccione")||spinnerServicio.getSelectedItemPosition()==0){
            spinnerServicio.setError("Servicio Incorrecto");
            return false;
        }else{
            return true;
        }
    }

    public boolean validarNum(String numero) {
        Pattern pattern = Pattern.compile("[0-9]{10}");
        if (!pattern.matcher(numero).matches()) {
            tilServicio.setError("Numero Invalido");
            return false;
        } else {
            tilServicio.setError(null);
        }
        return true;
    }

    private void limpiarCampos() {
        spinnerServicio.setSelection(1);
        spinnerServicio.setError(null);
        tilServicio.getEditText().setText("");
        tilServicio.setError(null);
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
