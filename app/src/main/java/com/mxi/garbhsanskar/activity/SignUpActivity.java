package com.mxi.garbhsanskar.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mxi.garbhsanskar.R;

import org.w3c.dom.Text;

/**
 * Created by BugsSolveInc on 2/11/2018.
 */

public class SignUpActivity extends AppCompatActivity {


    Spinner sp_city,sp_state,sp_country;
    EditText tv_first_name,tv_last_name,tv_dob,tv_mobileno,tv_email,tv_password,tv_confirm_password,tv_pincode;

    ImageView iv_back_choose,iv_back;
    Button btn_signup;

    String[] cityArray = new String[]{"City","Ahmedabad","Vadodara","Surat","Mehsana","Modasa","Gandhinagar","Palanpur"};
    String[] stateArray = new String[]{"State","Gujarat","Haryana","Maharastra","Himachal","Punjab","MP","xyz"};
    String[] countryArray = new String[]{"Country","India","US","UK","Australia","Kenya","Southafrica","xyz"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);

        init();

    }

    private void init() {

        iv_back_choose = (ImageView)findViewById(R.id.iv_back_choose);
        iv_back = (ImageView)findViewById(R.id.iv_back);

        tv_first_name = (EditText)findViewById(R.id.tv_first_name);
        tv_last_name = (EditText)findViewById(R.id.tv_last_name);
        tv_dob = (EditText)findViewById(R.id.tv_dob);
        tv_mobileno = (EditText)findViewById(R.id.tv_mobileno);
        tv_email = (EditText)findViewById(R.id.tv_email);
        tv_password = (EditText)findViewById(R.id.tv_password);
        tv_confirm_password = (EditText)findViewById(R.id.tv_confirm_password);
        tv_pincode = (EditText)findViewById(R.id.tv_pincode);

        sp_city = (Spinner)findViewById(R.id.sp_city);
        sp_state = (Spinner)findViewById(R.id.sp_state);
        sp_country = (Spinner)findViewById(R.id.sp_country);

        ArrayAdapter<String> city = new ArrayAdapter<String>(SignUpActivity.this,android.R.layout.simple_spinner_item, cityArray);
        city.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_city.setAdapter(city);

        ArrayAdapter<String> state = new ArrayAdapter<String>(SignUpActivity.this,android.R.layout.simple_spinner_item, stateArray);
        state.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_state.setAdapter(state);

        ArrayAdapter<String> country = new ArrayAdapter<String>(SignUpActivity.this,android.R.layout.simple_spinner_item, countryArray);
        country.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_country.setAdapter(country);

        Glide.with(this).load(R.drawable.signup_back).into(iv_back_choose);

        clickListner();
    }

    private void clickListner() {

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
