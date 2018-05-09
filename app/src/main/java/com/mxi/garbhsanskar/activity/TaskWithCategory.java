package com.mxi.garbhsanskar.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mxi.garbhsanskar.R;
import com.mxi.garbhsanskar.adapter.TaskCategoryAdapter;
import com.mxi.garbhsanskar.comman.CommanClass;
import com.mxi.garbhsanskar.model.ToDoData;

import java.util.ArrayList;

/**
 * Created by vishal on 19/2/18.
 */

public class TaskWithCategory extends AppCompatActivity {

    CommanClass cc;

    TextView tv_task_heading;

    ImageView iv_back_choose,iv_back;
    RecyclerView mRecyclerViewCat;
    ArrayList<ToDoData> listCat;

    String task_name;

    TaskCategoryAdapter tAdapter;

    FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_with_category);

        cc = new CommanClass(this);

        iv_back_choose = (ImageView)findViewById(R.id.iv_back_choose);
        iv_back = (ImageView)findViewById(R.id.iv_back);

        tv_task_heading = (TextView) findViewById(R.id.tv_task_heading);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        task_name = getIntent().getStringExtra("t_name");

        tv_task_heading.setText(task_name);

        mRecyclerViewCat = (RecyclerView) findViewById(R.id.rc_category);
        mRecyclerViewCat.setLayoutManager(new LinearLayoutManager(TaskWithCategory.this));
        mRecyclerViewCat.setItemAnimator(new DefaultItemAnimator());

        Glide.with(this).load(R.drawable.menu_bc).into(iv_back_choose);

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

        if (cc.loadPrefString("a_corner").equals("corner")){

            listCat = new ArrayList<ToDoData>();
            listCat.add(new ToDoData("Activity Corner One"));
            listCat.add(new ToDoData("Activity Corner Two"));
            listCat.add(new ToDoData("Activity Corner Three"));
            listCat.add(new ToDoData("Activity Corner Four"));
            listCat.add(new ToDoData("Activity Corner Five"));
            listCat.add(new ToDoData("Activity Corner Six"));
            listCat.add(new ToDoData("Activity Corner Seven"));
            listCat.add(new ToDoData("Activity Corner Eight"));

            //  list3.add(new ToDoData("Sleep",currentDate,dayOfTheWeek));

            tAdapter = new TaskCategoryAdapter(listCat,R.layout.task_category_item,TaskWithCategory.this);
            mRecyclerViewCat.setAdapter(tAdapter);

            cc.savePrefString("a_corner","");

        }else if (cc.loadPrefString("d_plan").equals("plan")) {

            listCat = new ArrayList<ToDoData>();
            listCat.add(new ToDoData("Diet Plan One"));
            listCat.add(new ToDoData("Diet Plan Two"));
            listCat.add(new ToDoData("Diet Plan Three"));
            listCat.add(new ToDoData("Diet Plan Four"));
            listCat.add(new ToDoData("Diet Plan Five"));
            listCat.add(new ToDoData("Diet Plan Six"));
            listCat.add(new ToDoData("Diet Plan Seven"));
            listCat.add(new ToDoData("Diet Plan Eight"));

            //  list3.add(new ToDoData("Sleep",currentDate,dayOfTheWeek));

            tAdapter = new TaskCategoryAdapter(listCat,R.layout.task_category_item,TaskWithCategory.this);
            mRecyclerViewCat.setAdapter(tAdapter);

            cc.savePrefString("d_plan","");

        }
        else {

                listCat = new ArrayList<ToDoData>();
                listCat.add(new ToDoData("Daily Yoga One"));
                listCat.add(new ToDoData("Daily Yoga Two"));
                listCat.add(new ToDoData("Daily Yoga Three"));
                listCat.add(new ToDoData("Daily Yoga Four"));
                listCat.add(new ToDoData("Daily Yoga Five"));
                listCat.add(new ToDoData("Daily Yoga Six"));
                listCat.add(new ToDoData("Daily Yoga Seven"));
                listCat.add(new ToDoData("Daily Yoga Eight"));

                //  list3.add(new ToDoData("Sleep",currentDate,dayOfTheWeek));

                tAdapter = new TaskCategoryAdapter(listCat,R.layout.task_category_item,TaskWithCategory.this);
                mRecyclerViewCat.setAdapter(tAdapter);

            }
        }

    private void taskDone() {

        final Dialog dialog = new Dialog(TaskWithCategory.this);
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


