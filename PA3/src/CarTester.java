/**
 * This program tests the functionality of the car class
 * It first creates cars with varying mileage, sorts them,
 * drives them, and sorts them again
 * CPSC 321-02, Fall 2019
 * Programming Assignment #3
 * No sources to cite
 *
 * @author Zach Mckee
 * @version v1.0 9/20/2019
 */
import java.util.Arrays;
import java.util.Random;

public class CarTester {
    /**
     * main
     * This method tests the cars class
     * @param args
     */
    public static void main(String[] args) {
        Car[] cars = new Car[10];
        Random r = new Random();
        cars[0] = new Car("Toyota","Prius",2005,r.nextInt(100));
        cars[1] = new Car("Honda","Civic",2000,r.nextInt(100));
        cars[2] = new Car("Hummer","H3",2007,r.nextInt(100));
        cars[3] = new Car("Ford","Mustang",1965,r.nextInt(100));
        cars[4] = new Car("Ford","Mustang",2015,r.nextInt(100));
        cars[5] = new Car("Ford","Mustang",2015,r.nextInt(100));
        cars[6] = new Car("Toyota","Prius",2005,r.nextInt(100));
        cars[7] = new Car("Honda","CRV",2005,r.nextInt(100));
        cars[8] = new Car("Honda","Civic",2000,r.nextInt(100));
        cars[9] = new Car("Toyota","Prius",2005,r.nextInt(100));

        System.out.println("New Cars");
        for(Car c : cars)
            System.out.println(c);

        System.out.println("~~~~~~~~~~\nSorted");
        Arrays.sort(cars);
        for(Car c : cars)
            System.out.println(c);

        System.out.println("~~~~~~~~~~\nAfter driving random cars");
        for(int i = 0; i < cars.length; i += r.nextInt(2))
            cars[i].drive(r.nextInt(20000));
        for(Car c : cars)
            System.out.println(c);

        System.out.println("~~~~~~~~~~\nSorted again");
        Arrays.sort(cars);
        for(Car c : cars)
            System.out.println(c);
    }
}
