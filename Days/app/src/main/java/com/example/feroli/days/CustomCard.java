package com.example.feroli.days;

/**
 * Created by ivanmoreno on 31/5/15.
 */

import android.content.Context;
import com.dexafree.materialList.cards.SimpleCard;

public class CustomCard extends SimpleCard {
    public CustomCard(final Context context) {
        super(context);
    }

    @Override
    public int getLayout() {
        return R.layout.card_custom;
    }
}
