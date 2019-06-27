package com.example.yair;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et;
    String str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.editText);

        AlertDialog.Builder adb;

        adb = new AlertDialog.Builder(this);

        adb.setTitle("full name");

        final EditText editText = new EditText(this);

        adb.setView(et);
        adb.setPositiveButton("Send", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                str = et.getText().toString();
                if (str.equals(""))
                    str = "Nothing";
            }
        });

        adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.create();
        adb.show();
    }

    public void go(int id) {

        if (id == 1) {
            str = et.getText().toString();
        }
        if (id == 2) {
            str = "Null";
        }

        Intent datago = new Intent(this, Main2Activity.class);
        datago.putExtra("str", str);
        startActivity(datago);
    }

    final DialogInterface.OnClickListener myClick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which == DialogInterface.BUTTON_POSITIVE) {
                go(1);
            }
            if (which == DialogInterface.BUTTON_NEGATIVE) {
                go(2);
            }
        }
    };

    public boolean onCreateOptionsMenu (Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int nextActivity = item.getItemId();
        if (nextActivity == R.id.NextActivity) {
            Intent go = new Intent(this, Main2Activity.class);
            startActivity(go);
        }


        return true;


    }



}
