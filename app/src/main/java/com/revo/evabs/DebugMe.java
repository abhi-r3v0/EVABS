package com.revo.evabs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DebugMe extends AppCompatActivity implements View.OnClickListener{

    public String USER = "username";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug_me);
        Button db = (Button) findViewById(R.id.buttondebug);
        TextView tv = (TextView) findViewById(R.id.textView2);
        SharedPreferences sp = getSharedPreferences("DETAILS", MODE_PRIVATE);
        if (sp.contains(USER)){
            String uname = sp.getString(USER, "");
            tv.setText("Welcome aboard, " + uname + ". Here is your first challenge");
        }
        Button dbh = (Button) findViewById(R.id.buttondebughint);
        dbh.setOnClickListener(this);
        db.setOnClickListener((View.OnClickListener) this);
    }
    static {
        System.loadLibrary("native-lib");
    }

    public native String stringFromJNI();

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttondebug:
                TextView tvdebug = (TextView) findViewById(R.id.textViewdebug);
                tvdebug.setText("SYS_CTRL_FAILURE: The developer was not supposed to log important data. Your secret key has been logged");
                String debugged = stringFromJNI();
                Log.d("** SYS_CTRL **: ", "EVABS{" + debugged + "}");
                break;

            case R.id.buttondebughint:
                TextView tvdebughint = (TextView) findViewById(R.id.textViewdebughint);
                tvdebughint.setText("How do you find the log of running apps in an Android device using ADB?");
        }

    }
}
