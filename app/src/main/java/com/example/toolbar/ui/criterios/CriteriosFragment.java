package com.example.toolbar.ui.criterios;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.toolbar.R;
import com.example.toolbar.ui.listarutas.ListaRutasFragment;

public class CriteriosFragment extends Fragment {

    private CriteriosViewModel galleryViewModel;
    private Button buscarBtn;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(CriteriosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_criterios, container, false);


        Spinner spinnerS = root.findViewById (R.id.spinner_tipo_turista);
        ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(this.getContext(), R.array.tipo_turista, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerS.setAdapter(adapter);

        Spinner spinnerA = root.findViewById(R.id.spinner_tipo_actividad);
        ArrayAdapter<CharSequence> adapterA =  ArrayAdapter.createFromResource(this.getContext(), R.array.tipo_actividad, android.R.layout.simple_spinner_item);
        adapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerA.setAdapter(adapterA);

        buscarBtn = root.findViewById(R.id.buscarBtn);

        buscarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                fragment = new ListaRutasFragment();
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
