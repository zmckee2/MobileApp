/**
 * This program contains the object behavior the cell helper class
 * CPSC 312-02, Fall 2019
 * Programming Assignment #5
 * File originally my from PA2
 *
 * @author Zach McKee
 * @verision 1.0 10/22/2019
 */
package com.example.pa5;

public class Cell {
    private Coordinates coordinate;
    private char symbol;

    public Cell() {
        coordinate = new Coordinates(-1,-1);
        symbol = '-';
    }

    public Cell(Coordinates coordinate) {
        this.coordinate = coordinate;
        this.symbol = '-';
    }
    
    public Cell(int x, int y)
    {
        coordinate = new Coordinates(x,y);
        symbol = '-';
    }

    public Cell(Coordinates coordinate, char symbol) {
        this.coordinate = coordinate;
        this.symbol = symbol;
    }

    public Coordinates getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinates coordinate) {
        this.coordinate = coordinate;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    
    public String toString()
    {
        return symbol + "";
    }
}
