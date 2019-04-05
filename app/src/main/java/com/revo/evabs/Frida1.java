package com.revo.evabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Frida1 extends AppCompatActivity implements View.OnClickListener{

    int a=25, b=2, x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frida1);
        Button bt = findViewById(R.id.fbutton);
        bt.setOnClickListener(this);

        Button btnhint = findViewById(R.id.buttonhintfrida);
        final TextView tvhint = findViewById(R.id.textViewhintfrida);
        btnhint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvhint.setText("``Dynamic instrumentation`` what?");
            }
        });
    }

    @Override
    public void onClick(View view) {

        TextView tv = findViewById(R.id.result);
        TextView at = findViewById(R.id.valuea);
        TextView bt = findViewById(R.id.valueb);
        TextView xt = findViewById(R.id.xres);

        at.setText(String.valueOf(a));
        bt.setText(String.valueOf(b));

        x = a*b;
        Random r = new Random();
        int rand = r.nextInt(220-150) + 150;

        xt.setText(String.valueOf(x));

        if (x > rand) {
            tv.setText("VIBRAN IS RESDY TO FLY! YOU ARE GOING HOME!");
            String x = stringFromJNI();
            Log.d("CONGRATZ!", x);
        }
        else{
            tv.setText("Co-ordinates Not Found!");
        }

    }

    static {
        System.loadLibrary("native-lib");
    }

    public native String stringFromJNI();
}
