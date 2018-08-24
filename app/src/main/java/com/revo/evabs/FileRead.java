package com.revo.evabs;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class FileRead extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_read);

        Button filehint = (Button) findViewById(R.id.buttonfilehint);
        final TextView tvhint = (TextView) findViewById(R.id.textViewfilehint);

        AssetManager am = getAssets();
        InputStream iput;

        filehint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvhint.setText("Where do you store the 'assets' of/in an APK? Maybe you could see inside the apk :)");
            }
        });
        try {
            iput = am.open("secrets");
            int size = iput.available();
            byte[] buffer = new byte[size];
            iput.read(buffer);
            iput.close();
            final String secret = new String(buffer);

        }
                catch (IOException e) {
                    e.printStackTrace();
                }
    }
}


