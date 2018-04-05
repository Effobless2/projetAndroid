package com.example.effob.projetandroid;

/**
 * Created by effob on 05/04/2018.
 */


//Classe d'un Pokémon
class Pokemon {

    //Attributs d'un pokémon
    private int     id;
    private String  name_english;
    private String  name_french;
    private Integer numPokedex = 0;

    //Nom des Attributs de la table dans la base de données
    public static final String DB_POKEMON_ID = "id";
    public static final String DB_POKEMON_NAME_EN = "name_english";
    public static final String DB_POKEMON_NAME_FR = "name_french";
    public static final String DB_POKEMON_NUM = "numPokedex";

    public Pokemon(String name_english, String name_french){
        this.name_english = name_english;
        this.name_french = name_french;
    }

    public Pokemon(String name_english, String name_french,  int numPokedex){
        this(name_english, name_french);
        this.numPokedex = numPokedex;
    }

    public Pokemon(String name_english, String name_french, int id, int numPokedex){
        this(name_english, name_french, numPokedex);
        this.id         = id;
    }

    public int get_id(){
        return this.id;
    }

    public String getName_english(){
        return this.name_english;
    }

    public String getName_french(){
        return this.name_french;
    }

    public int get_num(){
        return this.numPokedex;
    }

    public void set_id(int newId){
        this.id = newId;
    }

    public String get_name(){
        if (Main.lang.equals("fr")){
            return this.getName_french();
        }
        else{
            return this.getName_english();
        }
    }
}
