import java.util.Objects;

public class PointOld {
    private int x;
    private int y;

    public PointOld() {
        x = 0;
        y = 0;
    }

    public PointOld(int newX, int newY)
    {
        x = newX;
        y = newY;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointOld point = (PointOld) o;
        return x == point.x &&
                y == point.y;
    }


    @Override
    public String toString() {return "(" + x + "," + y +")--";}
}
