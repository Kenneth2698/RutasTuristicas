package com.example.toolbar.ui.listarutas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.toolbar.R;
import com.example.toolbar.ui.ruta.RutaFragment;

import java.util.ArrayList;

public class ListaRutasFragment extends Fragment {

    private ListView listview;
    private ListaRutasViewModel listaRutasViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        listaRutasViewModel = ViewModelProviders.of(this).get(ListaRutasViewModel .class);

        View root = inflater.inflate(R.layout.fragment_listarutass, container, false);


        this.listview = (ListView) root.findViewById(R.id.listarutas);
        this.cargarLista();

        this.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //aqui se debe tomasr el id o asi de la ruta que se le dio click
                Fragment fragment = null;
                fragment = new RutaFragment();
                replaceFragment(fragment);

            }
        });

        return root;
    }


    private void cargarLista(){
        ArrayList<String> rutas = new ArrayList<String>();

        rutas.add("Ruta 1 Niños (Cultural)");
        rutas.add("Ruta 2 Adultos (Aventura)");
        rutas.add("Ruta 3 Todo público (Playa)");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1, rutas);

        this.listview.setAdapter(adapter);
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(this.getId(), someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
