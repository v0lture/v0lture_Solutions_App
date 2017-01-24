package com.apps.v0lture.v0lture_solutions;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by De'Angelo on 1/8/2017.
 */

public class CardAdapter2 extends RecyclerView.Adapter<CardAdapter2.MyViewHolder> {
    private Context mContext;
    private List<Card> cardList2;
    public CardAdapter2(List<Card>cardList2){
        this.cardList2 = cardList2;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView2;
        public ImageView thumbnail;
        public TextView title, details;
        public RelativeLayout teamLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            cardView2 = (CardView) itemView.findViewById(R.id.card_view1);
            //thumbnail = (ImageView) itemView.findViewById(R.id.profile_my);
            title = (TextView) itemView.findViewById(R.id.header);
            details = (TextView) itemView.findViewById(R.id.company_about);
            teamLayout = (RelativeLayout)itemView.findViewById(R.id.team_card_layout);
        }
    }
    public CardAdapter2(Context mContext, List<Card> cardList2){
        this.mContext = mContext;
        this.cardList2 = cardList2;
    }
    public CardAdapter2.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.about_card_layout, parent, false);

        return new CardAdapter2.MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final CardAdapter2.MyViewHolder holder, final int position) {
        Card cards= cardList2.get(position);
        holder.title.setText(cards.getName());
        holder.details.setText(cards.getDetails());
        //holder.thumbnail.setImageResource(cards.getThumbnail());

        if (position == 0) {
            holder.teamLayout.setBackgroundResource(R.drawable.card3);
            holder.title.setTextSize(18);

        }
        else if (position == 1) {
            holder.teamLayout.setBackgroundResource(R.drawable.card3);
            holder.title.setTextSize(18);
        }
        else if (position == 2) {
            holder.teamLayout.setBackgroundResource(R.drawable.card3);
            holder.title.setTextSize(18);


        }
        else if (position == 3) {
            holder.teamLayout.setBackgroundResource(R.drawable.card3);
            holder.title.setTextSize(18);
        }
        else if (position == 4) {
            holder.teamLayout.setBackgroundResource(R.drawable.card3);
            holder.title.setTextSize(18);
        }
        else if (position == 5) {
            holder.teamLayout.setBackgroundResource(R.drawable.card3);
            holder.title.setTextSize(18);
        } else if (position == 6) {
            holder.teamLayout.setBackgroundResource(R.drawable.card3);
            holder.title.setTextSize(12);

        } else if (position == 7) {
            holder.teamLayout.setBackgroundResource(R.drawable.card3);
            holder.title.setTextSize(12);

        } else if (position == 8) {
            holder.teamLayout.setBackgroundResource(R.drawable.card3);
            holder.title.setTextSize(12);

        } else if (position == 9) {
            holder.teamLayout.setBackgroundResource(R.drawable.card3);
            holder.title.setTextSize(12);

        } else if (position == 10) {
            holder.teamLayout.setBackgroundResource(R.drawable.card3);
            holder.title.setTextSize(12);

        } else if (position == 11) {
            holder.teamLayout.setBackgroundResource(R.drawable.card3);
            holder.title.setTextSize(12);

        }
    }
    @Override
    public int getItemCount(){
        return cardList2.size();
    }
}
