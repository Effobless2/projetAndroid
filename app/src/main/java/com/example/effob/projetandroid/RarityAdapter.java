package com.example.effob.projetandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by effob on 05/04/2018.
 */


//Classe permettant l'affichage des statistiques par rareté dans les statistiques globales
public class RarityAdapter extends RecyclerView.Adapter<StatItemHolder>{
    private Context context;
    private ArrayList<Rarity> rarities;
    private ArrayList<RelationCardFormat> relations;

    public RarityAdapter(@NonNull Context context, ArrayList<Rarity> rarities, ArrayList<RelationCardFormat> relations) {

        this.context = context;
        this.rarities = rarities;
        this.relations = relations;

    }

    @Override
    public StatItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.global_stats_item,parent, false);
        return new StatItemHolder(v);
    }

    @Override
    public void onBindViewHolder(StatItemHolder holder, int position) {
        Rarity rarity = rarities.get(position);
        holder.titleClass.setText(rarity.get_name());int nb = 0;
        int nbTot = 0;
        for (RelationCardFormat relation : relations){
            if (rarity.get_id() == relation.get_card().get_rarity().get_id()) {
                nbTot++;
                if (relation.isChecked()) {
                    nb++;
                }
            }
        }
        holder.numberCards.setText(nb+"/"+nbTot);
    }

    @Override
    public int getItemCount() {
        return this.rarities.size();
    }
}
