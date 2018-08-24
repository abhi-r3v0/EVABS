package com.revo.evabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SharedBreach extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_breach);

        Button btnspref = (Button) findViewById(R.id.buttonsprefhint);
        final TextView tvspref = (TextView) findViewById(R.id.textViewsprefhint);
        btnspref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvspref.setText("How do you store key-value data in Android?");
            }
        });
    }
}
