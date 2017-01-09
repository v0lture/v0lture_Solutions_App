package com.apps.v0lture.v0lture_solutions;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static com.apps.v0lture.v0lture_solutions.R.drawable.card1;

public class About extends AppCompatActivity {
    private RecyclerView recyclerview1;
    private RecyclerView recyclerview2;
    private CardAdapter1 adapter1;
    private CardAdapter2 adapter2;
    private List<Card> cardList1;
    private List<Card> cardList2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerview1 = (RecyclerView)findViewById(R.id.Recycler_View1);
        recyclerview2 = (RecyclerView)findViewById(R.id.Recycler_View2);
        cardList1 = new ArrayList<>();
        cardList2 = new ArrayList<>();
        adapter1 = new CardAdapter1(this,cardList1);
        adapter2 = new CardAdapter2(this,cardList2);

        RecyclerView.LayoutManager layoutManager1 = new GridLayoutManager(this,1);
        recyclerview1.setLayoutManager(layoutManager1);
        recyclerview1.addItemDecoration(new About.GridSpacingItemDecoration1(1, dpToPx(10), true));
        recyclerview1.setItemAnimator(new DefaultItemAnimator());
        recyclerview1.setAdapter(adapter1);

        RecyclerView.LayoutManager layoutManager2 = new GridLayoutManager(this,2);
        recyclerview2.setLayoutManager(layoutManager2);
        recyclerview2.addItemDecoration(new About.GridSpacingItemDecoration2(2, dpToPx(10), true));
        recyclerview2.setItemAnimator(new DefaultItemAnimator());
        recyclerview2.setAdapter(adapter2);

        prepareCard();
        prepareCards2();
    }
    private void  prepareCard(){
        int[]card = new int[]{
                card1
        };
        Card a = new Card("ABOUT", "v0lture Solutions is a company dedicated to the creation and maintenance of high quality websites and software. We are proud supporters of the Free Software Foundation so all software we make for ourselves will always remain free and open source", card[0]);
        cardList1.add(a);
    }
    private void  prepareCards2(){
        int[]cards = new int[]{
                card1,
                R.drawable.card2,
                R.drawable.card3,
                R.drawable.card4,
                R.drawable.card5,
                R.drawable.card6
        };
        Card a = new Card("CEO", "Alexander Hamilton", cards[0]);
        cardList2.add(a);
        Card b = new Card("COO", "De'Angelo Grant", cards[1]);
        cardList2.add(b);
        Card c = new Card("Head of Marketing", "Nick Wade", cards[2]);
        cardList2.add(c);
        Card d = new Card("Lead Developer", "Maxwell Allen", cards[3]);
        cardList2.add(d);
        Card e = new Card("Lead Graphic Designer", "Eric", cards[4]);
        cardList2.add(e);
        Card f = new Card("Director of Mathemeatics", "Justin Van Housen", cards[5]);
        cardList2.add(f);
    }
    public class GridSpacingItemDecoration1 extends RecyclerView.ItemDecoration{
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration1(int spanCount, int spacing, boolean includeEdge){
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
    public class GridSpacingItemDecoration2 extends RecyclerView.ItemDecoration{
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration2(int spanCount, int spacing, boolean includeEdge){
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
