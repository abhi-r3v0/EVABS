package com.revo.evabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Decode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decode);

        String gc_key_1 = "RVZBQlN7bmV2M3Jfc3QwcmU=";  //Ew! what is that encoding, with an " == in the end "?
        String gc_key_2 = "X3MzbnMhdGl2M19kYXRh";
        String gc_key_3 = "XzFuXzdoM19zMHVyY2VjMGRl";

        String THE_KEY = gc_key_1 + gc_key_2 + gc_key_3;

        Button btnhintdeode = (Button) findViewById(R.id.buttonhintdecode);
        final TextView tvdecodehint = (TextView) findViewById(R.id.textViewhintgc);
        btnhintdeode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvdecodehint.setText("Reversing APK to Java? hmmm..");
            }
        });
    }

}
