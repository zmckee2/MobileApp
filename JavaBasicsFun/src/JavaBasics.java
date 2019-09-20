import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * javadoc
 */
// Normal comment
public class JavaBasics {
    public static void main(String[] args) {
        System.out.println(args.length);
        char myChar = 'a';
        System.out.println(myChar + "__ererere");

        //java.lang is imported already
        double myDouble = Math.PI; //<-- Constants are MACRO_CASE
        System.out.println(myDouble);
        DecimalFormat df = new DecimalFormat("#0.00");
        System.out.println(df.format(myDouble));

        boolean b = true;
        System.out.println(b);

        String f = "Zach";
        String l = "McKee";

        //Task 1
        System.out.println(f + " " + l + " has " + (f+l).length() + " characters in it");
        System.out.printf("%s %s has %d characters in it\n", f, l, (f+l).length());

        int[] iArr =  {1,2,3,4,5};
        System.out.println(Arrays.toString(iArr));

        String[] names = {"Max","Sam","Zach","Megan", "Stuart"};
        System.out.println(Arrays.toString(names) + "\nlength: " + names.length + "\nLastElm: " + names[names.length-1]);

        for(int i = 2; i <= 40; i+=2)
            System.out.print(i + ",");

        System.out.println();
        System.out.println(lastCharEqual("apple","hello"));

        Random r = new Random();

        Scanner input = new Scanner(System.in);
        String in = input.nextLine();
        System.out.println(in);

    }

    public static boolean lastCharEqual(String s1, String s2)
    {
        if(s1.length() == 0 || s2.length() == 0 || s1 == null || s2 == null)
            return false;
        return s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1);
    }
}
