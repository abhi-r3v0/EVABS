package com.revo.evabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ChallengeList extends AppCompatActivity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chall_info_single);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences sp = getSharedPreferences("DETAILS", MODE_PRIVATE);

        TextView tvchall = (TextView)findViewById(R.id.textViewChall);


        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/ssb.otf");

        tvchall.setTypeface(font1);

        Button l1 = (Button) findViewById(R.id.buttonlevel1);
        Button l2 = (Button) findViewById(R.id.buttonlevel2);
        Button l3 = (Button) findViewById(R.id.buttonlevel3);
        Button l4 = (Button) findViewById(R.id.buttonlevel4);
        Button l5 = (Button) findViewById(R.id.buttonlevel5);
        Button l6 = (Button) findViewById(R.id.buttonlevel6);
        Button l7 = (Button) findViewById(R.id.buttonlevel7);
        Button l8 = (Button) findViewById(R.id.buttonlevel8);
        Button l9 = (Button) findViewById(R.id.buttonlevel9);
        Button l10 = (Button) findViewById(R.id.buttonlevel10);
        Button l11 = (Button) findViewById(R.id.buttonlevel11);
        Button l12 = (Button) findViewById(R.id.buttonlevel12);


        l1.setOnClickListener(this);
        l2.setOnClickListener(this);
        l3.setOnClickListener(this);
        l4.setOnClickListener(this);
        l5.setOnClickListener(this);
        l6.setOnClickListener(this);
        l7.setOnClickListener(this);
        l8.setOnClickListener(this);
        l9.setOnClickListener(this);
        l10.setOnClickListener(this);
        l11.setOnClickListener(this);
        l12.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonlevel1:
                Intent l1i = new Intent(ChallengeList.this, DebugMe.class);
                startActivity(l1i);
                break;

            case R.id.buttonlevel2:
                Intent l2i = new Intent(ChallengeList.this, FileRead.class);
                startActivity(l2i);
                break;

            case R.id.buttonlevel3:
                Intent l3i = new Intent(ChallengeList.this, StringsSecrets.class);
                startActivity(l3i);
                break;

            case R.id.buttonlevel4:
                Intent l4i = new Intent(ChallengeList.this, Res_raw.class);
                startActivity(l4i);
                break;

            case R.id.buttonlevel5:
                Intent l5i = new Intent(ChallengeList.this, SharedBreach.class);
                startActivity(l5i);
                break;

            case R.id.buttonlevel6:
                Intent l6i = new Intent(ChallengeList.this, DBLeak.class);
                startActivity(l6i);
                break;

            case R.id.buttonlevel7:
                Intent l7i = new Intent(ChallengeList.this, ExportedInfo.class);
                startActivity(l7i);
                break;

            case R.id.buttonlevel8:
                Intent l8i = new Intent(ChallengeList.this, Decode.class);
                startActivity(l8i);
                break;

            case R.id.buttonlevel9:
                Intent l9i = new Intent(ChallengeList.this, SmaliInject.class);
                startActivity(l9i);
                break;

            case R.id.buttonlevel10:
                Intent l10i = new Intent(ChallengeList.this, BadComm.class);
                startActivity(l10i);
                break;

            case R.id.buttonlevel11:
                Intent l11i = new Intent(ChallengeList.this, CustomAccess.class);
                startActivity(l11i);
                break;

            case R.id.buttonlevel12:
                Intent l12i = new Intent(ChallengeList.this, Frida1.class);
                startActivity(l12i);
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
