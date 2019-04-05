package com.revo.evabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.FileNameMap;

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
        final TextView tvflag = findViewById(R.id.textViewflag);

        smalihint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvsmalihint.setText("apktool? Editing smali? Repackaging?");
            }
        });


        smali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ctrl = stringFromSmali();

                if (SIGNAL.equals("LAB_ON")){
                    tvlaboff.setText("SYS_CTRL_CODE: LAB_ON");
                    labstat.setText("SYS_CTRL: ACCESS_GRANTED. LAB UNLOCKED");
                    tvflag.setText("EVABS{" + ctrl + "}");
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

    public native String stringFromSmali();

}
