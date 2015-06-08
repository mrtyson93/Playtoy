package com.example.mitchell.playtoy;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;

/**
 * Created by Mitchell Tyson on 5/16/2015.
 */
public class tttDraw extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ttt_winner_pop);

        /**** tried doing some UX based off of screen size here*****/

        //dispay metrics to get screen size
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.3));

        Button winnerButton = (Button) findViewById(R.id.winnerBtn);

        winnerButton.setText("Draw");
        winnerButton.setTextSize((int) (height * 0.035));

        winnerButton.setOnClickListener(v -> finish());
    }
}
