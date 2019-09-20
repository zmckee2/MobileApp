import java.util.Arrays;
import java.util.Random;

public class InterfaceTester {
    public static void main(String[] args) {
        System.out.println("Output 1: " + "zags".compareTo("apple"));
        System.out.println("Output 2: " + "zags".compareTo("Zags"));
        System.out.println("Output 3: " + "zags".compareTo("zigs"));
        System.out.println("Output 4: " + "zags".compareTo("zags"));
        System.out.println("Output 5: " + "zags".equals("zags"));
        System.out.println("Output 6: " + "zags".equals("Zags"));
        Circle myCircle = new Circle();
        System.out.println("Output 7: " + myCircle.equals(myCircle));
        System.out.println("Output 8: " + new Circle().equals(new Circle()));
        /*
        QUESTIONS
        1. What does compareTo return with strings?
            It returns how far the strings are lexograpgicaly apart, 0 if they're equal
        2. When would you use compareTo()
            To see how far apart the two strings are, or checking how unequal the strings are
        3. What does equals return when comparing two strings?
            A boolean whether they're the same word or not
        4. What does equals return when comparing circles?
            It returns if the references are equal (if they are the exact same object)
        5. What is the general use for equals
            You can use it to see if the references are the same, but if it's implemented, to see if the values are the same
        6. What happens when you try to run the following code? sout(myCircle.compareTo)?
            It won't work because compareTo isn't implemented in circle. Gotta impelment the comparable interface
         */
        Circle mC = new Circle(2, new Circle.Point(1,2));
        Circle mD = new Circle(2, new Circle.Point(-1,2));
        System.out.println("Output 9: " + mD.compareTo(mC));

        Random r = new Random();
        //Sorting
        Circle[] cArr = new Circle[5];
        for(int i = 0; i < cArr.length; i++)
            cArr[i] = new Circle(r.nextDouble(), new Circle.Point(i,i));
        System.out.println(Arrays.toString(cArr));
        Arrays.sort(cArr); //<--- uses compareTo to do the sorting. Would not work without the comparable interface
        System.out.println(Arrays.toString(cArr));

        //Polymorphism baybeeee
        Comparable m = myCircle;
        Shape s = myCircle;

        //Anonymous class

        Shape myAnonymousShape = new Shape() {

            @Override
            public double computePermiter() {
                return 20;
            }

            @Override
            public double computeArea() {
                return 25;
            }

            @Override
            public String toString() {
                return "{Length: 5}";
            }
        };

        Shape[] shapeArr = {mD, new Rectangle(), new Circle(), new Shape() {

            @Override
            public double computePermiter() {
                return 20;
            }

            @Override
            public double computeArea() {
                return 25;
            }

            @Override
            public String toString() {
                return "{Length: 5}";
            }
        }};
        System.out.println("~~~~~~~~~~~~~~~");
        for(Shape curS : shapeArr)
        {
            System.out.println(curS);
            System.out.println(curS.computeArea());
            System.out.println(curS.computePermiter());
            System.out.println("~~~~~~~~~~~~~~~~~~");
        }
    }
}
