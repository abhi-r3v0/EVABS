package com.revo.evabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Launch extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public String USER = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tvlaunchname = findViewById(R.id.textViewlaunchname);
        TextView tvprojpage = findViewById(R.id.textViewlaunchprojpage);
        TextView tvlaunchversion = findViewById(R.id.textViewlaunchversion);
        ImageView ivlaunchimg = findViewById(R.id.imageViewlaunch);

        Button btnlaunchclass = findViewById(R.id.buttonlaunchchall);
        btnlaunchclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent challs = new Intent(Launch.this, ChallengeList.class);
                startActivity(challs);
            }
        });

        Button btnlaunchflag = findViewById(R.id.buttonlaunchflag);
        btnlaunchflag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent theflag = new Intent(Launch.this, flagcheck.class);
                startActivity(theflag);
            }
        });



        Animation imgrotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotation);
        ivlaunchimg.startAnimation(imgrotate);
        //imgrotate.setRepeatCount(Animation.INFINITE);


        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/ssb.otf");
        tvlaunchname.setTypeface(font1);
        tvprojpage.setTypeface(font1);
        tvlaunchversion.setTypeface(font1);

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            //show sign up activity
            startActivity(new Intent(Launch.this, Welcome0.class));
            finish();
        }

        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).commit();

        SharedPreferences sp = getSharedPreferences("DETAILS", MODE_PRIVATE);

        if (sp.contains(USER)) {
            String uname = sp.getString(USER, "");
            tvlaunchname.setText("Hi, " + uname);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.launch, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent i = new Intent(Launch.this, ChallengeList.class);
            startActivity(i);
        } else if (id == R.id.nav_gallery) {
            Intent j = new Intent(Launch.this, flagcheck.class);
            startActivity(j);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
