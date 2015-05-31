package com.example.feroli.days;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.dexafree.materialList.cards.SmallImageCard;
import com.dexafree.materialList.view.MaterialListView;


public class TrophiesActivity extends ActionBarActivity {

    MaterialListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trophies);

        mListView = (MaterialListView) findViewById(R.id.material_listview);

        CustomCard card = new CustomCard(this);
        card.setDescription("On 25th May");
        card.setTitle("Early Bird");
        card.setDrawable(R.drawable.trophy);
        mListView.add(card);

        CustomCard card2 = new CustomCard(this);
        card2.setDescription("On 28th May");
        card2.setTitle("No Smoking");
        card2.setDrawable(R.drawable.trophy);
        mListView.add(card2);

        CustomCard card3 = new CustomCard(this);
        card3.setDescription("On 30th May");
        card3.setTitle("No Sleep");
        card3.setDrawable(R.drawable.trophy);
        mListView.add(card3);
    }

}
