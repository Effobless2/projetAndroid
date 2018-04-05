package com.example.effob.projetandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by effob on 05/04/2018.
 */


//Classe permettant la présentation desq statistiques d'obtention des cartes pour chaque format existant
public class FormatAdapter extends RecyclerView.Adapter<StatItemHolder> {
    private Context context;
    private ArrayList<Format> formats;
    private ArrayList<RelationCardFormat> relations;

    public FormatAdapter(@NonNull Context context, ArrayList<Format> formats, ArrayList<RelationCardFormat> relations) {
        this.context = context;
        this.formats = formats;
        this.relations = relations;

    }

    //Création de la view Item
    @Override
    public StatItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.global_stats_item,parent, false);
        return new StatItemHolder(v);
    }

    //Remplissage de l'itemView
    @Override
    public void onBindViewHolder(StatItemHolder holder, int position) {
        Format format = formats.get(position);
        holder.titleClass.setText(format.get_name());

        int nbTot = 0;
        int nb = 0;
        for (RelationCardFormat relation : relations){
            Log.d("DEBUG","Boucle");
            if (format.get_id() == relation.get_format().get_id()) {
                nbTot++;
                if (relation.isChecked()) {
                    nb++;
                }
            }
        }

        Log.d("DEBUG",nb+"");
        holder.numberCards.setText(nb+"/"+nbTot);

    }

    @Override
    public int getItemCount() {
        return this.formats.size();
    }

    //Classe de l'Item global_stats_item
    static class FormatHolder
    {
        TextView titleClass;
        TextView numberCards;
    }
}
