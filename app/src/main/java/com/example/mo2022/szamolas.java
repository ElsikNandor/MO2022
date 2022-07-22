package com.example.mo2022;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//Villany számolás 1.0 2022-07-18

public class szamolas extends AppCompatActivity {
    Button mButton;
    EditText eregiar, eujar, ehatar, efogyasztas;
    TextView teredmeny, tbekezdes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_szamolas);

        eregiar = findViewById(R.id.eregiar);
        eujar = findViewById(R.id.eujar);
        ehatar = findViewById(R.id.ehatar);
        efogyasztas = findViewById(R.id.efogyasztas);
        mButton = findViewById(R.id.button);
        tbekezdes = findViewById(R.id.bekezdes);
        String uzenet = getIntent().getStringExtra("gomb");
        Log.i("Klikk", uzenet);
        Log.i("Klikk", String.valueOf(eregiar.getText()));
        if(uzenet.toString().equals("villany"))
        {
            setTitle("Villanyfogyasztás számolás");
            eregiar.setText("37");
            eujar.setText("70.1");
            ehatar.setText("210");
            efogyasztas.setText("210");
            tbekezdes.setText("A1 és A2 árszabás esetén a számolt értékek:");
            //Log.i("Klikk", String.valueOf(eregiar.getText()));
        }

       // Log.i("Klikk", String.valueOf(eregiar.getText()));

        if(uzenet.toString().equals("gaz"))
        {
            setTitle("Gázfogyasztás számolás");
            eregiar.setText("102");
            eujar.setText("747");
            ehatar.setText("144");
            efogyasztas.setText("144");
            tbekezdes.setText("Lakossági fogyasztás esetén számolt értékek:");

        }


    }
    public void szamolClick(View v)
    {
        teredmeny = findViewById(R.id.erd);
        float regiar,ujar,hatar,fogyasztas, szujf, szregiar,szujar ;
        regiar = 0;
        ujar = 0;
        hatar = 0;
        fogyasztas = 0;
        String er = "";
        if ( mezok(eregiar) && mezok(eujar) && mezok(ehatar) && mezok(efogyasztas) )
        {
            regiar = Float.parseFloat(eregiar.getText().toString());
            ujar = Float.parseFloat(eujar.getText().toString());
            hatar = Float.parseFloat(ehatar.getText().toString());
            fogyasztas = Float.parseFloat(efogyasztas.getText().toString());

            if( fogyasztas < hatar)
            {
                szregiar = fogyasztas  * regiar;
            }
            else
            {
                szregiar = hatar * regiar;
            }


            if ( (szujf = (fogyasztas-hatar)) > 0 )
            {
                szujar = szujf * ujar;
            }
            else
            {
                szujar = 0;
            }
            er = "Az ár régi része: ";
            er += String.valueOf(szregiar);
            er = er + "\n";
            er = er + "Az ár új része: ";
            er += String.valueOf(szujar);
            er = er + "\n";
            er = er + "Teljes ár: ";
            er += String.valueOf(szregiar + szujar);
            //teredmeny.setText( String.valueOf(szregiar+szujar));
            teredmeny.setText( er );
            teredmeny.setVisibility(View.VISIBLE);
        }

    }

    public boolean mezok(EditText tx)
    {
        float itmp;
        try {
            itmp = Float.parseFloat(tx.getText().toString());
        } catch(NumberFormatException nfe) {
            tx.setTextColor(Color.parseColor("#FF0000"));
            Toast.makeText(this,
                    "Csak számot lehet a mezőkbe írni.\nTört tagolás a ponttal.",
                    Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}