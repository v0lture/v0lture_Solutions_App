package com.apps.v0lture.v0lture_solutions;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by De'Angelo on 1/4/2017.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder> {
    private Context mContext;
    private List<Card> cardList;
    private ClickListener clicklistener =null;
    public CardAdapter(List<Card>cardList){
        this.cardList = cardList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView;
        public TextView title, version, details;
        public ImageView  overflow;
        public MyViewHolder(final View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.card_view);
            title = (TextView) itemView.findViewById(R.id.top_left_text);
            details = (TextView) itemView.findViewById(R.id.bottom_text);
            version = (TextView) itemView.findViewById(R.id.top_right_text);
            overflow = (ImageView) itemView.findViewById(R.id.overflow);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(), "Position:"+ Integer.toString(getPosition()), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    public void setClickListener(ClickListener clickListener){
        this.clicklistener = clickListener;
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
    public void onBindViewHolder(final CardAdapter.MyViewHolder holder, int position) {
        Card card = cardList.get(position);
        holder.title.setText(card.getName());
        holder.details.setText(card.getDetails());
        holder.version.setText(card.getVersion());

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });

    }
    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.contact, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }
    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.about_item:
                    Toast.makeText(mContext, "About", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.contact_item:
                    Toast.makeText(mContext, "Contact", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }


    @Override
    public int getItemCount() {
        return cardList.size();
    }
}
