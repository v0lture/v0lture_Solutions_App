package com.apps.v0lture.v0lture_solutions;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
 * Created by De'Angelo on 1/4/2017.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder> {
    private Context mContext;
    private List<Card> cardList;

    public List<Card> cardList2;
    public CardAdapter(List<Card>cardList){
        this.cardList = cardList;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView, cardView1, cardView2;
        public TextView title, version, details;
        public ImageView  profile;
        public RelativeLayout cardLayout;
        public MyViewHolder(final View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.card_view);
            cardView1 = (CardView)itemView.findViewById(R.id.card_view1);
            cardView2 = (CardView)itemView.findViewById(R.id.card_view1);
            title = (TextView) itemView.findViewById(R.id.top_left_text);
            details = (TextView) itemView.findViewById(R.id.bottom_text);
            version = (TextView) itemView.findViewById(R.id.top_right_text);
           // profile = (ImageView) itemView.findViewById(R.id.profile_my);
            cardLayout = (RelativeLayout) itemView.findViewById(R.id.color_layout);

        }
    }
    public void setClickListener(ClickListener clickListener){
       ClickListener clicklistener = clickListener;
    }
    public CardAdapter(Context mContext, List<Card> cardList){
        this.mContext = mContext;
        this.cardList = cardList;
    }

    @Override
    public CardAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CardAdapter.MyViewHolder holder, final int position) {
        Card card = cardList.get(position);
        holder.title.setText(card.getName());
        holder.details.setText(card.getDetails());
        holder.version.setText(card.getVersion());
        if(position==0)
            holder.cardLayout.setBackgroundColor(Color.parseColor("#FF9334AF"));

        else if(position==1) {
            holder.cardLayout.setBackgroundColor(Color.parseColor("#2E7D32"));
            holder.title.setTextColor(Color.BLACK);
            holder.details.setTextColor(Color.BLACK);
            holder.version.setTextColor(Color.BLACK);
        }else if(position==2) {
            holder.cardLayout.setBackgroundColor(Color.parseColor("#FF020202"));
        }else if(position==3) {
            holder.cardLayout.setBackgroundColor(Color.parseColor("#FF1B77D2"));
        }else if(position==4) {
            holder.cardLayout.setBackgroundColor(Color.parseColor("#FFF44437"));
        }else if(position==5) {
            holder.cardLayout.setBackgroundColor(Color.parseColor("#FF7A5649"));

        }
        if(position==0){
            holder.cardLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= (new Intent(view.getContext(), DB.class));
                    mContext.startActivity(intent);
                }
            });
        }
        if(position==1){
            holder.cardLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= (new Intent(view.getContext(), MyMu.class));
                    mContext.startActivity(intent);
                }
            });
        }
        if(position==2){
            holder.cardLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= (new Intent(view.getContext(), VOS.class));
                    mContext.startActivity(intent);
                }
            });
        }
        if(position==3){
            holder.cardLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= (new Intent(view.getContext(), VBugs.class));
                    mContext.startActivity(intent);
                }
            });
        }
        if(position==4){
            holder.cardLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= (new Intent(view.getContext(), Veddit.class));
                    mContext.startActivity(intent);
                }
            });
        }
        if(position==5){
            holder.cardLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= (new Intent(view.getContext(), VPolice.class));
                    mContext.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }
}
