public class Rectangle implements Shape, Comparable<Rectangle>{
    private double width;
    private double height;

    public Rectangle() {
        width = 0.0;
        height = 0.0;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double computePermiter() {
        return 2*width + 2*height;
    }

    @Override
    public double computeArea() {
        return width*height;
    }

    @Override
    public String toString() {
        return "{Width: " + width + ", Height: " + height + "}";
    }

    @Override
    public int compareTo(Rectangle o) {
        if (this.width == o.width && this.height == o.height)
            return 0;
        double thisArea = computeArea();
        double oArea = o.computeArea();
        if(thisArea > oArea)
            return 1;
        else if (oArea < thisArea)
            return -1;
        return 0;
    }
}
