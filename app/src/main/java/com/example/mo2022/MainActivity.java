package com.example.mo2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Button button = (Button) findViewById(R.id.bvillany);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Klikk", "Villany gomb");
                // Do something in response to button click
                Intent i = new Intent(this, szamolas.class);
                i.putExtra("MY_STRING","hello");
                startActivity(i);
            }
        });

        Button buttong = (Button) findViewById(R.id.bgaz);
        buttong.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Klikk", "Gaz gomb");
                // Do something in response to button click
            }
        });*/
    }

    public void villanyClick( View v)
    {
        Intent i = new Intent(this, szamolas.class);
        i.putExtra("gomb","villany");
        startActivity(i);
        Log.i("Klikk", "1");
    }

    public void gazClick( View v)
    {
        Intent i = new Intent(this, szamolas.class);
        i.putExtra("gomb","gaz");
        startActivity(i);
        Log.i("Klikk", "Gaz");
    }
}