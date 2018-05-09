package com.mxi.garbhsanskar.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.mxi.garbhsanskar.fragment.HomeFragment;
import com.mxi.garbhsanskar.R;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

/**
 * Created by BugsSolveInc on 2/11/2018.
 */

public class HomeActivity extends AppCompatActivity {

    private SlidingRootNav slidingRootNav;
    String title = "";

    ImageView iv_back_choose;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        slidingRootNav = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(true)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu_drawer)
                .inject();

        /*iv_back_choose = (ImageView)findViewById(R.id.iv_back_choose);

        Glide.with(this).load(R.drawable.menu_bc).into(iv_back_choose);*/
        firstTimeLoadHome();
    }

    private void firstTimeLoadHome() {

        android.app.FragmentTransaction   tra = getFragmentManager().beginTransaction();
        Fragment newFragment = new HomeFragment();
        tra.replace(R.id.container, newFragment);
        title = "Home";
        getSupportActionBar().setTitle(title);
        tra.commit();
    }
}
