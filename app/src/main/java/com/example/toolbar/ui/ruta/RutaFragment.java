package com.example.toolbar.ui.ruta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import com.example.toolbar.R;
import com.example.toolbar.ui.mapa.MapaFragment;


public class RutaFragment extends Fragment {
    private View root;
    private RutaViewModel rutaViewModel;
    private Button mapaBtn;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        rutaViewModel =
                ViewModelProviders.of(this).get(RutaViewModel .class);

        this.root = inflater.inflate(R.layout.fragment_ruta, container, false);

        root.findViewById(R.id.igle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView fotoIglesia = (ImageView) root.findViewById(R.id.fotoiglesia);
                TextView textoIglesia = (TextView) root.findViewById(R.id.textoiglesia);

                if (fotoIglesia.getVisibility() == root.GONE && textoIglesia.getVisibility() == root.GONE) {
                    fotoIglesia.setVisibility(root.VISIBLE);
                    textoIglesia.setVisibility(root.VISIBLE);
                } else {
                    fotoIglesia.setVisibility(root.GONE);
                    textoIglesia.setVisibility(root.GONE);
                }
            }
        });

        root.findViewById(R.id.cata).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView fotoCata = (ImageView) root.findViewById(R.id.fotocatarata);
                TextView textoCata = (TextView) root.findViewById(R.id.textocatarata);

                if(fotoCata.getVisibility() == root.GONE && textoCata.getVisibility() == root.GONE){
                    fotoCata.setVisibility(root.VISIBLE);
                    textoCata.setVisibility(root.VISIBLE);
                }else{
                    fotoCata.setVisibility(root.GONE);
                    textoCata.setVisibility(root.GONE);
                }
            }
        });

        root.findViewById(R.id.camin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView fotoCamin = (ImageView) root.findViewById(R.id.fotocaminata);
                TextView textoCamin = (TextView) root.findViewById(R.id.textocaminata);

                if(fotoCamin.getVisibility() == root.GONE && textoCamin.getVisibility() ==root.GONE){
                    fotoCamin.setVisibility(root.VISIBLE);
                    textoCamin.setVisibility(root.VISIBLE);
                }else{
                    fotoCamin.setVisibility(root.GONE);
                    textoCamin.setVisibility(root.GONE);
                }
            }
        });

        mapaBtn = root.findViewById(R.id.mapaBtn);

        mapaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                fragment = new MapaFragment();
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
