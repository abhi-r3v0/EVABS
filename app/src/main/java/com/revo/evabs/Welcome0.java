package com.revo.evabs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class
Welcome0 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome0);

        TextView tvwelcome = (TextView) findViewById(R.id.textViewwelcome0);
        tvwelcome.setText("Welcome, \n\n\n Humanity is in it's persuit of a new planet for Earthlings. \nThe SpaceBit ship, with a skilled hacker/scientist on board, has been sent to find a planet near the Cygnus X1 system. \nUntil yesterday, everything was under control. \nBut, few hours before, the ship lost all sorts of communication lines.\nScientists then found a strange space-time warp, which they doubt would be the reason for the crash. \n\nHowever, we have a log of a message from the ship, which was the last transmission, before the communication broke. Have a look! ");

        Button next0 = (Button) findViewById(R.id.buttonnext0);
        next0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Welcome0.this, Welcome.class);
                startActivity(i);
                finish();
            }
        });
    }
}
