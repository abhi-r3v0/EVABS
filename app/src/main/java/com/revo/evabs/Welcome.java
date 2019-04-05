package com.revo.evabs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Welcome extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/ssb.otf");
        TextView tvwelcome = (TextView) findViewById(R.id.textViewwelcome);
        //tvwelcome.setTypeface(font1);
        tvwelcome.setText(" `` ..I've crashed into an unknown planet here. \nI'm safe, but the ship has taken lotta damage and the temperature is rising drastically. \nI need to fix EVABS, which is the Virtual System in the ship, before it's too late. I've got a terminal access to SYS_CTRL. \nLemme use my skills and hack into EVABS and get SpaceBit flying again!..``\n\n\nMy name is  ");

        Button access = (Button) findViewById(R.id.buttonaccess);
        access.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText uname = (EditText) findViewById(R.id.editTextname);
        String user = uname.getText().toString();
        if (user.equals("")){
            Toast.makeText(getApplicationContext(), "Please fill in your hacker handle", Toast.LENGTH_LONG).show();
        }
        else{
            SharedPreferences sp = getSharedPreferences("DETAILS", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("username", user);
            edit.putString("password","EVABS{" + stringFromJNI() + "}");
            edit.commit();
            Toast.makeText(getApplicationContext(), "Launching Mission", Toast.LENGTH_LONG).show();
            Intent i = new Intent(Welcome.this, Launch.class);
            startActivity(i);
            finish();
        }

    }

    static
    {
        System.loadLibrary("native-lib");
    }

    public native String stringFromJNI();

}
