package com.example.effob.projetandroid;

/**
 * Created by effob on 05/04/2018.
 */


//Classe des différents formats d'une carte.
public class Format {

    //Attributs du format
    private int id;
    private String name_english;
    private String name_french;

    //Nom des Attributs de la table Format dans la base de données
    public static final String DB_FORMAT_ID = "id";
    public static final String DB_FORMAT_NAME_EN = "name_english";
    public static final String DB_FORMAT_NAME_FR = "name_french";

    public Format(String name_english, String name_french){
        this.name_english = name_english;
        this.name_french = name_french;
    }

    public Format(int id, String name_english, String name_french){
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
