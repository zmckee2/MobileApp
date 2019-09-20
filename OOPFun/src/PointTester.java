import java.util.Arrays;

public class PointTester {

    public static void main(String[] args) {
        Circle.Point p1 = new Circle.Point();
        Circle.Point p2 = new Circle.Point(4,5);
        System.out.println("p1: " + p1 + "\np2:" + p2);

        p1.setX(2000);
        p1.setY(4);
        p2.setX(10);
        p2.setY(10);
        System.out.println("p1: " + p1 + "\np2:" + p2);

        Circle.Point[] pArr = new Circle.Point[5];
        for(int i = 0; i < pArr.length; i++)
            pArr[i] = new Circle.Point(i,i);

        System.out.println(Arrays.toString(pArr));
//        for(int i = 0; i < pArr.length; i++)
//            System.out.print(pArr[i]);
    }

}
