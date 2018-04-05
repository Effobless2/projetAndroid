package com.example.effob.projetandroid;

/**
 * Created by effob on 05/04/2018.
 */
//Classe d'une Extension de cartes (ensemble de cartes)
public class Extension {

    private int id;
    private String name_english;
    private String name_french;
    private int numMax;

    //Nom des attributs de la table dans la BD
    public static final String DB_EXTENSION_ID   = "id";
    public static final String DB_EXTENSION_NAME_EN = "name_english";
    public static final String DB_EXTENSION_NAME_FR = "name_french";
    public static final String DB_EXTENSION_MAX  = "numMax";


    public Extension(String name_english, String name_french, int numMax){
        this.name_english = name_english;
        this.name_french = name_french;
        this.numMax = numMax;
    }

    public Extension(int id, String name_english, String name_french, int numMax){
        this(name_english, name_french, numMax);
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

    public int get_max(){
        return this.numMax;
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