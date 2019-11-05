/**
 * This program contains the object behavior for a tic tac toe board
 * CPSC 312-02, Fall 2019
 * Programming Assignment #5
 * File originally my from PA2, slightly modified
 *
 * @author Zach McKee
 * @verision 1.1 10/22/2019
 */
package com.example.pa5;

public class TicTacToeBoard {
    private int N = 3; //Default board size
    private Cell[][] grid;

    public TicTacToeBoard() {
        grid =  new Cell[N][N];
        for(int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                grid[i][j] = new Cell(i, j);
    }

    public TicTacToeBoard(int n) {
        N = n;
        grid = new Cell[N][N];
        for(int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                grid[i][j] = new Cell(i, j);
    }

    public boolean isValidMove(int x, int y)
    {
        if(x >= N || y >= N)
            return false;
        return grid[x][y].toString().equals("-");
    }

    public void makeMove(int x, int y, char playerSymbol)
    {
        if(isValidMove(x,y))
        {
            grid[x][y].setSymbol(playerSymbol);
        }
    }

    public boolean isWinner(char playerSymbol) {
        String winString = "";
        //Generate a string that would represent a win
        for (int i = 0; i < N; i++)
            winString += playerSymbol;

        String curRow = "";
        //Check each row
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                curRow += grid[i][j];
            }
            if (curRow.equals(winString))
                return true;
            curRow = "";
        }

        //Check each column
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                curRow += grid[j][i];
            }
            if (curRow.equals(winString))
                return true;
            curRow = "";
        }

        //Check each diagonal
        String curAltRow = "";
        for (int i = 0; i < N; i++)
        {
            curRow += grid[i][i];
            curAltRow += grid[N-i-1][i];
        }
        if(curRow.equals(winString) || curAltRow.equals(winString))
            return true;

        //If no win was detected, return false
        return false;
    }

    public String toString()
    {
        String topRow = " ";
        for(int i = 0; i < N; i++)
        {
            topRow += " " + i;
        }
        String retString = topRow + "\n";
        for(int i = 0; i < N; i++){
            retString += i;
            for(int j = 0; j < N; j++){
                retString += " " + grid[i][j];
            }
            retString += "\n";
        }
        return retString + "\n";
    }
}
