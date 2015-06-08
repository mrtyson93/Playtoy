package com.example.mitchell.playtoy;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.widget.Button;

class TTTBoard extends Activity{

    //this is the board, 0 means nothings, 1 means X, 2 means O
    private final int[][] board = new int[3][3];

    //constructs board
    public TTTBoard(){
        super();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = 0;
            }
        }
    }

    public void clearBoard() {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = 0;
            }
        }
    }

    //returns true if the space hasn't been played yet
    public boolean isEmpty(int xCor, int yCor){
        return board[xCor][yCor] == 0;
    }

    //if turn is "X" sets the game board and board in this class as so
    //same thing for "O", determined by count of game
    //this returns true if there is a winner
    public boolean setChar(Button modifying, int[] count, int xCor, int yCor){
        if(count[0]%2 == 0 ){ //checks if x wins
            modifying.setTextColor(Color.parseColor("#D51405"));
            modifying.setText("X");
            board[xCor][yCor] = 1;
            
            if(isWinner(1)){
                count[1]++;
                return true;
            }
            return false;
        }

        else{ //checks if y wins
            modifying.setTextColor(Color.parseColor("#ffffff"));
            modifying.setText("O");
            board[xCor][yCor] = 2;

            if(isWinner(2)){
                count[2]++;
                return true;
            }
            return false;
        }

    }

    //checks if there is a winner, player = 1 means x, 2 means o,
    //returns true if player has just one
    private boolean isWinner(int player) {

        //checks horizontal and vertical for winners
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player &&
                    board[i][2] == player) return true;

            if (board[0][i] == player && board[1][i] == player &&
                    board[2][i] == player) return true;

        }

        //checks for diagonals
        if(board[0][0] == player && board[1][1] == player &&
                board[2][2] == player) return true;


        if(board[2][0] == player && board[1][1] == player &&
                board[0][2] == player) return true;

        else return false;

    }

}
