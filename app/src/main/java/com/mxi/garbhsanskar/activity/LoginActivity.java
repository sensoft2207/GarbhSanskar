package com.mxi.garbhsanskar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mxi.garbhsanskar.R;

/**
 * Created by BugsSolveInc on 2/8/2018.
 */

public class LoginActivity extends AppCompatActivity {

    ImageView iv_back_choose;
    TextView tv_signup;

    Button btn_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        iv_back_choose = (ImageView)findViewById(R.id.iv_back_choose);
        tv_signup = (TextView) findViewById(R.id.tv_signup);


        btn_login = (Button) findViewById(R.id.btn_login);

        Glide.with(this).load(R.drawable.bg_choos).into(iv_back_choose);

        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intentSignup = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intentSignup);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentHome = new Intent(LoginActivity.this,HomeActivityTwo.class);
                intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
                startActivity(intentHome);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });
    }
}
