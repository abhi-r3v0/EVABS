package com.revo.evabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SmaliInject extends AppCompatActivity {

    String SIGNAL = "LAB_OFF";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smali_inject);

        Button smali = (Button) findViewById(R.id.buttonlabon);
        Button smalihint = (Button) findViewById(R.id.buttonhintsmali);
        final TextView labstat = (TextView) findViewById(R.id.textViewlabstatus);
        final TextView tvsmalihint = (TextView) findViewById(R.id.textViewsmalihint);
        final TextView tvlaboff = (TextView) findViewById(R.id.textViewlaboff);

        smalihint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvsmalihint.setText("apktool? Editing smali? Repackaging?");
            }
        });


        smali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ctrl = stringFromJNI();

                if (SIGNAL.equals(ctrl)){
                    tvlaboff.setText("SYS_CTRL_CODE: LAB_ON");
                    labstat.setText("SYS_CTRL: ACCESS_GRANTED. LAB UNLOCKED");
                }
                else{
                    tvlaboff.setText("SYS_CTRL_CODE: LAB_OFF");
                    labstat.setText("SYS_CTRL: ACCESS_DENIED");
                }
            }
        });

    }

    static
    {
        System.loadLibrary("native-lib");
    }

    public native String stringFromJNI();
}
