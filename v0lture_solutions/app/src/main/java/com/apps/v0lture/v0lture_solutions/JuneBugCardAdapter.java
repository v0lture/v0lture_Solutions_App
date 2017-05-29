package com.apps.v0lture.v0lture_solutions;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
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
 * Created by De'Angelo Grant on 5/28/2017.
 */

public class JuneBugCardAdapter extends RecyclerView.Adapter<JuneBugCardAdapter.MyViewHolder>{
    private List<Issues> cards;
    public JuneBugCardAdapter(List<Issues>cards){
        this.cards = cards;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView;
        public ImageView status, account, project, time;
        public TextView title, description, txtstatus, txtaccount, txtproject, txttime;
        public RelativeLayout IssueLayout;

        public MyViewHolder(View itemView){
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.issues_Cardview);
            description = (TextView) itemView.findViewById(R.id.textViewDescription);
            txtstatus = (TextView) itemView.findViewById(R.id.textViewStatus);
            txtaccount = (TextView) itemView.findViewById(R.id.textViewAuthor);
            txtproject = (TextView) itemView.findViewById(R.id.textViewProject);
            txttime = (TextView) itemView.findViewById(R.id.textViewDays);
            title = (TextView) itemView.findViewById(R.id.textViewTitle);
        }
    }
    public JuneBugCardAdapter(Context mcontext, List<Issues> cards){
        Context mContext = mcontext;
        this.cards = cards;
    }
    public JuneBugCardAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.issuescards, parent, false);

        return new JuneBugCardAdapter.MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final JuneBugCardAdapter.MyViewHolder holder, final int position){
        Issues card = cards.get(position);
        holder.title.setText(card.getTitle());
        holder.description.setText(card.getDescription());
        holder.txtstatus.setText(card.getStatus());
        holder.txtproject.setText(card.getProject());
        holder.txtaccount.setText(card.getAuthor());
        holder.txttime.setText(card.getTime());
    }
    @Override
    public int getItemCount(){
        return cards.size();
    }
}
