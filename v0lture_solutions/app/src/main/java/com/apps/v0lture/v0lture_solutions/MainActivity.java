package com.apps.v0lture.v0lture_solutions;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import static com.apps.v0lture.v0lture_solutions.R.drawable.card1;

public class MainActivity extends AppCompatActivity implements ClickListener  {
    private RecyclerView recyclerView;
    private CardAdapter adapter;
    private RelativeLayout cardLayout;
    private List<Card> cardList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.Recycler_View);
        cardLayout=(RelativeLayout)findViewById(R.id.color_layout);
        cardList = new ArrayList<>();
        adapter = new CardAdapter(this,cardList);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


        prepareCards();

    }

    private void prepareCards(){
        int[] cards = new int[]{
                card1,
                R.drawable.card2,
                R.drawable.card3,
                R.drawable.card4,
                R.drawable.card5,
                R.drawable.card6
        };

        Card a = new Card("v0ltureDB","A web MySQL database manager","0.0.3",cards[0]);
        //cardLayout.setBackgroundColor(Color.BLUE);
        cardList.add(a);
        Card b = new Card("MyMu","App for Methodist University portal","0.2",cards[1]);
        cardList.add(b);
        Card c = new Card("vOS","The operating system by v0lture","0.0",cards[2]);
        cardList.add(c);
        Card d = new Card("vBugs","v0lture's in-house bug tracker","0.0",cards[3]);
        cardList.add(d);
        Card e = new Card("veddit","Material design facelift for Reddit","0.0.2",cards[4]);
        cardList.add(e);
        Card f = new Card("vPolice","Minecraft Police plugin","0.0.0",cards[5]);
        cardList.add(f);

       // if(cards[0].isSelected){
          //  Intent intent = new Intent(MainActivity.this, Card1.class);
          //  startActivity(intent);
        //}

    }
    @Override
    public void ClickListener(View view, int position) {

        if(position==0){
            Intent intent = new Intent(MainActivity.this, Splash.class);
            intent.putExtra("ItemPosition", position);
            startActivity(intent);
        } else if(position==1){
            System.out.println("Clicked 2");
        } else if(position==2){
            System.out.println("Clicked 3");
        } else {
            System.out.println("Position....."+ position);
        }
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration{
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge){
            this.spacing = spacing;
            this.spanCount = spanCount;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){
            int position = parent.getChildAdapterPosition(view);
            int column = position % spanCount;

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
