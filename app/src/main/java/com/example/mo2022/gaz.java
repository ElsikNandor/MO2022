package com.example.mo2022;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class gaz extends AppCompatActivity {
    Button mButton;
    EditText eregiar, eujar, ehatar, efogyasztas;
    TextView teredmeny;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaz);
    }
    public void szamolClickGaz(View v) {
        eregiar = findViewById(R.id.eregiargaz);
        eujar = findViewById(R.id.eujargaz);
        ehatar = findViewById(R.id.ehatargaz);
        efogyasztas = findViewById(R.id.efogyasztasgaz);
        mButton = findViewById(R.id.buttongaz);
        teredmeny = findViewById(R.id.erdgaz);
        int regiar,ujar,hatar,fogyasztas, szujf, szregiar,szujar ;
        regiar = 0;
        ujar = 0;
        hatar = 0;
        fogyasztas = 0;
        String er = "";
        if ( mezok(eregiar) && mezok(eujar) && mezok(ehatar) && mezok(efogyasztas) )
        {
            regiar = Integer.parseInt(eregiar.getText().toString());
            ujar = Integer.parseInt(eujar.getText().toString());
            hatar = Integer.parseInt(ehatar.getText().toString());
            fogyasztas = Integer.parseInt(efogyasztas.getText().toString());

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
        int itmp;
        try {
            itmp = Integer.parseInt(tx.getText().toString());
        } catch(NumberFormatException nfe) {
            tx.setTextColor(Color.parseColor("#FF0000"));
            return false;
        }
        return true;
    }


}