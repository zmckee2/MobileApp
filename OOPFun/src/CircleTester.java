public class CircleTester {
    public static void main(String[] args) {
        Circle[] cArr = new Circle[5];
        for(int i = 0; i < cArr.length; i++){
            cArr[i] = new Circle(i*2.5,new Circle.Point(i,i));
        }

        for(Circle c : cArr)
            System.out.println(c);
    }

}
