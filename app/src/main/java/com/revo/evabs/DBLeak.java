package com.revo.evabs;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DBLeak extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbleak);
        String unseen = stringFromJNI();
        SQLiteDatabase coords = openOrCreateDatabase("MAINFRAME_ACCESS", MODE_PRIVATE, null);
        coords.execSQL("CREATE TABLE IF NOT EXISTS CREDS(admin VARCHAR, pass VARCHAR, access VARCHAR);");
        coords.execSQL("INSERT INTO CREDS VALUES('Dr.l33t', '" + unseen + "' , 'ADMIN');");
        coords.execSQL("INSERT INTO CREDS VALUES('Mr BufferOverflow', '0xNotSecureSQLite_', 'STAFF');");
        coords.execSQL("INSERT INTO CREDS VALUES('Ms HeapSpray', 'SQLite_expl0it', 'USER');");

        Cursor res = coords.rawQuery("SELECT * FROM CREDS", null);
        res.moveToPosition(2);
        final String uname1 = res.getString(0);
        final String access1 = res.getString(2);

        res.moveToPosition(1);
        final String uname2 = res.getString(0);
        final String access2 = res.getString(2);

        final TextView tvcreds1 = (TextView) findViewById(R.id.textViewdb1);
        final TextView tvcreds2 = (TextView) findViewById(R.id.textViewdb2);

        Button credsbutton = (Button) findViewById(R.id.buttonfetchcreds);
        credsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvcreds1.setText("User: " + uname1 + ", Access: " + access1);
                tvcreds2.setText("User: " + uname2 + ", Access: " + access2);
            }
        });

        final TextView tvdbhint = (TextView) findViewById(R.id.textViewdbhint);
        Button buttondbhint = (Button) findViewById(R.id.buttondbhint);
        buttondbhint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvdbhint.setText("Where are the SQLite DB files stored in an Android device?");
            }
        });
    }

    static {
        System.loadLibrary("native-lib");
    }

    public native String stringFromJNI();
}
