package com.example.effob.projetandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

//Activité contenant la liste de l'ensemble des cartes de l'Extension récupérée via l'Intent
public class ExtensionList extends AppCompatActivity {

    private DatabaseProvider pokedex;
    private Extension extension;

    private ArrayList<String> nomCartes = new ArrayList<>();

    //Création de la vue
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extension_list);

        Intent intent = getIntent();
        int i = intent.getIntExtra("index", 12);

        pokedex = new DatabaseProvider(this);

        extension = this.pokedex.getExtensionById(i);


    }

    //Remplissage de la vue car impossible à réaliser dans le onCreate car elle n'existe pas encore à ce moment là
    @Override
    public void onStart() {
        super.onStart();
        setTitle(extension.get_name());

        ArrayList<Card> cards = this.pokedex.getAllCardByExtension(extension);

        for (Card card : cards){
            Log.d("DEBUG", "listing cartes");
            nomCartes.add(card.get_pokemon().get_name()+" : "+card.get_id()+"/"+extension.get_max());
        }

        CardsAdapter adapter = new CardsAdapter(this, cards);
        RecyclerView liste = (RecyclerView) findViewById(R.id.list);
        liste.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        liste.setLayoutManager(llm);
    }

    //Permet de retourner à la page d'Accueil lorsque l'on quitte l'activité
    @Override
    public void onPause() {
        super.onPause();

        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }

}

