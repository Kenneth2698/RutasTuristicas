package com.example.toolbar.ui.listarutas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.toolbar.IOHelper;
import com.example.toolbar.R;
import com.example.toolbar.model.Atractivo;
import com.example.toolbar.model.Ruta;
import com.example.toolbar.ui.ruta.RutaFragment;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListaRutasFragment extends Fragment {

    private ArrayList<Ruta> rutas;
    private ListView listview;
    private ListaRutasViewModel listaRutasViewModel;

    public ListaRutasFragment(ArrayList<Ruta> rutas) {
        this.rutas = rutas;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        listaRutasViewModel = ViewModelProviders.of(this).get(ListaRutasViewModel .class);

        View root = inflater.inflate(R.layout.fragment_listarutass, container, false);


        this.listview = (ListView) root.findViewById(R.id.listarutas);
        this.cargarLista();

        this.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                IOHelper ioHelper = new IOHelper();
                String atractivosJson =  ioHelper.stringFromAsset(getContext(),"atractivos.json");//se leen todos los atractivos

                ArrayList<Atractivo> atractivos = new ArrayList<>();
                try {

                    JSONArray atractivossArray = new JSONArray(atractivosJson);
                    Gson gson = new Gson();

                    for (int i = 0; i < atractivossArray.length(); i++){
                        JSONObject rutaJSON = atractivossArray.getJSONObject(i);
                        Atractivo atractivo = gson.fromJson(rutaJSON.toString(), Atractivo.class);

                        if(atractivo.getIdRuta()==rutas.get(position).getId()){//Asi se obtienen todos los atractivos pertenecientes a la ruta seleccionada
                            atractivos.add(atractivo);
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                Fragment fragment = null;
                fragment = new RutaFragment(atractivos, rutas.get(position).getLatitud(),rutas.get(position).getLongitud());
                replaceFragment(fragment);

            }
        });

        return root;
    }


    private void cargarLista(){
        ArrayList<String> nombreRutas = new ArrayList<>();

        for (int i = 0; i < this.rutas.size(); i++){
            Ruta ruta = this.rutas.get(i);
            nombreRutas.add(ruta.getNombre());
            //Log.d("SALIDA", ruta.getString("nombre"));

        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1, nombreRutas);

        this.listview.setAdapter(adapter);
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(this.getId(), someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
