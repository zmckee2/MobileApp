/**
 * This class contains the declaration for Programmers
 * child class (child to employee)
 * CPSC 321-02, Fall 2019
 * Programming Assignment #3
 * No sources to cite
 *
 * @author Zach Mckee
 * @version v1.0 9/20/2019
 */
import java.text.DecimalFormat;

public class Programmers extends Employee {

    private boolean hasBusPass;

    //Constructors
    public Programmers()
    {
        super("NO_NAME", 20000);
        hasBusPass = false;
    }

    public Programmers(String name, boolean hasBusPass) {
        super(name, 20000);
        this.hasBusPass = hasBusPass;
    }

    //Getters/Setters
    public boolean getHasBusPass() {
        return hasBusPass;
    }

    public void setHasBusPass(boolean hasBusPass) {
        this.hasBusPass = hasBusPass;
    }

    /**
     * reportSalary
     * This method reports salary information specific to the programmers class
     */
    @Override
    public void reportSalary() {
        String busPass;
        DecimalFormat formater = new DecimalFormat("######.00");
        if(hasBusPass)
            busPass = " and I do get a bus pass.";
        else
            busPass = " and I do not get a bus pass.";
        System.out.println("I'm a programmer. I make $" + formater.format(salary) + busPass);
    }

    /**
     * toString
     * This method returns the string representation of the programmers class
     * @return a string representation of a programmer
     */
    @Override
    public String toString() {
        DecimalFormat formater = new DecimalFormat("######.00");
        return super.toString() + ", Bus pass: " + hasBusPass;
    }
}
