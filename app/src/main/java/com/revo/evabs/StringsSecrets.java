package com.revo.evabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StringsSecrets extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strings_secrets);

        Button strpoolhint = (Button) findViewById(R.id.buttonstringhint);
        final TextView tvstrhint = (TextView) findViewById(R.id.textViewstringhint);
        strpoolhint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvstrhint.setText("There is some place in the Android application where the strings are stored in an xml file. How to find it?");
            }
        });
    }
}
