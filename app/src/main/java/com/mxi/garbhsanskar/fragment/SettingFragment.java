package com.mxi.garbhsanskar.fragment;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mxi.garbhsanskar.R;
import com.mxi.garbhsanskar.activity.HomeActivityTwo;
import com.mxi.garbhsanskar.activity.SplashScreen;

/**
 * Created by vishal on 19/2/18.
 */

public class SettingFragment extends Fragment {

    LinearLayout ln_change_pass,ln_change_lan;

    Animation pulse;
    Animation languageSelection;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View homeView = inflater.inflate(R.layout.setting_fragment, container, false);

        ln_change_pass = (LinearLayout)homeView.findViewById(R.id.ln_change_pass);
        ln_change_lan = (LinearLayout)homeView.findViewById(R.id.ln_change_lan);

        ln_change_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changePassDialog();

            }
        });

        ln_change_lan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showLanguageDialog();

            }
        });

        return homeView;
    }

    private void showLanguageDialog() {

        final Dialog dialog = new Dialog(getActivity());

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.language_selection_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.onWindowFocusChanged(false);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        dialog.getWindow().setLayout((6 * width) / 7, ActionBar.LayoutParams.WRAP_CONTENT);

        final LinearLayout ln_1 = (LinearLayout)dialog.findViewById(R.id.ln_1);
        final LinearLayout ln_2 = (LinearLayout)dialog.findViewById(R.id.ln_2);
        final LinearLayout ln_3 = (LinearLayout)dialog.findViewById(R.id.ln_3);


        languageSelection = AnimationUtils.loadAnimation(getActivity(), R.anim.click_anim);

        ln_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ln_1.startAnimation(languageSelection);

                dialog.dismiss();


            }
        });

        ln_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ln_2.startAnimation(languageSelection);

                dialog.dismiss();

            }
        });

        ln_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ln_3.startAnimation(languageSelection);
                dialog.dismiss();


            }
        });

        dialog.show();

    }

    private void changePassDialog() {

        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.change_pass_dialog);
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
}
