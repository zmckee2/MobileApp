/**
 * This class contains the behavior for the Lawyers object
 * This class extends the abstract Employee class
 * CPSC 321-02, Fall 2019
 * Programming Assignment #3
 * No sources to cite
 *
 * @author Zach Mckee
 * @version v1.0 9/20/2019
 */
import java.text.DecimalFormat;

public class Lawyers extends Employee {
    int stockOptionsEarned;

    //Constructors
    public Lawyers() {
        super();
        salary += 30000;
        stockOptionsEarned = 0;
    }

    public Lawyers(String name) {
        super(name, 30000);
        this.stockOptionsEarned = 0;
    }

    public Lawyers(String name, int stockOptionsEarned) {
        super(name, 30000);
        this.stockOptionsEarned = stockOptionsEarned;
    }

    /**
     * reportSalary
     * This method reports salary information specific to the lawyers class
     */
    @Override
    public void reportSalary() {
        DecimalFormat formater = new DecimalFormat("######.00");
        System.out.println("I'm a lawyer. I make $" + formater.format(salary) + " and I have earned " + stockOptionsEarned
        + " stock options");
    }

    /**
     * toString
     * This method returns the string representation of the lawyer class
     * @return a string representation of a lawyer
     */
    @Override
    public String toString() {
        DecimalFormat formater = new DecimalFormat("######.00");
        return super.toString() + ", Stock options: " + stockOptionsEarned;
    }
}
