package com.example.effob.projetandroid;

/**
 * Created by effob on 05/04/2018.
 */

//Classe représentant le lien entre une carte et un format
public class RelationCardFormat {

    //Attributs de la classe
    private Card card;
    private Format format;
    private boolean isChecked;

    //Attributs de la table dans la base de données
    public static final String DB_RELATION_CARD = "idCard";
    public static final String DB_RELATION_EXTENSION = "idExtension";
    public static final String DB_RELATION_FORMAT = "idFormat";
    public static final String DB_RELATION_CHECK = "isChecked";

    public RelationCardFormat(Card card, Format format){
        this.card = card;
        this.format = format;
    }

    public RelationCardFormat(Card card, Format format, boolean isChecked){
        this(card, format);
        this.isChecked = isChecked;
    }

    public Card get_card(){
        return this.card;
    }

    public Format get_format(){
        return this.format;
    }

    public boolean isChecked(){
        return this.isChecked;
    }

    public void check(){
        this.isChecked = true;
    }

    public void unCheck(){
        this.isChecked = false;
    }
}
