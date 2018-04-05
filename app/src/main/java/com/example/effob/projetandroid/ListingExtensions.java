package com.example.effob.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

//Fragment de l'activité Main. Permet de présenter la liste des Extensions présentes dans la base de données
public class ListingExtensions extends Fragment {

    private DatabaseProvider pokedex;
    private Main activity;
    public ArrayList<String> nomExtension = new ArrayList<String>();


    public ListingExtensions() {
    }


    //Création de la vue
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listing_extensions, container, false);
    }

    //Remplissage de la view
    @Override
    public void onStart(){
        super.onStart();
        activity = (Main) getActivity();
        pokedex = activity.getPokedex();

        if (nomExtension.isEmpty()) {

            for (Extension e : this.pokedex.getAllExtension()) {
                nomExtension.add(e.get_name());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, R.layout.simple_list_item_1, nomExtension);
            ListView liste = (ListView) activity.findViewById(R.id.list);
            liste.setAdapter(adapter);
            liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Log.d("ListView", i + "");
                    Intent intent = new Intent(activity, ExtensionList.class);
                    intent.putExtra("index", i);
                    startActivity(intent);
                }
            });
        }
    }


}
