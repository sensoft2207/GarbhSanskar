package com.mxi.garbhsanskar.adapter;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mxi.garbhsanskar.R;
import com.mxi.garbhsanskar.activity.TaskWithCategoryDetail;
import com.mxi.garbhsanskar.model.ToDoData;

import java.util.List;

/**
 * Created by vishal on 19/2/18.
 */

public class TaskCategoryAdapter extends RecyclerView.Adapter<TaskCategoryAdapter.ViewHolder> {
    private List<ToDoData> countries;
    private int rowLayout;
    public static Context mContext;

    public TaskCategoryAdapter(List<ToDoData> countries, int rowLayout, Context context) {
        this.countries = countries;
        this.rowLayout = rowLayout;
        this.mContext = context;
    }
    @Override
    public int getItemCount() {
        return countries == null ? 0 : countries.size();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ViewHolder(v);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        final ToDoData myItem = countries.get(i);
        viewHolder.Name.setText(myItem.getName());

        viewHolder.ln_cat_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getAdapterPos(viewHolder.getAdapterPosition());
            }
        });

    }

    private void getAdapterPos(int adapterPosition) {

        ToDoData myItem = countries.get(adapterPosition);

        Intent intentCatDetail = new Intent(mContext, TaskWithCategoryDetail.class);
        intentCatDetail.putExtra("cat_name",myItem.getName());
        mContext.startActivity(intentCatDetail);
        ((Activity)mContext).overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);


    }

    public static class ViewHolder extends RecyclerView.ViewHolder /*implements View.OnClickListener*/ {
        public TextView Name;
        public LinearLayout ln_cat_click;


        public ViewHolder(View itemView) {
            super(itemView);


            Name = (TextView) itemView.findViewById(R.id.text_name);
            ln_cat_click = (LinearLayout) itemView.findViewById(R.id.ln_cat_click);

        }


    }}


