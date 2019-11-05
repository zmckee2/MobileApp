/**
 * This program runs the backend game logic for Tic Tac Toe
 * CPSC 312-02, Fall 2019
 * Programming Assignment #5
 * Icons from flaticon, Author freepik
 *
 * @author Zach McKee
 * @version v1.0 10/22/2019
 */
package com.example.pa5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    public static String TAG = "GameActivityTag";
    //<div>Icons made by <a href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/"             title="Flaticon">www.flaticon.com</a></div>
    //<div>Icons made by <a href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/"             title="Flaticon">www.flaticon.com</a></div>
    int curPlayer = 0;
    TicTacToeBoard theBoard;
    String playerOneName;
    String playerTwoName;
    int numMoves = 0;
    char[] playerSymbols = {'x','o'};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //Create the tic tac toe board and get the player names
        theBoard = new TicTacToeBoard(3);
        Intent intent = getIntent();
        playerOneName = intent.getStringExtra("player1");
        playerTwoName = intent.getStringExtra("player2");
        ((ImageView) findViewById(R.id.curPlayerImage)).setImageResource(R.drawable.turkey);
        ((TextView) findViewById(R.id.curPlayerText)).setText(playerOneName + "\'s turn");

        //Create the onClickListener
        View.OnClickListener clickAction = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ImageView button = (ImageView) view;
                runGameLogic(button);
            }
        };

        //Set all on click listeners
        findViewById(R.id.b00).setOnClickListener(clickAction);
        findViewById(R.id.b01).setOnClickListener(clickAction);
        findViewById(R.id.b02).setOnClickListener(clickAction);
        findViewById(R.id.b10).setOnClickListener(clickAction);
        findViewById(R.id.b11).setOnClickListener(clickAction);
        findViewById(R.id.b12).setOnClickListener(clickAction);
        findViewById(R.id.b20).setOnClickListener(clickAction);
        findViewById(R.id.b21).setOnClickListener(clickAction);
        findViewById(R.id.b22).setOnClickListener(clickAction);

        //Set the on click listener for the quit button
        findViewById(R.id.quitButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                GameActivity.this.finish();
            }
        });

        //Set the play again button click listener
        findViewById(R.id.playAgainButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                GameActivity.this.finish();
                startActivity(intent);
            }
        });

    }

    /**
     * runGameLogic
     * This method runs the backend tic tac toe game logic
     * @param button
     */
    private void runGameLogic(ImageView button) {
        //Disallow moves if there' a winner
        if (theBoard.isWinner('o') || theBoard.isWinner('x'))
            return;
        String butId = button.getTag().toString();
        int x = Integer.parseInt(butId.substring(0, 1));
        int y = Integer.parseInt(butId.substring(1));
        if (!theBoard.isValidMove(x, y)) {
            Toast.makeText(GameActivity.this, "Invalid move, try again", Toast.LENGTH_SHORT).show();
            return;
        }
        theBoard.makeMove(x, y, playerSymbols[curPlayer]);
        numMoves++;
        //Set the icon of the button
        if(curPlayer == 0) {
            button.setImageResource(R.drawable.turkey);
        } else {
            button.setImageResource(R.drawable.pilgrim);
        }
        //See if there's a winner
        if (theBoard.isWinner(playerSymbols[curPlayer])) {
            finishGame("Winner");
            return;
        }
        //See if there's a tie game
        if (numMoves == 9){
            finishGame("No Winner");
            return;
        }
        //Set the current player icon and info box
        if(curPlayer == 0)
        {
            ((ImageView) findViewById(R.id.curPlayerImage)).setImageResource(R.drawable.pilgrim);
            ((TextView) findViewById(R.id.curPlayerText)).setText(playerTwoName + "\'s turn");
            curPlayer++;
        } else {
            ((ImageView) findViewById(R.id.curPlayerImage)).setImageResource(R.drawable.turkey);
            ((TextView) findViewById(R.id.curPlayerText)).setText(playerOneName + "\'s turn");
            curPlayer--;
        }
    }

    /**
     * finishGame
     * This method is ran once the game ends
     * @param result
     */
    private void finishGame(String result)
    {
        String winner;
        if(curPlayer == 0)
            winner = playerOneName;
        else
            winner = playerTwoName;
        if(result.equals("Winner"))
            ((TextView) findViewById(R.id.curPlayerText)).setText("Congrats, " + winner + "! You won!\nPlay Again?");
        else
            ((TextView) findViewById(R.id.curPlayerText)).setText("Too bad! No Winner\nPlay Again?");
        Button playAgainButton = findViewById(R.id.playAgainButton);
        playAgainButton.setEnabled(true);
        playAgainButton.setVisibility(View.VISIBLE);
    }
}
