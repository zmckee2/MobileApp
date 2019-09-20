import sun.awt.geom.AreaOp;

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
