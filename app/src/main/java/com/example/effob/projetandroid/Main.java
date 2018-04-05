package com.example.effob.projetandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

//Activité principale. Permet d'accéder à la liste des extensions, aux statistiques et aux paramètres
public class Main extends AppCompatActivity{

    private TextView mTextMessage;
    private DatabaseProvider pokedex;
    public static String lang = null;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lang = getResources().getString(R.string.lang);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);


        pokedex = new DatabaseProvider(this);


        //Initialisation du menu
        mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d("listenerFrag", "beforeTransac");
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

                Log.d("listenerFrag", "afterTransac");
                if (ft == null){
                    Log.d("listenerFrag", "TransacNull");
                }
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        ListingExtensions lt = new ListingExtensions();
                        ft.replace(R.id.fragment, lt);
                        ft.commit();
                        return true;
                    case R.id.navigation_statistics:
                        StatsFragment lt2 = new StatsFragment();
                        ft.replace(R.id.fragment, lt2);
                        ft.commit();
                        return true;
                    case R.id.navigation_parameters:
                        return true;
                }
                return false;
            }
        };
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);




    }

    public DatabaseProvider getPokedex(){
        Log.d("DEBUG", "Récup pokedex");
        return pokedex;
    }

    //Permet de retourner sur la page de ListingExtensions au retour sur cette activité
    @Override
    public void onStart() {

        super.onStart();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ListingExtensions lt = new ListingExtensions();
        ft.replace(R.id.fragment, lt);
        ft.commit();
    }
}

