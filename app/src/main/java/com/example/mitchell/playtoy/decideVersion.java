package com.example.mitchell.playtoy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Mitchell Tyson on 5/16/2015.
 */
public class decideVersion extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ttt_popup_decide);

        /**** tried doing some UX based off of screen size here*****/

        //dispay metrics to get screen size
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.5));

        Button Human = (Button) findViewById(R.id.vHum);
        Button Comp  = (Button) findViewById(R.id.vComp);

        ((TextView) findViewById(R.id.textView6)).setTextSize((int) (height*0.018));

        ((Button) findViewById(R.id.vHum)).setWidth((int) (width * 0.6));
        ((Button) findViewById(R.id.vComp)).setWidth((int) (width*0.6));

        ((Button) findViewById(R.id.vHum)).setHeight((int) (height * 0.1));
        ((Button) findViewById(R.id.vComp)).setHeight((int) (height*0.1));

        ((Button) findViewById(R.id.vHum)).setTextSize((int) (height * 0.01));
        ((Button) findViewById(R.id.vComp)).setTextSize((int) (height*0.01));


        //starts intent to start the game
        Human.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), second_activity.class)));
        Comp.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), second_activity.class)));

    }
}
