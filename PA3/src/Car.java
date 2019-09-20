/**
 * This class contains the state and behavior of
 * a car object. It implements both the Drivable and
 * Comparable interfaces
 * CPSC 321-02, Fall 2019
 * Programming Assignment #3
 * No sources to cite
 *
 * @author Zach Mckee
 * @version v1.0 9/20/2019
 */
public class Car implements Drivable, Comparable<Car> {
    private String make;
    private String model;
    private int year;
    private int odometerReading;

    //Constructors
    public Car() {
        this.make = "NO_MAKE";
        this.model = "NO_MODEL";
        this.year = -1;
        this.odometerReading = -1;
    }

    public Car(String make, String model, int year, int odometerReading) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.odometerReading = odometerReading;
    }

    //Getters/Setters
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(int odometerReading) {
        this.odometerReading = odometerReading;
    }

    /**
     * drive
     * This method "drives" a car by adding the parameter milesDriven to odometerReading
     * @param milesDriven
     */
    @Override
    public void drive(int milesDriven) {
        odometerReading += milesDriven;
    }

    /**
     * compareTo
     * The car specific implementation of the comparable's compareTo method.
     * It first compates year, then make, then model, and lastly odometerReading
     * @param o
     * @return A positive number if the calling car is "greater" than the one it's called against,
     *         0 if the cars are equal,
     *         else a negative number
     */
    @Override
    public int compareTo(Car o) {
        int compYear = this.year - o.year;
        if(compYear != 0)
            return compYear;
        int compMake = this.make.compareTo(o.make);
        if(compMake != 0)
            return compMake;
        int compModel = this.model.compareTo(o.model);
        if(compModel != 0)
            return compModel;
        return this.odometerReading - o.odometerReading;
    }

    /**
     * toString
     * returns a string representation of a car object
     * @return a string representation of a car object
     */
    @Override
    public String toString()
    {
        return year + " " + make + " " + model + " with " + odometerReading + " miles";
    }
}
