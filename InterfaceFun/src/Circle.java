public class Circle implements Comparable<Circle>, Shape{
    private double radius;
    private Point center;

    public Circle() {
        radius = 1.0;
        center = new Point(0,0);
    }

    public Circle(double radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public String toString() {return "{Radius: " + radius + ", Center at: " + center + "}";}

    @Override
    public int compareTo(Circle o) {
        if(o.radius > this.radius)
            return -1;
        else if (o.radius < this.radius)
            return 1;
        return this.center.compareTo(o.center);
    }

    @Override
    public double computePermiter() {
        return (Math.PI * Math.pow(this.radius,2));
    }

    @Override
    public double computeArea() {
        return (Math.PI * 2 * this.radius);
    }

    //NESTED CLASSES
    //A class in it's file (non-nested) is an outer class
    //outer classes can be public or package private

    //4 types of nested classes
    //1: static nested class
    //2: non-static nested classes (inner class)
    //3: local inner class (defined in a method)
    //4: Annonomous inner class (local with no name)

    public static class Point implements Comparable<Point>{
        private int x;
        private int y;

        public Point() {
            x = 0;
            y = 0;
        }

        public Point(int newX, int newY)
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
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public String toString() {return "(" + x + "," + y +")";}

        @Override
        public int compareTo(Point o) {
            double distThis = Math.sqrt((this.x^2 + this.y^2));
            double distO = Math.sqrt((o.x^2 + o.y^2));
            if (distThis > distO)
                return 1;
            else if (distO > distThis)
                return -1;
            else
                return 0;
        }
    }
}
