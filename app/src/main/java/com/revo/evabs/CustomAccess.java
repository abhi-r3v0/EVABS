package com.revo.evabs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAccess extends AppCompatActivity {

    public final String EVABS_SENSOR_KEY = "com.revo.evabs.action.SENSOR_KEY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_access);

        Button btncustomaccess = (Button) findViewById(R.id.buttoncustomaccess);
        btncustomaccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetSensorKey();
            }
        });

        final TextView tvhintcust = (TextView) findViewById(R.id.textViewhintcust);
        Button hintcustom = (Button) findViewById(R.id.buttonhintcustperm);
        hintcustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvhintcust.setText("Can you trick a custom action?");
            }
        });
    }

    private void GetSensorKey() {
        EditText et = (EditText) findViewById(R.id.editTextcustomaccess);
        String tosplit = et.getText().toString();
        char split[] = {99, 117, 115, 116, 48, 109, 95, 112, 51, 114, 109};
        String fromsplit = new String(split);

        if(fromsplit.equals(tosplit)){
            Toast.makeText(CustomAccess.this,"SYS_CTRL: CREDS ACCEPTED. SENSOR_KEY SENT", Toast.LENGTH_LONG).show();
            Intent sendSensorkey = new Intent(EVABS_SENSOR_KEY);
            sendSensorkey.putExtra(Intent.EXTRA_TEXT, "EVABS{"+ stringFromJNI() + "}");
            sendSensorkey.setType("text/plain");
            startActivity(sendSensorkey);
        }

        else{
            Toast.makeText(CustomAccess.this, "SYS_CTRL: WRONG_CREDS. SENSOR_KEY LOCKED", Toast.LENGTH_LONG).show();
        }
    }

    static
    {
        System.loadLibrary("native-lib");
    }

    public native String stringFromJNI();
}
