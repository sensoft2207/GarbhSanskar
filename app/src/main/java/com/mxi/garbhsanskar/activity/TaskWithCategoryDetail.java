package com.mxi.garbhsanskar.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mxi.garbhsanskar.R;

/**
 * Created by vishal on 19/2/18.
 */

public class TaskWithCategoryDetail extends AppCompatActivity {

    ImageView iv_back_choose,iv_back;

    TextView tv_task_heading;

    String cat_name;

    FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_with_text_only);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        iv_back_choose = (ImageView)findViewById(R.id.iv_back_choose);
        iv_back = (ImageView)findViewById(R.id.iv_back);
        tv_task_heading = (TextView) findViewById(R.id.tv_task_heading);

        cat_name = getIntent().getStringExtra("cat_name");

        tv_task_heading.setText(cat_name);

        fab.setVisibility(View.INVISIBLE);

        Glide.with(this).load(R.drawable.menu_bc).into(iv_back_choose);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();

                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}