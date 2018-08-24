package com.revo.evabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExportedInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exported_info);

        Button hintexported = (Button) findViewById(R.id.buttonhintexport);
        final TextView tvexport = (TextView) findViewById(R.id.textViewhintexport);
        hintexported.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvexport.setText("What is an exported activity? What is it's security issue?");
            }
        });
    }
}
