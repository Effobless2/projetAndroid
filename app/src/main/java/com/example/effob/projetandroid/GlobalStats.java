package com.example.effob.projetandroid;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;


//Fragment de l'activité Main, permet de voir les statistiques de la collection
public class GlobalStats extends Fragment {

    private Main activity;
    private DatabaseProvider pokedex;
    private ArrayList<RelationCardFormat> relations = new ArrayList<>();


    public GlobalStats() {
        // Required empty public constructor
    }


    //Creation de la view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Log.d("DEBUG"," ONCREATE GLOB");
        return inflater.inflate(R.layout.fragment_global_stats, container, false);
    }

    //Remplissage de la view
    @Override
    public void onStart() {
        super.onStart();

        Log.d("DEBUG"," ONSTART GLOB");
        this.activity = (Main)getActivity();
        this.pokedex = this.activity.getPokedex();
        relations = this.pokedex.getAllRelations();
        FrameLayout content = (FrameLayout) this.activity.findViewById(R.id.StatsContainer);
        Button btn = activity.findViewById(R.id.btnGlobal);
        ((Button) activity.findViewById(R.id.btnBySet)).setEnabled(false);
        ((Button) activity.findViewById(R.id.btnBySet)).setBackgroundColor(Color.WHITE);
        btn.setEnabled(true);
        btn.setBackgroundColor(Color.BLUE);

        //Calcul du nombre de cartes total obtenues
        int nbTotal = 0;
        for (RelationCardFormat relation : relations){
            if (relation.isChecked()){
                nbTotal++;
            }
        }
        TextView tot = (TextView) this.activity.findViewById(R.id.numberTotal);
        tot.setText(nbTotal+"/"+relations.size());

        //Création des statistiques par rareté
        ArrayList<Rarity> rarities = this.pokedex.getAllRarities();
        Log.d("DEBUG", "Récupération des rarités : "+rarities.size());
        RarityAdapter AdaptRar = new RarityAdapter(this.activity, rarities, relations);
        RecyclerView resRar = this.activity.findViewById(R.id.resumeRarity);
        resRar.setAdapter(AdaptRar);
        LinearLayoutManager layRar = new LinearLayoutManager(activity);
        layRar.setOrientation(LinearLayoutManager.VERTICAL);
        resRar.setLayoutManager(layRar);
        resRar.setHasFixedSize(true);
        resRar.setNestedScrollingEnabled(false);

        //Création des statistiques par format
        ArrayList<Format> formats = this.pokedex.getAllFormats();
        Log.d("DEBUG", "récupération des formats" + formats.size());

        Log.d("DEBUG", "récupération des rel" + relations.size());
        RecyclerView resForm = this.activity.findViewById(R.id.resumeFormat);
        FormatAdapter AdaptFor = new FormatAdapter(this.activity, formats, relations);
        Log.d("DEBUG", "creation de l'adapter");
        resForm.setAdapter(AdaptFor);
        LinearLayoutManager layFor = new LinearLayoutManager(activity);
        layFor.setOrientation(LinearLayoutManager.VERTICAL);
        resForm.setLayoutManager(layFor);
        resForm.setHasFixedSize(true);
        resForm.setNestedScrollingEnabled(false);

        RecyclerView resType = this.activity.findViewById(R.id.resumeType);
        ArrayList<Type> types = this.pokedex.getAllTypes();
        TypesAdapter AdaptType = new TypesAdapter(this.activity, types, relations);
        Log.d("DEBUG", "creation de l'adapter");
        resType.setAdapter(AdaptType);
        LinearLayoutManager layType = new LinearLayoutManager(activity);
        layType.setOrientation(LinearLayoutManager.VERTICAL);
        resType.setLayoutManager(layType);
        resType.setHasFixedSize(true);
        resType.setNestedScrollingEnabled(false);


    }

}
