package com.example.toolbar.ui.mapa;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.example.toolbar.R;

public class MapaFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap googleMap;
    MapView mMapView;
    private View root;
    private double lat;
    private double lon;

    public MapaFragment(String lat, String lon) {
        this.lat = Double.parseDouble(lat);
        this.lon = Double.parseDouble(lon);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.root = inflater.inflate(R.layout.fragment_mapa, container, false);
/*
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.main_branch_map);
        mapFragment.getMapAsync(this);*/

        mMapView = (MapView) this.root.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                LatLng sydney = new LatLng(lat, lon);

                googleMap.addMarker(new MarkerOptions().position(sydney).title("Ruta"));

                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();

                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });


        return root;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap = googleMap;
        LatLng UCA = new LatLng(-34, 151);
        googleMap.addMarker(new MarkerOptions().position(UCA).title("YOUR TITLE")).showInfoWindow();

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(UCA, 17));

    }

}
