package com.example.effob.projetandroid;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by effob on 05/04/2018.
 */

//classe des attributs de l'Item
public class CardHolder extends RecyclerView.ViewHolder{

    TextView nameCard;
    TextView numCard;
    LinearLayout formats;

    public CardHolder(View itemView) {
        super(itemView);
        nameCard = itemView.findViewById(R.id.nameCard);
        numCard = itemView.findViewById(R.id.numCard);
        formats = itemView.findViewById(R.id.formats);
    }


}