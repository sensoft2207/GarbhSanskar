package com.mxi.garbhsanskar.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;
import android.widget.CheckBox;

/**
 * Created by BugsSolveInc on 2/8/2018.
 */

public class RememberMe extends AppCompatCheckBox {

    public RememberMe(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public RememberMe(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RememberMe(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "font/WORKSANS-LIGHT.TTF");
        setTypeface(tf, 1);

    }

}

