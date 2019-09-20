import java.util.Arrays;

public class PublicationTester {
    public static void main(String[] args) {
        //Tasks:
        //1. Define general publication class
        //2. Subclass publication

        Publication p1 = new Book("a", "a", 200, 400.5, "Zach"); //<----- polymorphism static binding
        Book p2 = new Book("a", "b", 200, 400.5, "Zach");
        Book p3 = new Book("b", "Zach's publisher", 200, 400.5, "Zach");
        Magazine m1 = new Magazine();
        Publication m2 = new Magazine("Zach's mag", "Zach's pub", 50,.50,"HOURLY");
//        System.out.println("Books:\n" + p1 + "\n" + p2 + "\n" + p3.generateCopyright());
//        System.out.println("Mags:\n" + m1 + "\n" + m2);

        //ps doesn't know what type each of its elements are except that they're
        //publication or its subtypes
        Publication[] ps = {p1, p2, p3, m1, m2};
        for(Publication p: ps)
            System.out.println(p); //<-- this is the dynamic binding polymorphism
        System.out.println();
        System.out.println();
        Arrays.sort(ps);
        System.out.println(Arrays.toString(ps));
                                   //This is where it finds out it's actuall type
        //Polymorphism: Same code, different behavior
    }
}
