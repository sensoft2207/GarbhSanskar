package com.mxi.garbhsanskar.activity;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mxi.garbhsanskar.fragment.HomeFragment;
import com.mxi.garbhsanskar.R;
import com.mxi.garbhsanskar.fragment.FragmentDrawer;
import com.mxi.garbhsanskar.fragment.SettingFragment;

import static com.mxi.garbhsanskar.fragment.FragmentDrawer.mDrawerLayout;

/**
 * Created by vishal on 17/2/18.
 */

public class HomeActivityTwo extends AppCompatActivity {


    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    String title = "";

    LinearLayout ln_profile,ln_report,ln_setting,ln_logout,ln_home;
    ImageView iv_profile,iv_report,iv_setting,iv_logout,iv_home;


    LinearLayout ln_home_m,ln_report_m,ln_profile_m,ln_setting_m,ln_logout_m,ln_help_m;

    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        setContentView(R.layout.activity_menu);

        init();
    }

    private void init() {

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_nav_drawer_patientlist_menu);

        ln_home_m = (LinearLayout)drawerFragment.getActivity().findViewById(R.id.ln_home_m);
        ln_report_m = (LinearLayout)drawerFragment.getActivity().findViewById(R.id.ln_report_m);
        ln_setting_m = (LinearLayout)drawerFragment.getActivity().findViewById(R.id.ln_setting_m);
        ln_profile_m = (LinearLayout)drawerFragment.getActivity().findViewById(R.id.ln_profile_m);
        ln_logout_m = (LinearLayout)drawerFragment.getActivity().findViewById(R.id.ln_logout_m);
        ln_help_m = (LinearLayout)drawerFragment.getActivity().findViewById(R.id.ln_help_m);

        clickListnerMenu();

        ln_logout = (LinearLayout)findViewById(R.id.ln_logout);
        ln_setting = (LinearLayout)findViewById(R.id.ln_setting);
        ln_home = (LinearLayout)findViewById(R.id.ln_home);
        ln_profile = (LinearLayout)findViewById(R.id.ln_profile);
        ln_report = (LinearLayout)findViewById(R.id.ln_report);

        iv_profile = (ImageView) findViewById(R.id.iv_profile);
        iv_report = (ImageView) findViewById(R.id.iv_report);
        iv_home = (ImageView) findViewById(R.id.iv_home);
        iv_setting = (ImageView) findViewById(R.id.iv_setting);
        iv_logout = (ImageView) findViewById(R.id.iv_logout);

        iv_home.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.main_bg), android.graphics.PorterDuff.Mode.MULTIPLY);

        ln_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logoutDialog();

                iv_logout.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.main_bg), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_home.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
            //    iv_report.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_setting.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_profile.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
            }
        });

        ln_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firstTimeLoadHome();

                iv_logout.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_home.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.main_bg), android.graphics.PorterDuff.Mode.MULTIPLY);
               // iv_report.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_setting.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_profile.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
            }
        });

        ln_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

                android.app.FragmentTransaction   tra = getFragmentManager().beginTransaction();
                Fragment newFragment = new SettingFragment();
                tra.replace(R.id.container_body, newFragment);
                title = "Settings";
                getSupportActionBar().setTitle(title);
                tra.commit();

                iv_logout.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_home.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
              //  iv_report.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_setting.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.main_bg), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_profile.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);

            }
        });

        ln_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iv_logout.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_home.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
              //  iv_report.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_setting.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_profile.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.main_bg), android.graphics.PorterDuff.Mode.MULTIPLY);
            }
        });

        ln_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iv_logout.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_home.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
              //  iv_report.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.main_bg), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_setting.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_profile.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
            }
        });

        firstTimeLoadHome();

        drawerFragment.setUp(R.id.fragment_nav_drawer_patientlist_menu, (DrawerLayout)findViewById(R.id.drawer_layout), mToolbar);
    }

    private void clickListnerMenu() {

        ln_home_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firstTimeLoadHome();

                iv_logout.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_home.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.main_bg), android.graphics.PorterDuff.Mode.MULTIPLY);
                //    iv_report.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_setting.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_profile.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);

                mDrawerLayout.closeDrawers();
            }
        });

        ln_report_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.closeDrawers();
            }
        });

        ln_profile_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iv_logout.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_home.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                //    iv_report.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_setting.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_profile.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.main_bg), android.graphics.PorterDuff.Mode.MULTIPLY);

                mDrawerLayout.closeDrawers();
            }
        });

        ln_setting_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.app.FragmentTransaction   tra = getFragmentManager().beginTransaction();
                Fragment newFragment = new SettingFragment();
                tra.replace(R.id.container_body, newFragment);
                title = "Settings";
                getSupportActionBar().setTitle(title);
                tra.commit();

                iv_logout.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_home.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                //    iv_report.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_setting.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.main_bg), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_profile.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);

                mDrawerLayout.closeDrawers();
            }
        });

        ln_help_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.closeDrawers();
            }
        });

        ln_logout_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logoutDialog();

                iv_logout.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.main_bg), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_home.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                //    iv_report.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_setting.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
                iv_profile.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);

                mDrawerLayout.closeDrawers();
            }
        });
    }



    private void firstTimeLoadHome() {

        android.app.FragmentTransaction   tra = getFragmentManager().beginTransaction();
        Fragment newFragment = new HomeFragment();
        tra.replace(R.id.container_body, newFragment);
        title = "Home";
        getSupportActionBar().setTitle(title);
        tra.commit();
    }

    private void logoutDialog() {

        final Dialog dialog = new Dialog(HomeActivityTwo.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.logout_dialog);
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

                Intent in = new Intent();
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                overridePendingTransition(0,0);
                finish();
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
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

}
