package com.example.toolbar.ui.criterios;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.toolbar.Euclides;
import com.example.toolbar.IOHelper;
import com.example.toolbar.R;
import com.example.toolbar.model.Ruta;
import com.example.toolbar.ui.listarutas.ListaRutasFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CriteriosFragment extends Fragment {

    private CriteriosViewModel galleryViewModel;
    private Button buscarBtn;
    private RadioGroup precios;

    private int precio;
    private int tipoTurista;
    private int tipoActividad;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(CriteriosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_criterios, container, false);


        Spinner spinnerTT = root.findViewById (R.id.spinner_tipo_turista);
        ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(this.getContext(), R.array.tipo_turista, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTT.setAdapter(adapter);

        Spinner spinnerTA = root.findViewById(R.id.spinner_tipo_actividad);
        ArrayAdapter<CharSequence> adapterA =  ArrayAdapter.createFromResource(this.getContext(), R.array.tipo_actividad, android.R.layout.simple_spinner_item);
        adapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTA.setAdapter(adapterA);

        spinnerTT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipoTurista = position+1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerTA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipoActividad = position+1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        precios = (RadioGroup) root.findViewById(R.id.rgPrecios);
        buscarBtn = root.findViewById(R.id.buscarBtn);

        buscarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (precios.getCheckedRadioButtonId() == R.id.rbEconomico) {
                    precio = 1;
                }else if (precios.getCheckedRadioButtonId() == R.id.rbRegular) {
                    precio = 2;
                }else{
                    precio = 3;
                }

                IOHelper ioHelper = new IOHelper();
                String rutasJson =  ioHelper.stringFromAsset(getContext(),"rutas.json");

                Euclides euclides = new Euclides(precio, tipoTurista, tipoActividad, rutasJson);
                ArrayList<Ruta> rutasFlitradas = euclides.calcularDistancias();

                Fragment fragment = null;
                fragment = new ListaRutasFragment(rutasFlitradas);
                replaceFragment(fragment);
            }
        });

        return root;
    }
    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(this.getId(), someFragment);
        transaction.addToBackStack(null);
        transaction.commit();


    }


}
