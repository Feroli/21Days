package com.example.feroli.days;

/**
 * Created by ivanmoreno on 31/5/15.
 */
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.dexafree.materialList.model.CardItemView;

public class CustomCardView extends CardItemView<CustomCard> {

    TextView mTitle;
    TextView mDescription;


    // Default constructors
    public CustomCardView(Context context) {
        super(context);
    }

    public CustomCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomCardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void build(CustomCard card) {
        setTitle(card.getTitle());
        setDescription(card.getDescription());
        setBackgroundColor(card.getBackgroundColor());
    }

    public void setTitle(String title) {
        mTitle = (TextView) findViewById(R.id.titleTextView);
        mTitle.setText(title);
    }

    public void setDescription(String description) {
        mDescription = (TextView) findViewById(R.id.descriptionTextView);
        mDescription.setText(description);
    }

    public void setBackgroundColor(int color) {
        findViewById(R.id.cardView).setBackgroundColor(color);
    }

}
