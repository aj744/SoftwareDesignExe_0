import java.util.Objects;

/**
 * Represents an hourly employee who is paid based on the number of hours worked and the hourly wage.
 */
public class HourlyEmployee extends Employee {
    private int hours;
    private float wage;

    /**
     * Constructor for HourlyEmployee with parameters.
     * @param firstName the employee's first name
     * @param lastName the employee's last name
     * @param id the employee's ID
     * @param hours the number of hours worked
     * @param wage the hourly wage
     * @throws IllegalArgumentException if hours or wage are negative
     */
    public HourlyEmployee(String firstName, String lastName, int id, int hours, int wage) {
        super(firstName, lastName, id);  // calls Employee's constructor
        checkHourValidation(hours);  // checks if the hours are valid
        checkWageValidation(hours);  // checks if the wage is valid
        this.hours = hours;
        this.wage = wage;
    }

    /**
     * Default constructor for HourlyEmployee.
     * Initializes hours and wage to zero.
     */
    public HourlyEmployee() {
        super();  // calls Employee's constructor
        this.hours = 0;
        this.wage = 0;
    }

    /**
     * Overrides the Employee's toString method to include HourlyEmployee-specific details.
     * @return a string representation of the HourlyEmployee object
     */
    @Override
    public String toString() {
        return "HourlyEmployee{" +
                super.toString() +
                "hours=" + hours +
                ", wage=" + wage +
                '}';
    }

    /**
     * Overrides Employee's equals method to compare HourlyEmployee objects.
     * @param o the object to compare to the HourlyEmployee object
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        // if the object o isn't an instance of HourlyEmployee - it is not equal for sure
        if (!(o instanceof HourlyEmployee)) return false;
        // checks the equals of the parent class
        if (!super.equals(o)) return false;
        HourlyEmployee that = (HourlyEmployee) o;
        return super.equals(o) && hours == that.hours && Float.compare(wage, that.wage) == 0;
    }

    /**
     * Implements Employee's abstract earnings method.
     * @return the total earnings based on hours worked and hourly wage
     */
    @Override
    public float earnings() {
        return this.hours * this.wage;
    }

    /**
     * Validates that hours are non-negative.
     * @param hours the number of hours worked
     * @throws IllegalArgumentException if hours are negative
     */
    private void checkHourValidation(int hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("Hours cannot be negative");
        }
    }

    /**
     * Validates that wage is non-negative.
     * @param wage the hourly wage
     * @throws IllegalArgumentException if wage is negative
     */
    private void checkWageValidation(float wage) {
        if (wage < 0.0f) {
            throw new IllegalArgumentException("Wage cannot be negative");
        }
    }

    /**
     * Gets the number of hours worked.
     * @return the hours worked
     */
    public int getHours() {
        return hours;
    }

    /**
     * Sets the number of hours worked.
     * @param hours the new hours value
     * @throws IllegalArgumentException if hours are negative
     */
    public void setHours(int hours) {
        checkHourValidation(hours);
        this.hours = hours;
    }

    /**
     * Gets the hourly wage.
     * @return the hourly wage
     */
    public float getWage() {
        return wage;
    }

    /**
     * Sets the hourly wage.
     * @param wage the new wage value
     * @throws IllegalArgumentException if wage is negative
     */
    public void setWage(float wage) {
        checkWageValidation(wage);
        this.wage = wage;
    }
}
