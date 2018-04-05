package com.example.effob.projetandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
//Fragment de l'Activité Main. Permet d'afficher les statistiques de la collection. Initialisée aux statistiques globales
public class StatsFragment extends Fragment {


    private Main activity;

    public StatsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("DEBUG", "CREATION STATSFRAGMENT");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stats, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        this.activity = (Main) getActivity();
        Log.d("DEBUG", "STATS FRAG START");
        FragmentTransaction ft = this.activity.getSupportFragmentManager().beginTransaction();
        GlobalStats gl = new GlobalStats();
        ft.replace(R.id.StatsContainer, gl);
        ft.commit();
        Log.d("DEBUG", "STATS FRAG START 222");
    }

}