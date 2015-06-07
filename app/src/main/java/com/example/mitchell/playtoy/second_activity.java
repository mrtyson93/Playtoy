package com.example.mitchell.playtoy;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

//TODO running score of winners
//TODO alternate who starts first
//TODO make it clear who's turn it is
//TODO display for when there is a winner instead of restarting app
//TODO human vs cpu popup when tic tac toe button is pressed(Brown)

@SuppressWarnings("deprecation")
public class second_activity extends ActionBarActivity {

    //returns true if there is a winner
    private boolean setChar(Button modifying, int[] count, int xCor, int yCor, TTTBoard Board){

        boolean returning = false;
        //only sets tile as played if it hasn't been played before
        if(Board.isEmpty(xCor, yCor) && count[0] < 9){
            returning = Board.setChar(modifying, count, xCor, yCor);

            //this alternates the highlight for whose turn it is
            if(count[0]%2 == 0){
                findViewById(R.id.textView2).setBackgroundColor(0xff222222);
                findViewById(R.id.textView5).setBackgroundColor(0xff222222);
                findViewById(R.id.textView4).setBackgroundColor(0xff575757);
                findViewById(R.id.textView3).setBackgroundColor(0xff575757);
            }
            else{
                findViewById(R.id.textView4).setBackgroundColor(0xff222222);
                findViewById(R.id.textView3).setBackgroundColor(0xff222222);
                findViewById(R.id.textView2).setBackgroundColor(0xff575757);
                findViewById(R.id.textView5).setBackgroundColor(0xff575757);
            }

            count[0]++; //incerement count

        }

        //if count[0] reaches nine it means there is either a draw or a winner
        //either way this denotes that a game is over
        if(count[0] == 9) returning = true;

        return returning;
    }

    //used to keep track of moves played, never greater than 9
    //[1] is x's score, [2] is y, 0 is the number of the move the player has made
    private final int[] count = {0,0,0};

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

        TextView xScore = (TextView) findViewById(R.id.textView5);
        TextView oScore = (TextView) findViewById(R.id.textView3);

        //sets the score on the scoreboard
        xScore.setText("" + count[1]);
        oScore.setText("" + count[2]);

        //this is the actual played game board used for calculations
        final TTTBoard Board = new TTTBoard();

        //same thing for all nine tiles, calls setChar if clicked
        //if there is a winner, it calls clear board
        topLeft.setOnClickListener(v -> {
            if(setChar(topLeft, count, 0, 0, Board)) {
                Board.clearBoard();
                clearBoard();
            }
        });
        topMiddle.setOnClickListener(v -> {
            if(setChar(topMiddle, count, 1, 0, Board)) {
                Board.clearBoard();
                clearBoard();
            }
        });
        topRight.setOnClickListener(v -> {
            if(setChar(topRight, count, 2, 0, Board)) {
                Board.clearBoard();
                clearBoard();
            }
        });
        centerLeft.setOnClickListener(v -> {
            if(setChar(centerLeft, count, 0, 1, Board)){
                Board.clearBoard();
                clearBoard();
            }
        });
        centerMiddle.setOnClickListener(v -> {
            if(setChar(centerMiddle, count, 1, 1, Board)){
                Board.clearBoard();
                clearBoard();
            }
        });
        centerRight.setOnClickListener(v -> {
            if(setChar(centerRight, count, 2, 1, Board)){
                Board.clearBoard();
                clearBoard();
            }
        });
        bottomLeft.setOnClickListener(v -> {
            if (setChar(bottomLeft, count, 0, 2, Board)){
                Board.clearBoard();
                clearBoard();
            }
        });
        bottomMiddle.setOnClickListener(v -> {
            if(setChar(bottomMiddle, count, 1, 2, Board)){
                Board.clearBoard();
                clearBoard();
            }
        });
        bottomRight.setOnClickListener(v -> {
            if (setChar(bottomRight, count, 2, 2, Board)){
                Board.clearBoard();
                clearBoard();
            }
        });




    }

    public void clearBoard(){

        findViewById(R.id.textView4).setBackgroundColor(Color.parseColor("#ff222222"));
        findViewById(R.id.textView3).setBackgroundColor(Color.parseColor("#ff222222"));
        findViewById(R.id.textView2).setBackgroundColor(Color.parseColor("#ff575757"));
        findViewById(R.id.textView5).setBackgroundColor(Color.parseColor("#ff575757"));

        final Button topLeft = (Button) findViewById(R.id.TopLeft);
        final Button topMiddle = (Button) findViewById(R.id.TopMiddle);
        final Button topRight = (Button) findViewById(R.id.TopRight);
        final Button centerLeft = (Button) findViewById(R.id.CenterLeft);
        final Button centerMiddle = (Button) findViewById(R.id.CenterMiddle);
        final Button centerRight = (Button) findViewById(R.id.CenterRight);
        final Button bottomLeft = (Button) findViewById(R.id.BottomLeft);
        final Button bottomMiddle = (Button) findViewById(R.id.BottomMiddle);
        final Button bottomRight = (Button) findViewById(R.id.BottomRight);

        topLeft.setText(" ");
        topMiddle.setText(" ");
        topRight.setText(" ");
        centerLeft.setText(" ");
        centerMiddle.setText(" ");
        centerRight.setText(" ");
        bottomLeft.setText(" ");
        bottomMiddle.setText(" ");
        bottomRight.setText(" ");

        //score textviews
        TextView xScore = (TextView) findViewById(R.id.textView5);
        TextView oScore = (TextView) findViewById(R.id.textView3);

        //sets the score on the scoreboard
        xScore.setText("" + count[1]);
        oScore.setText("" + count[2]);

        count[0] = 0;

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
