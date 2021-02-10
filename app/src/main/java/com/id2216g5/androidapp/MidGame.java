package com.id2216g5.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MidGame extends AppCompatActivity {
    String status = "";
    int roundNr=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_midgame);

        TextView round = findViewById(R.id.midgameHeading);
        TextView plcaceholder1 = findViewById(R.id.midgameUserPlcaceholder1);
        TextView plcaceholder2 = findViewById(R.id.midgameUserPlcaceholder2);
        TextView plcaceholder3 = findViewById(R.id.midgameUserPlcaceholder3);

        if(savedInstanceState != null){
            roundNr = savedInstanceState.getInt("round")+1;
            round.append(String.valueOf(roundNr));
        }else{
            roundNr=roundNr+1;
            round.append(String.valueOf(roundNr));
        }

        switch(status) {
            case "case1":
                plcaceholder1.setText("Rille");
                plcaceholder3.setText("user");
                break;
            case "case2":
                plcaceholder1.setText("user");
                plcaceholder3.setText("Rille");
                break;
            default:
                plcaceholder1.setText("Rille");
                plcaceholder2.setText("user");
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        savedInstanceState.putInt("round", roundNr);

    }
}