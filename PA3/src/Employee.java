/**
 * This class contains the declaration for the abstract
 * employee class
 * CPSC 321-02, Fall 2019
 * Programming Assignment #3
 * No sources to cite
 *
 * @author Zach Mckee
 * @version v1.0 9/20/2019
 */

import java.text.DecimalFormat;

public abstract class Employee {
    protected String name;
    protected double salary;
    private final double BASE_SALARY = 40000;

    public Employee()
    {
        name = "NO_NAME";
        salary = BASE_SALARY;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = BASE_SALARY + salary;
    }

    /**
     * reportSalary
     * This method reports salary information specific to the implementing class
     */
    public abstract void reportSalary();

    /**
     * toString
     * This method returns the string representation of the Employee class
     * @return a string representation of a employee
     */
    public String toString()
    {
        DecimalFormat formater = new DecimalFormat("######.00");
        return "Name: " + name + ", Salary: " + formater.format(salary);
    }
}
