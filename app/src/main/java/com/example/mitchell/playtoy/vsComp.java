package com.example.mitchell.playtoy;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

//TODO alternate who starts first
//TODO display for when there is a winner instead of restarting app

@SuppressWarnings("deprecation")
public class vsComp extends ActionBarActivity {

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
        if(count[0] == 9 && !returning){
            count[0]++;
            returning = true;
        }

        return returning;
    }

    //take the decision the computer made and mark that spot
    private boolean compMove(Button topLeft, Button topMiddle, Button topRight,
                          Button centerLeft, Button centerMiddle, Button centerRight,
                          Button bottomLeft, Button bottomMiddle, Button bottomRight, TTTBoard Board) {
        int move = decideMove(Board);
        switch(move) {
            case 0: return setChar(topLeft, count, 0, 0, Board);
            case 1: return setChar(topMiddle, count, 1, 0, Board);
            case 2: return setChar(topRight, count, 2, 0, Board);
            case 3: return setChar(centerLeft, count, 0, 1, Board);
            case 4: return setChar(centerMiddle, count, 1, 1, Board);
            case 5: return setChar(centerRight, count, 2, 1, Board);
            case 6: return setChar(bottomLeft, count, 0, 2, Board);
            case 7: return setChar(bottomMiddle, count, 1, 2, Board);
            case 8: return setChar(bottomRight, count, 2, 2, Board);
            default: return true;
        }
    }

    //logic needs to be updated but this is where the computer decides which space to take
    //right now it selects the middle if it is free, if not it goes through from TL to BR
    private int decideMove(TTTBoard Board) {
        if(Board.isTaken(1, 1) == 0) {
            return 4;
        }
        else if(Board.isTaken(0, 0) == 0) {
            return 0;
        }
        else if(Board.isTaken(1, 0) == 0) {
            return 1;
        }
        else if(Board.isTaken(2, 0) == 0) {
            return 2;
        }
        else if(Board.isTaken(0, 1) == 0) {
            return 3;
        }
        else if(Board.isTaken(2, 1) == 0) {
            return 5;
        }
        else if(Board.isTaken(0, 2) == 0) {
            return 6;
        }
        else if(Board.isTaken(1, 2) == 0) {
            return 7;
        }
        else if(Board.isTaken(2, 2) == 0) {
            return 8;
        }
        return 0;
        //other logic
    }

    //used to keep track of moves played, never greater than 9
    //[1] is x's score, [2] is y, 0 is the number of the move the player has made
    private final int[] count = {0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vshuman);

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


        //once a tile is marked by the user, immediately have the computer select its next move
        topLeft.setOnClickListener(v -> {
            if(setChar(topLeft, count, 0, 0, Board)) {
                Board.clearBoard();
                clearBoard();
            }
            else if(compMove(topLeft, topMiddle, topRight, centerLeft, centerMiddle,
                    centerRight, bottomLeft, bottomMiddle, bottomRight, Board)) {
                Board.clearBoard();
                clearBoard();
            }
        });
        topMiddle.setOnClickListener(v -> {
            if(setChar(topMiddle, count, 1, 0, Board)) {
                Board.clearBoard();
                clearBoard();
            }
            else if(compMove(topLeft, topMiddle, topRight, centerLeft, centerMiddle,
                    centerRight, bottomLeft, bottomMiddle, bottomRight, Board)) {
                Board.clearBoard();
                clearBoard();
            }
        });
        topRight.setOnClickListener(v -> {
            if(setChar(topRight, count, 2, 0, Board)) {
                Board.clearBoard();
                clearBoard();
            }
            else if(compMove(topLeft, topMiddle, topRight, centerLeft, centerMiddle,
                    centerRight, bottomLeft, bottomMiddle, bottomRight, Board)) {
                Board.clearBoard();
                clearBoard();
            }
        });
        centerLeft.setOnClickListener(v -> {
            if(setChar(centerLeft, count, 0, 1, Board)){
                Board.clearBoard();
                clearBoard();
            }
            else if(compMove(topLeft, topMiddle, topRight, centerLeft, centerMiddle,
                    centerRight, bottomLeft, bottomMiddle, bottomRight, Board)) {
                Board.clearBoard();
                clearBoard();
            }
        });
        centerMiddle.setOnClickListener(v -> {
            if(setChar(centerMiddle, count, 1, 1, Board)){
                Board.clearBoard();
                clearBoard();
            }
            else if(compMove(topLeft, topMiddle, topRight, centerLeft, centerMiddle,
                    centerRight, bottomLeft, bottomMiddle, bottomRight, Board)) {
                Board.clearBoard();
                clearBoard();
            }
        });
        centerRight.setOnClickListener(v -> {
            if(setChar(centerRight, count, 2, 1, Board)){
                Board.clearBoard();
                clearBoard();
            }
            else if(compMove(topLeft, topMiddle, topRight, centerLeft, centerMiddle,
                    centerRight, bottomLeft, bottomMiddle, bottomRight, Board)) {
                Board.clearBoard();
                clearBoard();
            }
        });
        bottomLeft.setOnClickListener(v -> {
            if (setChar(bottomLeft, count, 0, 2, Board)){
                Board.clearBoard();
                clearBoard();
            }
            else if(compMove(topLeft, topMiddle, topRight, centerLeft, centerMiddle,
                    centerRight, bottomLeft, bottomMiddle, bottomRight, Board)) {
                Board.clearBoard();
                clearBoard();
            }
        });
        bottomMiddle.setOnClickListener(v -> {
            if(setChar(bottomMiddle, count, 1, 2, Board)){
                Board.clearBoard();
                clearBoard();
            }
            else if(compMove(topLeft, topMiddle, topRight, centerLeft, centerMiddle,
                    centerRight, bottomLeft, bottomMiddle, bottomRight, Board)) {
                Board.clearBoard();
                clearBoard();
            }
        });
        bottomRight.setOnClickListener(v -> {
            if (setChar(bottomRight, count, 2, 2, Board)){
                Board.clearBoard();
                clearBoard();
            }
            else if(compMove(topLeft, topMiddle, topRight, centerLeft, centerMiddle,
                        centerRight, bottomLeft, bottomMiddle, bottomRight, Board)) {
                Board.clearBoard();
                clearBoard();
            }
        });
    }

    public void clearBoard(){

        //this starts the popup for who was won, if count[0] = 10, then its a draw
        if(count[0] == 10) startActivity(new Intent(getApplicationContext(), tttDraw.class));
        else if(count[0]%2 == 1) startActivity(new Intent(getApplicationContext(), xWins.class));
        else if(count[0]%2 == 0) startActivity(new Intent(getApplicationContext(), oWins.class));


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


        //resets play counter at 0
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
