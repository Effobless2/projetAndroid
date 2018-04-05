package com.example.effob.projetandroid;

/**
 * Created by effob on 05/04/2018.
 */


//Classe d'une rareté de carte
public class Rarity {

    //Attributs d'une rareté
    private int id;
    private String name_english;
    private String name_french;

    //Attributs de la table dans la base de données
    public static final String DB_RARITY_ID = "id";
    public static final String DB_RARITY_NAME_EN = "name_english";
    public static final String DB_RARITY_NAME_FR = "name_french";

    public Rarity(String name_english, String name_french){
        this.name_english = name_english;
        this.name_french = name_french;
    }

    public Rarity(int id, String name_english, String name_french){
        this(name_english, name_french);
        this.id = id;
    }

    public int get_id(){
        return this.id;
    }

    public String getName_french(){
        return this.name_french;
    }

    public String getName_english(){
        return this.name_english;
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
