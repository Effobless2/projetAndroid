package com.example.effob.projetandroid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.ArrayList;

/**
 * Created by effob on 05/04/2018.
 */

//Classe permettant la gestion de l'affichage des différentes cartes dans l'activité activity_extension
public class CardsAdapter extends RecyclerView.Adapter<CardHolder> {
    Context context;
    ArrayList<Card> cards;

    //Constructeur
    public CardsAdapter(Context context, ArrayList<Card> cards) {
        this.context = context;
        this.cards = cards;
    }

    //Création de la view Item
    @Override
    public CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_list_item,parent, false);
        return new CardHolder(v);
    }

    //Initialisation des attributs de la view Item
    @Override
    public void onBindViewHolder(CardHolder holder, int position) {
        Card c = cards.get(position);
        holder.nameCard.setText(c.get_pokemon().get_name());
        holder.numCard.setText(c.get_id()+"/"+c.get_extension().get_max());
        holder.formats.removeAllViews();

        //Affichage des checkboxs pour chaque formats de la cartes disponibles
        for (RelationCardFormat relation: c.get_formats()){
            if (holder.formats.getChildCount() < c.get_formats().size()) {
                Log.d("DEBUG", "Check : " + relation.get_format());
                CheckBox checkbox = new CheckBox(context);
                checkbox.setOnCheckedChangeListener(new CheckListenerForFormat(context, relation));
                checkbox.setText(relation.get_format().get_name());
                checkbox.setChecked(relation.isChecked());
                holder.formats.addView(checkbox);
            }
            else{
                break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

}
