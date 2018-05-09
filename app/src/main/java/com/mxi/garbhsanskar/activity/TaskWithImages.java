package com.mxi.garbhsanskar.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mxi.garbhsanskar.R;
import com.mxi.garbhsanskar.adapter.SlidingImage_Adapter;
import com.mxi.garbhsanskar.comman.AutoScrollViewPager;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;

/**
 * Created by vishal on 19/2/18.
 */

public class TaskWithImages extends AppCompatActivity {

    ImageView iv_back_choose,iv_back;

    TextView tv_task_heading;

    String task_name;

    CirclePageIndicator indicator;
    int position=0;
    private static AutoScrollViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES= {R.drawable.slider_image_one,R.drawable.slider_image_two,R.drawable.slider_image_three};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();

    FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_with_images);

        iv_back_choose = (ImageView)findViewById(R.id.iv_back_choose);
        iv_back = (ImageView)findViewById(R.id.iv_back);

        tv_task_heading = (TextView) findViewById(R.id.tv_task_heading);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        mPager = (AutoScrollViewPager)findViewById(R.id.pager_introduction);
        indicator = (CirclePageIndicator)findViewById(R.id.indicator);

        mPager.startAutoScroll();
        mPager.setInterval(3000);
        mPager.setCycle(true);
        mPager.setStopScrollWhenTouch(true);

        Glide.with(this).load(R.drawable.menu_bc).into(iv_back_choose);


        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
            }
        });


        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);




        mPager.setAdapter(new SlidingImage_Adapter(this,ImagesArray));
        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;


        indicator.setRadius(5 * density);
        NUM_PAGES =IMAGES.length;

        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                taskDone();

            }
        });
    }

    private void taskDone() {

        final Dialog dialog = new Dialog(TaskWithImages.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.task_done_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        dialog.getWindow().setLayout((6 * width) / 7, ActionBar.LayoutParams.WRAP_CONTENT);


        TextView tv_dialog_yes = (TextView) dialog.findViewById(R.id.tv_exit_yes);
        TextView tv_dialog_no = (TextView) dialog.findViewById(R.id.tv_exit_no);



        tv_dialog_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
                dialog.dismiss();
            }
        });

        tv_dialog_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        dialog.show();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}
