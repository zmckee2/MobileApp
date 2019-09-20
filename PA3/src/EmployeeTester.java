/**
 * This program tests the inheritance of the
 * Programmers, Lawyers, and Accountant classes
 * CPSC 321-02, Fall 2019
 * Programming Assignment #3
 * No sources to cite
 *
 * @author Zach Mckee
 * @version v1.0 9/20/2019
 */
public class EmployeeTester {
    /**
     * main
     * This method tests all child classes of employee being
     * Programmers, Lawyers, and Accountants
     * @param args
     */
    public static void main(String[] args) {
        Employee[] emps = new Employee[8];
        //Programmers
        emps[0] = new Programmers("Zach", false);
        emps[1] = new Programmers("Ima Nerd", true);
        //Lawyers
        emps[2] = new Lawyers("Kenny Dewitt", 10);
        emps[3] = new Lawyers("Dan D. Lyon", 0);
        emps[4] = new Lawyers("Willie Makit", 100);
        //Accountants
        emps[5] = new Accountants("Hal E. Luya", 17.00);
        emps[6] = new Accountants("Midas Well", 45.50);
        emps[7] = new Accountants("Doll R. Bill", 2.50);

        //Testing toString
        System.out.println("toString");
        for(Employee e : emps)
            System.out.println(e);

        //Testing reportSalary
        System.out.println("~~~~~~~~~~\nReport Salary");
        for(Employee e: emps)
            e.reportSalary();
    }
}
