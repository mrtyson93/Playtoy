package com.example.mitchell.playtoy;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

//TODO running score of winners
//TODO alternate who starts first
//TODO make it clear who's turn it is
//TODO display for when there is a winner instead of restarting app
//TODO human vs cpu popup when tic tac toe button is pressed(Brown)

@SuppressWarnings("deprecation")
public class second_activity extends ActionBarActivity {

    private void setChar(Button modifying, int[] count, int xCor, int yCor, TTTBoard Board){

        //only sets tile as played if it hasn't been played before
        if(Board.isEmpty(xCor, yCor) && count[0] < 9){
            Board.setChar(modifying, count[0], xCor, yCor);
            count[0]++;
        }
    }

    //used to keep track of moves played, never greater than 9
    private final int[] count = {0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        final Button topLeft = (Button) findViewById(R.id.TopLeft);
        final Button topMiddle = (Button) findViewById(R.id.TopMiddle);
        final Button topRight = (Button) findViewById(R.id.TopRight);
        final Button centerLeft = (Button) findViewById(R.id.CenterLeft);
        final Button centerMiddle = (Button) findViewById(R.id.CenterMiddle);
        final Button centerRight = (Button) findViewById(R.id.CenterRight);
        final Button bottomLeft = (Button) findViewById(R.id.BottomLeft);
        final Button bottomMiddle = (Button) findViewById(R.id.BottomMiddle);
        final Button bottomRight = (Button) findViewById(R.id.BottomRight);

        //this is the actual played game board used for calculations
        final TTTBoard Board = new TTTBoard();

        //same thing for all nine tiles, calls setChar if clicked
        topLeft.setOnClickListener(v -> setChar(topLeft, count, 0, 0, Board));
        topMiddle.setOnClickListener(v -> setChar(topMiddle, count, 1, 0, Board));
        topRight.setOnClickListener(v -> setChar(topRight, count, 2, 0, Board));
        centerLeft.setOnClickListener(v -> setChar(centerLeft, count, 0, 1, Board));
        centerMiddle.setOnClickListener(v -> setChar(centerMiddle, count, 1, 1, Board));
        centerRight.setOnClickListener(v -> setChar(centerRight, count, 2, 1, Board));
        bottomLeft.setOnClickListener(v -> setChar(bottomLeft, count, 0, 2, Board));
        bottomMiddle.setOnClickListener(v -> setChar(bottomMiddle, count, 1, 2, Board));
        bottomRight.setOnClickListener(v -> setChar(bottomRight, count, 2, 2, Board));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
