import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Exceptions are events that occur during runtime that disrupt the normal flow of execution

        //2 types of exceptions
        // unchecked: errors and runtime exceptions
        // checked: must be handeled or acknowledged by your code

        //Unchecked exception
        try{
            int x = 5/0;
        } catch (ArithmeticException e)
        {
            System.out.println("Cant divide by 0 dummy");
            e.printStackTrace();
        }
        System.out.println("continuing");

        //Checked exception
        Scanner inFile = null;

        try {
            inFile = new Scanner(new File("dne.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Keep going bruh");
        }

        // List interface
        // 2 out of the box lists
        // ArrayList and LinkedList

        List<String> l = new ArrayList<String>();
        l.add("Zach");
        l.add("m");
        l.add("21");
        l.add("cool");
        System.out.println(l);
        Collections.shuffle(l);
        System.out.println(l);
        Collections.sort(l);
        System.out.println(l);

        // create array list of 1st 10 squares

        List<Integer> sqrs = new ArrayList<Integer>();
        for(int i = 1; i <= 10; i++)
            sqrs.add(i*i); //<--- autoboxing into int
        System.out.println(sqrs);
        Collections.shuffle(sqrs);
        System.out.println(sqrs);
        Collections.reverse(sqrs);
        System.out.println(sqrs);
        Collections.sort(sqrs);
        System.out.println(sqrs);


    }
}
