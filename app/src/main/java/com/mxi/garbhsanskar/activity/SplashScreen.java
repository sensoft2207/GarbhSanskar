package com.mxi.garbhsanskar.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.mxi.garbhsanskar.R;
import com.mxi.garbhsanskar.comman.CommanClass;

public class SplashScreen extends AppCompatActivity {

    CommanClass cc;
    String[] PERMISSIONS = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    int PERMISSION_ALL = 1;

    private static int SPLASH_TIME_OUT = 4000;

    LinearLayout iv_logo;
    Animation pulse;
    Animation languageSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        cc=new CommanClass(this);

        iv_logo =(LinearLayout) findViewById(R.id.iv_logo);


        pulse = AnimationUtils.loadAnimation(this, R.anim.pulse_anim_logo);
        iv_logo.startAnimation(pulse);

        showLanguageDialog();
    }

    private void showLanguageDialog() {

        final Dialog dialog = new Dialog(SplashScreen.this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
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


        languageSelection = AnimationUtils.loadAnimation(this, R.anim.click_anim);

        ln_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ln_1.startAnimation(languageSelection);

                new Handler().postDelayed(new Runnable() {
                    public void run() {

                        if(!hasPermissions(SplashScreen.this, PERMISSIONS)){
                            ActivityCompat.requestPermissions(SplashScreen.this, PERMISSIONS, PERMISSION_ALL);
                        }else{
                            CountDown();
                        }

                        dialog.dismiss();
                    }
                }, 3000);




            }
        });

        ln_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ln_2.startAnimation(languageSelection);

                new Handler().postDelayed(new Runnable() {
                    public void run() {

                        if(!hasPermissions(SplashScreen.this, PERMISSIONS)){
                            ActivityCompat.requestPermissions(SplashScreen.this, PERMISSIONS, PERMISSION_ALL);
                        }else{
                            CountDown();
                        }
                        dialog.dismiss();
                    }
                }, 3000);


            }
        });

        ln_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ln_3.startAnimation(languageSelection);

                new Handler().postDelayed(new Runnable() {
                    public void run() {

                        if(!hasPermissions(SplashScreen.this, PERMISSIONS)){
                            ActivityCompat.requestPermissions(SplashScreen.this, PERMISSIONS, PERMISSION_ALL);
                        }else{
                            CountDown();
                        }
                        dialog.dismiss();
                    }
                }, 3000);


            }
        });

        dialog.show();

    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {

            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    CountDown();
                } else {
                    showErrorDialog();
                }
                break;
        }
    }
    public void showErrorDialog() {

        AlertDialog.Builder alert = new AlertDialog.Builder(SplashScreen.this);
        alert.setTitle("GarbhSanskar");
        alert.setMessage("Permission is require to enable all features of the app");
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if(!hasPermissions(SplashScreen.this, PERMISSIONS)){
                    ActivityCompat.requestPermissions(SplashScreen.this, PERMISSIONS, PERMISSION_ALL);
                }
            }
        });
        alert.show();
    }
    private void CountDown() {



        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {

                Intent i = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}
