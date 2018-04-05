package com.example.effob.projetandroid;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by effob on 05/04/2018.
 */

//Classe de l'item global_stats_item
public class StatItemHolder extends RecyclerView.ViewHolder {
    TextView titleClass;
    TextView numberCards;

    public StatItemHolder(View itemView) {
        super(itemView);
        titleClass = itemView.findViewById(R.id.titleClass);
        numberCards = itemView.findViewById(R.id.numberCards);
    }

}
