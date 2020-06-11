package com.example.toolbar.ui.ruta;

import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.toolbar.R;
import com.example.toolbar.model.Atractivo;
import com.example.toolbar.ui.mapa.MapaFragment;

import java.util.ArrayList;


public class RutaFragment extends Fragment {
    private View root;
    private RutaViewModel rutaViewModel;
    private Button mapaBtn;
    private ArrayList<Atractivo> atractivos;
    private String lat;
    private String lon;

    public RutaFragment(ArrayList<Atractivo> atractivos, String lat, String lon) {
        this.atractivos = atractivos;
        this.lat = lat;
        this.lon = lon;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        rutaViewModel = ViewModelProviders.of(this).get(RutaViewModel.class);

        this.root = inflater.inflate(R.layout.fragment_ruta, container, false);

        LinearLayout layout = (LinearLayout) root.findViewById(R.id.ly_principal);
        for (int i = 0; i < this.atractivos.size(); i++) {
            //TITULO
            TextView nombre = new TextView(getContext());
            nombre.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            nombre.setHeight(50);
            nombre.setGravity(Gravity.CENTER);
            nombre.setText(this.atractivos.get(i).getNombre());

            //TITULO
            ImageView imagen = new ImageView(getContext());
            String nombreImagen = "i" + String.valueOf(this.atractivos.get(i).getImagen());
            int imageId = getResources().getIdentifier(nombreImagen, "mipmap", getContext().getPackageName());
            imagen.setImageResource(imageId);
            imagen.setMaxWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            imagen.setMaxHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

            //DESCRIPCION
            TextView descripcion = new TextView(getContext());
            descripcion.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            descripcion.setHeight(300);
            descripcion.setGravity(Gravity.CENTER);
            descripcion.setText(this.atractivos.get(i).getDescripcion());

            layout.addView(nombre);
            layout.addView(imagen);
            layout.addView(descripcion);
        }

        mapaBtn = (Button) root.findViewById(R.id.mapaBtn);


        mapaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                fragment = new MapaFragment(lat,lon);
                replaceFragment(fragment);
            }
        });
        mapaBtn.setVisibility(View.VISIBLE);
        return root;
    }


    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(this.getId(), someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
