package com.example.effob.projetandroid;

/**
 * Created by effob on 05/04/2018.
 */

public class Type {
    private int id;
    private String name_french;
    private String name_english;

    public static final String DB_TYPE_ID = "id";
    public static final String DB_TYPE_NAME_FR = "name_french";
    public static final String DB_TYPE_NAME_EN = "name_english";

    public Type(String name_english, String name_french){
        this.name_french = name_french;
        this.name_english = name_english;
    }

    public Type(int id, String name_english, String name_french){
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
