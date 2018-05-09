package com.mxi.garbhsanskar.fragment;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.mxi.garbhsanskar.R;
import com.mxi.garbhsanskar.activity.TaskWithCategory;
import com.mxi.garbhsanskar.activity.TaskWithImages;
import com.mxi.garbhsanskar.activity.TaskWithTextOnly;
import com.mxi.garbhsanskar.activity.TaskWithTextVideoActivity;
import com.mxi.garbhsanskar.comman.CommanClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by BugsSolveInc on 2/13/2018.
 */

public class HomeFragment extends Fragment{

    CommanClass cc;

    Calendar myCalendar = Calendar.getInstance();

    LinearLayout ln_choose_date;

    LinearLayout ln_task_one,ln_task_two,ln_task_three,ln_task_four,ln_task_five,ln_task_six,ln_task_seven,ln_task_eight,ln_task_nine;


    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View homeView = inflater.inflate(R.layout.fragment_home, container, false);

        cc = new CommanClass(getActivity());

        ln_choose_date = (LinearLayout)homeView.findViewById(R.id.ln_choose_date);

        ln_task_one = (LinearLayout)homeView.findViewById(R.id.ln_task_one);
        ln_task_two = (LinearLayout)homeView.findViewById(R.id.ln_task_two);
        ln_task_three = (LinearLayout)homeView.findViewById(R.id.ln_task_three);
        ln_task_four = (LinearLayout)homeView.findViewById(R.id.ln_task_four);
        ln_task_five = (LinearLayout)homeView.findViewById(R.id.ln_task_five);
        ln_task_six = (LinearLayout)homeView.findViewById(R.id.ln_task_six);
        ln_task_seven = (LinearLayout)homeView.findViewById(R.id.ln_task_seven);
        ln_task_eight = (LinearLayout)homeView.findViewById(R.id.ln_task_eight);
        ln_task_nine = (LinearLayout)homeView.findViewById(R.id.ln_task_nine);

        ln_choose_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        ln_task_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentTaskVideo = new Intent(getActivity(), TaskWithTextVideoActivity.class);
                intentTaskVideo.putExtra("t_name","Garbhsanskar Prasang");
                startActivity(intentTaskVideo);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        ln_task_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentTaskText = new Intent(getActivity(), TaskWithTextOnly.class);
                intentTaskText.putExtra("t_name","Story Time");
                startActivity(intentTaskText);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        ln_task_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentTaskCategory = new Intent(getActivity(), TaskWithCategory.class);
                intentTaskCategory.putExtra("t_name","Daily Yoga");
                startActivity(intentTaskCategory);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        ln_task_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentTaskVideo = new Intent(getActivity(), TaskWithTextVideoActivity.class);
                intentTaskVideo.putExtra("t_name","Inspirational Video");
                startActivity(intentTaskVideo);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        ln_task_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentTaskCategory = new Intent(getActivity(), TaskWithCategory.class);
                intentTaskCategory.putExtra("t_name","Activity Corner");
                cc.savePrefString("a_corner","corner");
                startActivity(intentTaskCategory);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        ln_task_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentTaskText = new Intent(getActivity(), TaskWithTextOnly.class);
                intentTaskText.putExtra("t_name","Shlok & Mantra");
                startActivity(intentTaskText);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        ln_task_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentTaskImage = new Intent(getActivity(), TaskWithImages.class);
                intentTaskImage.putExtra("t_name","Inspirational Prasang");
                startActivity(intentTaskImage);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        ln_task_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentTaskCategory = new Intent(getActivity(), TaskWithCategory.class);
                intentTaskCategory.putExtra("t_name","Diet Plan");
                cc.savePrefString("d_plan","plan");
                startActivity(intentTaskCategory);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        ln_task_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentTaskText = new Intent(getActivity(), TaskWithTextOnly.class);
                intentTaskText.putExtra("t_name","Prathna");
                startActivity(intentTaskText);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });



        return homeView;

    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        //edittext.setText(sdf.format(myCalendar.getTime()));
    }


}
