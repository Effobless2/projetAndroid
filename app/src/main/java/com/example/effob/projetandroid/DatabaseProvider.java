package com.example.effob.projetandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by effob on 05/04/2018.
 */
//Gestionnaire de base de données
public class DatabaseProvider {
    public PokedexOpenHelper helper;
    public SQLiteDatabase database;

    public DatabaseProvider(Context context){
        this.helper   = new PokedexOpenHelper(context);
        this.database = this.helper.getWritableDatabase();

        Log.d("DATABASE", "Extension Crée");
    }

    public ArrayList<Pokemon> getAllPokemon(){
        return this.helper.getAllPokemon(this.database);
    }

    public ArrayList<Extension> getAllExtension(){return this.helper.getAllExtensions(this.database);}

    public Extension getExtensionById(int id){return this.helper.getExtensionById(this.database, id);}


    public ArrayList<Card> getAllCardByExtension(Extension extension) {return this.helper.getAllCardByExt(this.database, extension);}

    public ArrayList<RelationCardFormat> getAllRelations() {return this.helper.getAllRelations(this.database);}

    public ArrayList<Rarity> getAllRarities() {
        return this.helper.getAllRarities(this.database);
    }

    public ArrayList<Format> getAllFormats() {return this.helper.getAllFormats(this.database);}


    public void updateRelation(RelationCardFormat relation) { this.helper.updateRelation(this.database, relation);}

    public ArrayList<Type> getAllTypes() {
        return this.helper.getAllTypes(this.database);
    }

    public ArrayList<RelationCardFormat> getAllRelationsByExt(Extension extension) { return this.helper.getAllrelationsByExt(this.database, extension);}
}
