package com.mxi.garbhsanskar.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by mxi on 26/12/17.
 */

public class MyEdittextBlack extends EditText {

    public MyEdittextBlack(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public MyEdittextBlack(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyEdittextBlack(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "font/WORKSANS-BLACK.TTF");
        setTypeface(tf, 1);

    }

}
