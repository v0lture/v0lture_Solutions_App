package com.apps.v0lture.v0lture_solutions;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.apps.v0lture.v0lture_solutions.R.drawable.card1;
import static com.apps.v0lture.v0lture_solutions.R.drawable.card10;
import static com.apps.v0lture.v0lture_solutions.R.drawable.card11;
import static com.apps.v0lture.v0lture_solutions.R.drawable.card12;
import static com.apps.v0lture.v0lture_solutions.R.drawable.card2;
import static com.apps.v0lture.v0lture_solutions.R.drawable.card3;
import static com.apps.v0lture.v0lture_solutions.R.drawable.card4;
import static com.apps.v0lture.v0lture_solutions.R.drawable.card5;
import static com.apps.v0lture.v0lture_solutions.R.drawable.card6;
import static com.apps.v0lture.v0lture_solutions.R.drawable.card7;
import static com.apps.v0lture.v0lture_solutions.R.drawable.card8;
import static com.apps.v0lture.v0lture_solutions.R.drawable.card9;

public class About extends AppCompatActivity {
    private List<Card> cardList1;
    private List<Card> cardList2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerview1 = (RecyclerView)findViewById(R.id.Recycler_View1);
        RecyclerView recyclerview2 = (RecyclerView)findViewById(R.id.Recycler_View2);
        cardList1 = new ArrayList<>();
        cardList2 = new ArrayList<>();
        AboutCardAdapter adapter1 = new AboutCardAdapter(this,cardList1);
        CompanyCardAdapter adapter2 = new CompanyCardAdapter(this,cardList2);

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
        Card a = new Card("ABOUT", "v0lture Solutions is a company dedicated to the creation and maintenance of high quality websites and software. We are proud supporters of the Free Software Foundation so all software we make for ourselves will always remain free and open source", "",card[0]);
        cardList1.add(a);
    }
    private void  prepareCards2(){
        int[]cards = new int[]{
            card1,
                card2,
                card3,
                card4,
                card5,
                card6,
                card7,
                card8,
                card9,
                card10,
                card11,
                card12
        };
        Card a = new Card("CEO", "Alexander Hamilton","", cards[0]);
        cardList2.add(a);
        Card b = new Card("COO", "De'Angelo Grant", "",cards[1]);
        cardList2.add(b);
        Card c = new Card("CMO", "Natron Cusack","", cards[2]);
        cardList2.add(c);
        Card d = new Card("CTO", "Max Allen", "",cards[3]);
        cardList2.add(d);
        Card e = new Card("CFO", "Francisco Garduno","", cards[4]);
        cardList2.add(e);
        Card f = new Card("CCO", "Eric Jacobson","", cards[5]);
        cardList2.add(f);
        Card g = new Card("Director of Development", "DeWayne Clark","", cards[6]);
        cardList2.add(g);
        Card h = new Card("Director of Mathemeatics", "Justin Van Housen","", cards[7]);
        cardList2.add(h);
        Card i = new Card("President of Marketing", "Tashaun Williams","", cards[8]);
        cardList2.add(i);
        Card j = new Card("Vice President of Marketing", "Nick Wade","", cards[9]);
        cardList2.add(j);
        Card k = new Card("Lead Apple Developer", "Mike Jones","", cards[10]);
        cardList2.add(k);
        Card l = new Card("Marketing Manager", "Billy Fitzgerald","", cards[11]);
        cardList2.add(l);
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contact, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){
            case R.id.contact_item:
                sendemail();
                break;
            case android.R.id.home:
                // API 5+ solution
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
        return true;
    }

    private void sendemail() {
        Log.i("Send email", "");
        String[] TO = {"contact@v0lture.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Email Sent...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(About.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
