package com.apps.v0lture.v0lture_solutions;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by De'Angelo on 1/8/2017.
 */

public class CardAdapter1 extends RecyclerView.Adapter<CardAdapter1.MyViewHolder> {
    public Context mContext;
    private List<Card> cardList1;
    public CardAdapter1(List<Card>cardList1){
        this.cardList1 = cardList1;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView1;
        public TextView title, details;
        public RelativeLayout teamLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            cardView1 = (CardView) itemView.findViewById(R.id.card_view1);
            title = (TextView) itemView.findViewById(R.id.header);
            details = (TextView) itemView.findViewById(R.id.company_about);
            teamLayout = (RelativeLayout)itemView.findViewById(R.id.team_card_layout);
        }
    }
    public CardAdapter1(Context mContext, List<Card> cardList1){
        this.mContext = mContext;
        this.cardList1 = cardList1;
    }
    public CardAdapter1.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.about_card_layout, parent, false);

        return new CardAdapter1.MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final CardAdapter1.MyViewHolder holder, final int position) {
        Card card = cardList1.get(position);
        holder.title.setText(card.getName());
        holder.details.setText(card.getDetails());
        if (position == 0) {
            holder.teamLayout.setBackgroundResource(R.drawable.card2);


        }
    }
@Override
public int getItemCount(){
return cardList1.size();
}
}
