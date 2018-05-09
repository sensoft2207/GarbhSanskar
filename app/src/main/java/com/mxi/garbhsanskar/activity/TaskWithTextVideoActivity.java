package com.mxi.garbhsanskar.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mxi.garbhsanskar.R;

/**
 * Created by vishal on 16/2/18.
 */

public class TaskWithTextVideoActivity extends AppCompatActivity {

    ImageView iv_back_choose,iv_video_back,iv_back;

    FrameLayout fm_play_video;

    TextView tv_task_heading;

    String task_name;

    FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_with_text_video);

        iv_back_choose = (ImageView)findViewById(R.id.iv_back_choose);
        iv_video_back = (ImageView)findViewById(R.id.iv_video_back);
        iv_back = (ImageView)findViewById(R.id.iv_back);

        tv_task_heading = (TextView) findViewById(R.id.tv_task_heading);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        task_name = getIntent().getStringExtra("t_name");

        tv_task_heading.setText(task_name);

        fm_play_video = (FrameLayout) findViewById(R.id.fm_play_video);

        Glide.with(this).load(R.drawable.menu_bc).into(iv_back_choose);
        Glide.with(this).load(R.drawable.bg_choos).into(iv_video_back);

        fm_play_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent videoUrlIntent = new Intent(getBaseContext(),VideoActivity.class);
                String uriPath = "https://www.youtube.com/watch?v=DjWBGUHs5bM";
                //Uri UrlPath = Uri.parse(uriPath);

                videoUrlIntent.putExtra("URL",uriPath);
                videoUrlIntent.putExtra("TITLE","Garbhsanskar");

                startActivity(videoUrlIntent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

            }
        });

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
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

        final Dialog dialog = new Dialog(TaskWithTextVideoActivity.this);
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
