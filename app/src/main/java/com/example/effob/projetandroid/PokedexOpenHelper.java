package com.example.effob.projetandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by effob on 05/04/2018.
 */

//Classe aidant la manipulation de la base de données.
public class PokedexOpenHelper extends SQLiteOpenHelper {

    //Ensemble des noms des tables
    private static final String DB_NAME         = "POKEDEX";
    private static final String DB_TABLE_NAME_1 = "POKEMON";
    private static final String DB_TABLE_NAME_2 = "TYPE";
    private static final String DB_TABLE_NAME_3 = "RARITY";
    private static final String DB_TABLE_NAME_4 = "EXTENSION";
    private static final String DB_TABLE_NAME_5 = "CARD";
    private static final String DB_TABLE_NAME_6 = "FORMAT";
    private static final String DB_TABLE_NAME_7 = "RELATION_CARD_FORMAT";


    private Context context;

    public PokedexOpenHelper(Context context){
        super(context, DB_NAME, null, 2);
        this.context = context;
    }

    //Création de la base de données et remplissage via Enregistrement.class
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(
                "create table "+DB_TABLE_NAME_1 +" (                     " +
                        Pokemon.DB_POKEMON_ID   +" integer primary key  ," +
                        Pokemon.DB_POKEMON_NAME_FR +" text    not null  ," +
                        Pokemon.DB_POKEMON_NAME_EN +" text    not null  ," +
                        Pokemon.DB_POKEMON_NUM  +"  integer            );"
        );
        database.execSQL(
                "create table "+DB_TABLE_NAME_2 +" (                     " +
                        Type.DB_TYPE_ID         +" integer primary key  ," +
                        Type.DB_TYPE_NAME_EN       +" text    not null  ," +
                        Type.DB_TYPE_NAME_FR       +" text    not null );"
        );
        database.execSQL(
                "create table "+DB_TABLE_NAME_3 +" (                     " +
                        Rarity.DB_RARITY_ID     +" integer primary key  ," +
                        Rarity.DB_RARITY_NAME_FR   +" text    not null  ," +
                        Rarity.DB_RARITY_NAME_EN   +" text    not null );"
        );

        database.execSQL(
                "create table "+DB_TABLE_NAME_4     +" (                     " +
                        Extension.DB_EXTENSION_ID   +" integer primary key  ," +
                        Extension.DB_EXTENSION_NAME_FR +" text    not null  ," +
                        Extension.DB_EXTENSION_NAME_EN +" text    not null  ," +
                        Extension.DB_EXTENSION_MAX  +" integer             );"
        );

        database.execSQL(
                "create table "+DB_TABLE_NAME_5+" (                                                                                  " +
                        Card.DB_CARD_POKEMON   +"  integer                                                                          ," +
                        Card.DB_CARD_ID        +"  text                                                                             ," +
                        Card.DB_CARD_EXTENSION +"  integer                                                                          ," +
                        Card.DB_CARD_RARITY    +"  integer                                                                          ," +
                        Card.DB_CARD_TYPE      +"  integer                                                                          ," +
                        "primary key ("+Card.DB_CARD_ID       +","+ Card.DB_CARD_EXTENSION                                      +") ," +
                        "foreign key ("+Card.DB_CARD_POKEMON  +") references "+ DB_TABLE_NAME_1 +"("+ Pokemon.DB_POKEMON_ID     +") ," +
                        "foreign key ("+Card.DB_CARD_TYPE     +") references "+ DB_TABLE_NAME_2 +"("+ Type.DB_TYPE_ID           +") ," +
                        "foreign key ("+Card.DB_CARD_RARITY   +") references "+ DB_TABLE_NAME_3 +"("+ Rarity.DB_RARITY_ID       +") ," +
                        "foreign key ("+Card.DB_CARD_EXTENSION+") references "+ DB_TABLE_NAME_4 +"("+ Extension.DB_EXTENSION_ID +"));"
        );

        database.execSQL(
                "create table "+DB_TABLE_NAME_6+"   (" +
                        Format.DB_FORMAT_ID    +" integer primary key ," +
                        Format.DB_FORMAT_NAME_FR  +" text             ," +
                        Format.DB_FORMAT_NAME_EN  +" text            );"
        );

        database.execSQL(
                "create table "+DB_TABLE_NAME_7                  +" (                                                                                   " +
                        RelationCardFormat.DB_RELATION_CARD      +" integer                                                                            ," +
                        RelationCardFormat.DB_RELATION_EXTENSION +" integer                                                                            ," +
                        RelationCardFormat.DB_RELATION_FORMAT    +" integer                                                                            ," +
                        RelationCardFormat.DB_RELATION_CHECK     +" boolean                                                                            ," +
                        "primary key (                                                                                                                  " +
                        RelationCardFormat.DB_RELATION_CARD      +"                                                                                ," +
                        RelationCardFormat.DB_RELATION_EXTENSION +"                                                                                ," +
                        RelationCardFormat.DB_RELATION_FORMAT    +")                                                                               ," +
                        "foreign key ("+RelationCardFormat.DB_RELATION_CARD      +") references "+ DB_TABLE_NAME_5 +"("+ Card.DB_CARD_ID           +") ," +
                        "foreign key ("+RelationCardFormat.DB_RELATION_EXTENSION +") references "+ DB_TABLE_NAME_5 +"("+ Extension.DB_EXTENSION_ID +") ," +
                        "foreign key ("+RelationCardFormat.DB_RELATION_FORMAT    +") references "+ DB_TABLE_NAME_6 +"("+ Format.DB_FORMAT_ID       +"));"
        );
        new Enregistrements(this, database);
        Log.d("DATABASE", "Base crée");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

    public void addPokemon(SQLiteDatabase database, Pokemon pokemon){
        ContentValues content = new ContentValues();
        content.put(Pokemon.DB_POKEMON_ID, pokemon.get_id());
        content.put(Pokemon.DB_POKEMON_NAME_EN, pokemon.getName_english());
        content.put(Pokemon.DB_POKEMON_NAME_FR, pokemon.getName_french());
        content.put(Pokemon.DB_POKEMON_NUM, pokemon.get_num());
        database.insert(DB_TABLE_NAME_1, null, content);
    }

    public void addType(SQLiteDatabase database, Type type){
        ContentValues content = new ContentValues();
        content.put(Type.DB_TYPE_ID, type.get_id());
        content.put(Type.DB_TYPE_NAME_EN, type.getName_english());
        content.put(Type.DB_TYPE_NAME_FR, type.getName_french());
        database.insert(DB_TABLE_NAME_2,null, content);
    }

    public void addRarity(SQLiteDatabase database, Rarity rarity){
        ContentValues content = new ContentValues();
        content.put(Rarity.DB_RARITY_ID, rarity.get_id());
        content.put(Rarity.DB_RARITY_NAME_EN, rarity.getName_english());
        content.put(Rarity.DB_RARITY_NAME_FR, rarity.getName_french());
        database.insert(DB_TABLE_NAME_3, null, content);
    }

    public void addExtension(SQLiteDatabase database, Extension extension){
        ContentValues content = new ContentValues();
        content.put(Extension.DB_EXTENSION_ID, extension.get_id());
        content.put(Extension.DB_EXTENSION_NAME_EN, extension.getName_english());
        content.put(Extension.DB_EXTENSION_NAME_FR, extension.getName_french());
        content.put(Extension.DB_EXTENSION_MAX, extension.get_max());
        database.insert(DB_TABLE_NAME_4, null, content);
    }

    public void addFormat(SQLiteDatabase database, Format format){
        ContentValues content = new ContentValues();
        content.put(Format.DB_FORMAT_ID, format.get_id());
        content.put(Format.DB_FORMAT_NAME_EN, format.getName_english());
        content.put(Format.DB_FORMAT_NAME_FR, format.getName_french());
        database.insert(DB_TABLE_NAME_6, null, content);
    }

    public void addCard(SQLiteDatabase database, Card card){
        ContentValues content = new ContentValues();
        content.put(Card.DB_CARD_ID, card.get_id());
        content.put(Card.DB_CARD_POKEMON, card.get_pokemon().get_id());
        content.put(Card.DB_CARD_EXTENSION, card.get_extension().get_id());
        content.put(Card.DB_CARD_RARITY, card.get_rarity().get_id());
        content.put(Card.DB_CARD_TYPE, card.get_type().get_id());
        database.insert(DB_TABLE_NAME_5, null, content);
    }

    public void addRelation(SQLiteDatabase database, RelationCardFormat relation){
        ContentValues content = new ContentValues();
        content.put(RelationCardFormat.DB_RELATION_CARD, relation.get_card().get_id());
        content.put(RelationCardFormat.DB_RELATION_EXTENSION, relation.get_card().get_extension().get_id());
        content.put(RelationCardFormat.DB_RELATION_FORMAT, relation.get_format().get_id());
        content.put(RelationCardFormat.DB_RELATION_CHECK, false);
        database.insert(DB_TABLE_NAME_7, null, content);
    }


    public Extension getExtensionById(SQLiteDatabase database, int idExtension){
        Extension res = null;
        String[] columns = {Extension.DB_EXTENSION_ID, Extension.DB_EXTENSION_NAME_EN, Extension.DB_EXTENSION_NAME_FR, Extension.DB_EXTENSION_MAX};
        // Exécution de la requête pour obtenir les chaînes et récupération d'un curseur sur ces données.
        Cursor cursor = database.query(DB_TABLE_NAME_4, columns, null, null, null, null, null);
        // Curseur placé en début des chaînes récupérées.
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            // Récupération d'une chaîne et insertion dans une liste.
            if (cursor.getInt(0) == idExtension){
                res = new Extension(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
                break;
            }
            // Passage à l'entrée suivante.
            else{
                cursor.moveToNext();
            }
        }
        cursor.close();
        return res;
    }

    public Rarity getRarityById(SQLiteDatabase database,int idRarity){
        Rarity res = null;
        String[] columns = {Rarity.DB_RARITY_ID, Rarity.DB_RARITY_NAME_EN, Rarity.DB_RARITY_NAME_FR};
        // Exécution de la requête pour obtenir les chaînes et récupération d'un curseur sur ces données.
        Cursor cursor = database.query(DB_TABLE_NAME_3, columns, null, null, null, null, null);
        // Curseur placé en début des chaînes récupérées.
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            // Récupération d'une chaîne et insertion dans une liste.
            if (cursor.getInt(0)==idRarity) {
                res = new Rarity(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
                break;
            }
            // Passage à l'entrée suivante.
            else{
                cursor.moveToNext();
            }
        }
        cursor.close();
        return res;
    }

    public Type getTypeById(SQLiteDatabase database, int idType){
        Type res = null;
        String[] columns = {Type.DB_TYPE_ID, Type.DB_TYPE_NAME_EN, Type.DB_TYPE_NAME_FR};
        // Exécution de la requête pour obtenir les chaînes et récupération d'un curseur sur ces données.
        Cursor cursor = database.query(DB_TABLE_NAME_2, columns, null, null, null, null, null);
        // Curseur placé en début des chaînes récupérées.
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            // Récupération d'une chaîne et insertion dans une liste.
            if (cursor.getInt(0)==idType) {
                res = new Type(cursor.getInt(0), cursor.getString(2), cursor.getString(1));
                break;
            }
            // Passage à l'entrée suivante.
            else{
                cursor.moveToNext();
            }
        }
        cursor.close();
        return res;
    }

    public Pokemon getPokemonById(SQLiteDatabase database, int idPokemon){
        Pokemon res = null;
        String[] columns = {Pokemon.DB_POKEMON_ID, Pokemon.DB_POKEMON_NAME_EN, Pokemon.DB_POKEMON_NAME_FR, Pokemon.DB_POKEMON_NUM};
        // Exécution de la requête pour obtenir les chaînes et récupération d'un curseur sur ces données.
        Cursor cursor = database.query(DB_TABLE_NAME_1, columns, null, null, null, null, null);
        // Curseur placé en début des chaînes récupérées.
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            // Récupération d'une chaîne et insertion dans une liste.
            if (cursor.getInt(0)==idPokemon) {
                res = new Pokemon(cursor.getString(1), cursor.getString(2), cursor.getInt(0));
                break;
            }
            // Passage à l'entrée suivante.
            else{
                cursor.moveToNext();
            }
        }
        cursor.close();
        return res;
    }

    public Format getFormatById(SQLiteDatabase database, int idFormat) {
        Format res = null;
        String[] columns = {Format.DB_FORMAT_ID, Format.DB_FORMAT_NAME_EN, Format.DB_FORMAT_NAME_FR};
        // Exécution de la requête pour obtenir les chaînes et récupération d'un curseur sur ces données.
        Cursor cursor = database.query(DB_TABLE_NAME_6, columns, null, null, null, null, null);
        // Curseur placé en début des chaînes récupérées.
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            // Récupération d'une chaîne et insertion dans une liste.
            if (cursor.getInt(0) == idFormat){
                res = new Format(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
                break;
            }
            // Passage à l'entrée suivante.
            else{
                cursor.moveToNext();
            }
        }
        cursor.close();
        return res;
    }

    //retourne la carte ayant l'id idCard et appartenant à l'extension avec l'id idExtension
    private Card getCardByExtensionAndId(SQLiteDatabase database, String idCard, int idExtension) {
        Card res = null;
        String[] columns = {Card.DB_CARD_ID, Card.DB_CARD_EXTENSION, Card.DB_CARD_POKEMON, Card.DB_CARD_RARITY, Card.DB_CARD_TYPE};

        // Exécution de la requête pour obtenir les chaînes et récupération d'un curseur sur ces données.
        Cursor cursor = database.query(DB_TABLE_NAME_5, columns, null, null, null, null, null);
        // Curseur placé en début des chaînes récupérées.
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            // Récupération d'une chaîne et insertion dans une liste.
            if (cursor.getString(0).equals(idCard) && cursor.getInt(1) == idExtension){
                res = new Card(getExtensionById(database, cursor.getInt(1)),
                        cursor.getString(0),
                        getPokemonById(database, cursor.getInt(2)),
                        getRarityById(database, cursor.getInt(3)),
                        getTypeById(database, cursor.getInt(4))
                );
                break;
            }
            // Passage à l'entrée suivante.
            else{
                cursor.moveToNext();
            }
        }
        cursor.close();
        return res;
    }


    public ArrayList<RelationCardFormat> getAllRelationFormatByCard(SQLiteDatabase database, Card card){
        ArrayList<RelationCardFormat> res = new ArrayList<>();
        String[] columns = {RelationCardFormat.DB_RELATION_EXTENSION, RelationCardFormat.DB_RELATION_CARD, RelationCardFormat.DB_RELATION_FORMAT, RelationCardFormat.DB_RELATION_CHECK};
        Cursor cursor = database.query(DB_TABLE_NAME_7, columns, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            if (card.get_id().equals(cursor.getString(1)) && card.get_extension().get_id() == cursor.getInt(0)) {
                res.add(new RelationCardFormat(card, getFormatById(database, cursor.getInt(2)), cursor.getInt(3) > 0));
            }
            cursor.moveToNext();
        }
        cursor.close();
        return res;

    }

    public ArrayList<Card> getAllCardByExt(SQLiteDatabase database, Extension extension){
        ArrayList<Card> res = new ArrayList<Card>();
        String[] columns = {Card.DB_CARD_ID, Card.DB_CARD_POKEMON, Card.DB_CARD_EXTENSION, Card.DB_CARD_TYPE, Card.DB_CARD_RARITY};
        // Exécution de la requête pour obtenir les chaînes et récupération d'un curseur sur ces données.
        Cursor cursor = database.query(DB_TABLE_NAME_5, columns, null, null, null, null, null);
        // Curseur placé en début des chaînes récupérées.
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            // Récupération d'une chaîne et insertion dans une liste.
            Log.d("find in base", getPokemonById(database,cursor.getInt(1)).getName_french());
            if (cursor.getInt(2)==extension.get_id()) {
                Card card = new Card(extension, cursor.getString(0), getPokemonById(database, cursor.getInt(1)), getRarityById(database, cursor.getInt(3)), getTypeById(database, cursor.getInt(2)));
                res.add(card);
            }
            // Passage à l'entrée suivante.
            cursor.moveToNext();
        }
        cursor.close();


        for (Card card : res) {
            for (RelationCardFormat relation : getAllRelationFormatByCard(database, card)){
                card.addFormat(relation);
            }
            Log.d("cartes sdb", card.get_id()+" : "+card.get_pokemon().getName_french());
        }
        return res;
    }

    public ArrayList<Extension> getAllExtensions(SQLiteDatabase database) {
        ArrayList<Extension> res = new ArrayList<>();
        String[] columns = {Extension.DB_EXTENSION_ID, Extension.DB_EXTENSION_NAME_EN, Extension.DB_EXTENSION_NAME_FR, Extension.DB_EXTENSION_MAX};
        Cursor cursor = database.query(DB_TABLE_NAME_4, columns, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            res.add(new Extension(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3)));
            cursor.moveToNext();
        }
        cursor.close();
        return res;
    }

    public ArrayList<Format> getAllFormats(SQLiteDatabase database){
        ArrayList<Format> res = new ArrayList<>();
        String[] columns = {Format.DB_FORMAT_ID, Format.DB_FORMAT_NAME_EN, Format.DB_FORMAT_NAME_FR};
        Cursor cursor = database.query(DB_TABLE_NAME_6, columns, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            res.add(new Format(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            cursor.moveToNext();
        }
        cursor.close();
        return res;
    }

    public ArrayList<Pokemon> getAllPokemon(SQLiteDatabase database){
        ArrayList<Pokemon> res = new ArrayList<Pokemon>();
        String[] columns = {Pokemon.DB_POKEMON_ID, Pokemon.DB_POKEMON_NAME_FR, Pokemon.DB_POKEMON_NAME_EN, Pokemon.DB_POKEMON_NUM};
        Cursor cursor = database.query(DB_TABLE_NAME_1, columns, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Pokemon pokemon = new Pokemon(cursor.getString(2), cursor.getString(1), cursor.getInt(0), cursor.getInt(3));
            res.add(pokemon);
            cursor.moveToNext();
        }
        cursor.close();
        return res;
    }

    public ArrayList<Rarity> getAllRarities(SQLiteDatabase database) {
        ArrayList<Rarity> res = new ArrayList<Rarity>();
        String[] columns = {Rarity.DB_RARITY_ID, Rarity.DB_RARITY_NAME_EN, Rarity.DB_RARITY_NAME_FR};
        Cursor cursor = database.query(DB_TABLE_NAME_3, columns, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Rarity rarity = new Rarity(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            res.add(rarity);
            cursor.moveToNext();
        }
        cursor.close();
        return res;
    }

    public ArrayList<RelationCardFormat> getAllRelations(SQLiteDatabase database) {
        ArrayList<RelationCardFormat> res = new ArrayList<RelationCardFormat>();
        String[] columns = {RelationCardFormat.DB_RELATION_CARD, RelationCardFormat.DB_RELATION_EXTENSION, RelationCardFormat.DB_RELATION_FORMAT, RelationCardFormat.DB_RELATION_CHECK};
        Cursor cursor = database.query(DB_TABLE_NAME_7, columns, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            RelationCardFormat relation = new RelationCardFormat(getCardByExtensionAndId(database, cursor.getString(0), cursor.getInt(1)),
                    getFormatById(database, cursor.getInt(2)),
                    cursor.getInt(3)>0);
            res.add(relation);
            cursor.moveToNext();
        }
        cursor.close();
        return res;
    }


    //Met à jour la base de donnée si la cartes relation.card au format relation.format a été obtenue ou retirée de la collection
    public void updateRelation(SQLiteDatabase database, RelationCardFormat relation) {
        ContentValues content = new ContentValues();
        content.put(RelationCardFormat.DB_RELATION_CHECK, relation.isChecked());
        String[] values = {relation.get_card().get_id(),relation.get_card().get_extension().get_id()+"",relation.get_format().get_id()+""};
        database.update(DB_TABLE_NAME_7, content,
                RelationCardFormat.DB_RELATION_CARD     +" = ? AND "+
                        RelationCardFormat.DB_RELATION_EXTENSION+" = ? AND "+
                        RelationCardFormat.DB_RELATION_FORMAT   +" = ?",
                values);
    }


    public ArrayList<Type> getAllTypes(SQLiteDatabase database) {
        ArrayList<Type> res = new ArrayList<Type>();
        String[] columns = {Type.DB_TYPE_ID, Type.DB_TYPE_NAME_EN, Type.DB_TYPE_NAME_FR};
        Cursor cursor = database.query(DB_TABLE_NAME_2, columns, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Type type = new Type(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            res.add(type);
            cursor.moveToNext();
        }
        cursor.close();
        return res;
    }

    public ArrayList<RelationCardFormat> getAllrelationsByExt(SQLiteDatabase database, Extension extension) {
        ArrayList<RelationCardFormat> res = new ArrayList<>();
        String[] columns = {RelationCardFormat.DB_RELATION_CARD, RelationCardFormat.DB_RELATION_EXTENSION,  RelationCardFormat.DB_RELATION_FORMAT, RelationCardFormat.DB_RELATION_CHECK};
        Cursor cursor = database.query(DB_TABLE_NAME_7, columns, null, null, null, null, null);
        cursor.moveToFirst();
        while( !cursor.isAfterLast()){
            if (cursor.getInt(1) == extension.get_id()){
                res.add(new RelationCardFormat(this.getCardByExtensionAndId(database, cursor.getString(0), cursor.getInt(1)), getFormatById(database, cursor.getInt(2)), cursor.getInt(3)>0));
            }
            cursor.moveToNext();
        }
        cursor.close();
        return res;
    }
}
