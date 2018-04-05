package com.example.effob.projetandroid;

import java.util.ArrayList;

/**
 * Created by effob on 05/04/2018.
 */

//Classe d'une carte pokémon
public class Card {

    //Attributs de la carte
    private String idCard;  //idCard est un string en prévision des id SH+x de la 3ème génération
    private Extension extension;
    private Rarity rarity;
    private Type type;
    private Pokemon pokemon;
    private ArrayList<RelationCardFormat> formats;

    //Nom des attributs de la table dans la BD
    public static final String DB_CARD_ID = "idCard";
    public static final String DB_CARD_POKEMON = "idPokemon";
    public static final String DB_CARD_EXTENSION = "idExtension";
    public static final String DB_CARD_RARITY = "idRarity";
    public static final String DB_CARD_TYPE = "idType";

    public Card(Extension extension, String idCard){
        this.extension   = extension;
        this.idCard      = idCard;
        this.formats     = new ArrayList<>();
    }

    public Card(Extension extension, String idCard, Pokemon pokemon, Rarity rarity, Type type){
        this(extension, idCard);
        this.pokemon = pokemon;
        this.rarity  = rarity;
        this.type    = type;
    }

    public String get_id(){
        return this.idCard;
    }

    public Extension get_extension(){
        return this.extension;
    }

    public Rarity get_rarity(){
        return this.rarity;
    }

    public Type get_type(){
        return this.type;
    }

    public Pokemon get_pokemon(){
        return this.pokemon;
    }

    public ArrayList<RelationCardFormat> get_formats(){ return this.formats; }

    public void setExtension(Extension extension){
        this.extension = extension;
    }

    public void addFormat(RelationCardFormat format){
        this.formats.add(format);
    }


}