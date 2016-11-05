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

import com.mensatel.hilos.AsyncTaskListarPlanes;
import com.mensatel.hilos.AsyncTaskRecargarAbonado;
import com.mensatel.mensatel.R;


import java.util.HashMap;
import java.util.regex.Pattern;

import fr.ganfra.materialspinner.MaterialSpinner;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_Recargar.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Recargar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Recargar extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    AsyncTaskRecargarAbonado recargar;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    MaterialSpinner spinnerPlan, spinnerAño, spinnerMes;
    Button btnRecargar, btnCancelar;
    Snackbar snackbar;
    View snackbarView;
    HashMap<String,String> map = new HashMap<String, String>();

    private TextInputLayout tilMonto, tilNumTar, tilCodigoS, tilAbonado;

    private OnFragmentInteractionListener mListener;

    public Fragment_Recargar() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Recargar.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Recargar newInstance(String param1, String param2) {
        Fragment_Recargar fragment = new Fragment_Recargar();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment__recargar, container, false);

       /* ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.plan, android.R.layout.simple_spinner_item);*/

        ArrayAdapter<CharSequence> adapterA = ArrayAdapter.createFromResource(getActivity(),
                R.array.años, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapterM = ArrayAdapter.createFromResource(getActivity(),
                R.array.meses, android.R.layout.simple_spinner_item);

        spinnerPlan = (MaterialSpinner) view.findViewById(R.id.spinnerPlan);
        AsyncTaskListarPlanes listarPlanes = new AsyncTaskListarPlanes(map,spinnerPlan,Fragment_Recargar.this,snackbar,snackbarView,container);
        listarPlanes.execute();
        spinnerAño = (MaterialSpinner) view.findViewById(R.id.spinnerYear);
        spinnerMes = (MaterialSpinner) view.findViewById(R.id.spinnerMonth);

        spinnerMes.setAdapter(adapterM);
       // spinnerPlan.setAdapter(adapter);
        spinnerAño.setAdapter(adapterA);

        spinnerPlan.setSelection(1);
        spinnerAño.setSelection(1);
        spinnerMes.setSelection(1);

        tilCodigoS = (TextInputLayout) view.findViewById(R.id.til_codTarjeta);
        tilNumTar = (TextInputLayout) view.findViewById(R.id.til_numTarjeta);
        tilMonto = (TextInputLayout) view.findViewById(R.id.til_monto);
        tilAbonado = (TextInputLayout) view.findViewById(R.id.til_abonado);

        btnCancelar = (Button) view.findViewById(R.id.btnCancelarRecarga);
        btnRecargar = (Button) view.findViewById(R.id.btnRecargar);

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

        btnRecargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean val = validarDatos();
                if (val) {
                    String monto = tilMonto.getEditText().getText().toString();
                    String numTar = tilNumTar.getEditText().getText().toString();
                    String codigo = tilCodigoS.getEditText().getText().toString();
                    String numero = tilAbonado.getEditText().getText().toString();
                    String fecha =  spinnerAño.getSelectedItem().toString()+"/"+spinnerMes.getSelectedItem().toString();
                    //String plan = String.valueOf(spinnerPlan.getSelectedItemPosition());
                    String plan = map.get(spinnerPlan.getSelectedItem().toString());
                    recargar= new AsyncTaskRecargarAbonado(numero,plan,monto,numTar,codigo,fecha,Fragment_Recargar.this,snackbar,snackbarView,container);
                    recargar.execute();
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

    private void limpiarCampos() {
        tilMonto.getEditText().setText("");
        tilNumTar.getEditText().setText("");
        tilCodigoS.getEditText().setText("");
        tilAbonado.getEditText().setText("");

        tilAbonado.setError(null);
        tilNumTar.setError(null);
        tilCodigoS.setError(null);
        tilMonto.setError(null);

        spinnerPlan.setSelection(1);
        spinnerPlan.setError(null);
        spinnerAño.setSelection(1);
        spinnerMes.setSelection(1);
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    private boolean validarDatos() {
        String monto = tilMonto.getEditText().getText().toString();
        String numTar = tilNumTar.getEditText().getText().toString();
        String codigo = tilCodigoS.getEditText().getText().toString();
        String numero = tilAbonado.getEditText().getText().toString();

        boolean a = valMonto(monto);
        boolean b = validarNum(numero);
        boolean c = valNumT(numTar);
        boolean d = valPlan();
        boolean e = valCodigo(codigo);

        if (a && b && c && d && e) {
            return true;
        } else {
            return false;
        }
    }

    public boolean valMonto(String monto) {
        if (monto.isEmpty()) {
            tilMonto.setError("Monto invalido");
            return false;
        } else {
            tilMonto.setError(null);
        }
        return true;
    }

    public boolean valNumT(String numero) {
        if (numero.isEmpty() || numero.length() > 16) {
            tilNumTar.setError("Numero Tarjeta Invalido");
            return false;
        } else {
            tilNumTar.setError(null);
        }
        return true;
    }

    public boolean valCodigo(String codigo) {
        if (codigo.isEmpty() || codigo.length() > 4) {
            tilCodigoS.setError("Codigo Seguridad Invalido");
            return false;
        } else {
            tilCodigoS.setError(null);
        }
        return true;
    }

    public boolean validarNum(String numero) {
        Pattern pattern = Pattern.compile("[0-9]{10}");
        if (!pattern.matcher(numero).matches()) {
            tilAbonado.setError("Numero Invalido");
            return false;
        } else {
            tilAbonado.setError(null);
        }
        return true;
    }

    public boolean valPlan() {
        if (spinnerPlan.getSelectedItem().equals("Seleccione")) {
            spinnerPlan.setError("Plan Invalido");
            return false;
        } else {
            spinnerPlan.setError(null);
        }
        return true;
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
