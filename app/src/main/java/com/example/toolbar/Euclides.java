package com.example.toolbar;

import android.util.Log;

import com.example.toolbar.model.Ruta;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Euclides {

    private int precio;
    private int tipoTurista;
    private int tipoActividad;
    private ArrayList<Ruta> rutas;

    public Euclides(int precio, int tipoTurista, int tipoActividad, String rutasJson) {
        this.precio = precio;
        this.tipoTurista = tipoTurista;
        this.tipoActividad = tipoActividad;

        rutas = new ArrayList<>();
        try {

            JSONArray rutasArray = new JSONArray(rutasJson);
            Gson gson = new Gson();

            for (int i = 0; i < rutasArray.length(); i++){
                JSONObject rutaJSON = rutasArray.getJSONObject(i);
                Ruta ruta = gson.fromJson(rutaJSON.toString(), Ruta.class);
                rutas.add(ruta);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Ruta> calcularDistancias() {
        ArrayList<Ruta> rutasFiltradas = new ArrayList<>();

        double resultado1 = 100000;
        double resultado2 = 100000;
        double resultado3 = 100000;
        double resultado4 = 100000;
        double resultado5 = 100000;

        int Ruta1 = 0;
        int Ruta2 = 0;
        int Ruta3 = 0;
        int Ruta4 = 0;
        int Ruta5 = 0;

        for (int i = 0; i < rutas.size(); i++){
            Ruta rutaAux = rutas.get(i);
            double sumatoria = (Math.pow(rutaAux.getPrecio() - this.precio, 2)) + (Math.pow(rutaAux.getTipoTurista() - this.tipoTurista, 2)) + (Math.pow(rutaAux.getTipoActividad() - this.tipoActividad, 2));
            double distancia = Math.sqrt(sumatoria);

            if(distancia < resultado1){
                resultado5 = resultado4;
                resultado4 = resultado3;
                resultado3 = resultado2;
                resultado2 = resultado1;
                resultado1 = distancia;

                Ruta5 = Ruta4;
                Ruta4 = Ruta3;
                Ruta3 = Ruta2;
                Ruta2 = Ruta1;
                Ruta1 = i;
            }else if(distancia < resultado2){
                resultado5 = resultado4;
                resultado4 = resultado3;
                resultado3 = resultado2;
                resultado2 = distancia;

                Ruta5 = Ruta4;
                Ruta4 = Ruta3;
                Ruta3 = Ruta2;
                Ruta2 = i;
            }else if(distancia < resultado3){
                resultado5 = resultado4;
                resultado4 = resultado3;
                resultado3 = distancia;

                Ruta5 = Ruta4;
                Ruta4 = Ruta3;
                Ruta3 = i;
            }else if(distancia < resultado4){
                resultado5 = resultado4;
                resultado4 = distancia;

                Ruta5 = Ruta4;
                Ruta4 = i;
            }else if(distancia < resultado5){
                resultado5 = distancia;

                Ruta5 = i;
            }
        }

        rutasFiltradas.add(rutas.get(Ruta1));
        rutasFiltradas.add(rutas.get(Ruta2));
        rutasFiltradas.add(rutas.get(Ruta3));
        rutasFiltradas.add(rutas.get(Ruta4));
        rutasFiltradas.add(rutas.get(Ruta5));

        return rutasFiltradas;
    }
}
