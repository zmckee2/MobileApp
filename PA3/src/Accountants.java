/**
 * This class contains the behavior for the Accountants object
 * This class extends the abstract Employee class
 * CPSC 321-02, Fall 2019
 * Programming Assignment #3
 * No sources to cite
 *
 * @author Zach Mckee
 * @version v1.0 9/20/2019
 */
import java.text.DecimalFormat;

public class Accountants extends Employee {
    double parkingAllowance;

    //Constructors
    public Accountants()
    {
        super();
        parkingAllowance = 0.0;
    }

    public Accountants(String name , double parkingAllowance) {
        super(name, 0);
        this.parkingAllowance = parkingAllowance;
    }

    /**
     * reportSalary
     * This method reports salary information specific to the accountants class
     */
    @Override
    public void reportSalary() {
        DecimalFormat formater = new DecimalFormat("######.00");
        System.out.println("I'm an accountant. I make $" + formater.format(salary) + " and have $" + formater.format(parkingAllowance)
        + " for parking.");
    }

    /**
     * toString
     * This method returns the string representation of the accountants class
     * @return a string representation of an accountant
     */
    @Override
    public String toString() {
        DecimalFormat formater = new DecimalFormat("######.00");
        return super.toString() + ", Parking allowance: " + formater.format(parkingAllowance);
    }
}
