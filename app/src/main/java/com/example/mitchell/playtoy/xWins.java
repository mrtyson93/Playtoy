package com.example.mitchell.playtoy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Mitchell Tyson on 5/16/2015.
 */
public class xWins extends Activity {

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

        winnerButton.setText("X Wins");
        winnerButton.setTextSize((int) (height * 0.035));

        winnerButton.setOnClickListener(v -> finish());

    }
}
