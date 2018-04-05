package com.example.effob.projetandroid;

import android.content.Context;
import android.widget.CompoundButton;

/**
 * Created by effob on 05/04/2018.
 */

//Listener des Checkbox affichées dans l'activité activity_extension
public class CheckListenerForFormat implements CompoundButton.OnCheckedChangeListener {
    private DatabaseProvider pokedex;
    private RelationCardFormat relation;

    public CheckListenerForFormat(Context context, RelationCardFormat relation){
        this.relation = relation;
        pokedex = new DatabaseProvider(context);
    }

    //Met à jour la base de données
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b){
            relation.check();
        }
        else{
            relation.unCheck();
        }
        pokedex.updateRelation(relation);
    }
}