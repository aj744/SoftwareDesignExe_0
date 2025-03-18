import java.util.Objects;

/**
 * Represents an employee who earns based on commission from gross sales.
 */
public class CommissionEmployee extends Employee {
    private float grossSales;
    private int commission;

    /**
     * Constructor for CommissionEmployee with parameters.
     * @param firstName the employee's first name
     * @param lastName the employee's last name
     * @param id the employee's ID
     * @param grossSales the total sales made by the employee
     * @param commission the commission percentage
     * @throws IllegalArgumentException if grossSales or commission are negative
     */
    public CommissionEmployee(String firstName, String lastName, int id, float grossSales, int commission) {
        super(firstName, lastName, id);
        checkGrossSalesValidation(grossSales);
        checkCommissionValidation(commission);
        this.grossSales = grossSales;
        this.commission = commission;
    }

    /**
     * Default constructor for CommissionEmployee.
     * Initializes grossSales and commission to zero.
     */
    public CommissionEmployee() {
        super();
        this.grossSales = 0;
        this.commission = 0;
    }

    /**
     * Overrides the Employee's toString method to include CommissionEmployee-specific details.
     * @return a string representation of the CommissionEmployee object
     */
    @Override
    public String toString() {
        return "CommissionEmployee{" +
                super.toString() +
                "grossSales=" + grossSales +
                ", commission=" + commission +
                '}';
    }

    /**
     * Overrides Employee's equals method to compare CommissionEmployee objects.
     * @param o the object to compare to the CommissionEmployee object
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CommissionEmployee)) return false;
        if (!super.equals(o)) return false;
        CommissionEmployee that = (CommissionEmployee) o;
        return Float.compare(grossSales, that.grossSales) == 0 && commission == that.commission;
    }

    /**
     * Validates that grossSales is non-negative.
     * @param grossSales the total sales made by the employee
     * @throws IllegalArgumentException if grossSales is negative
     */
    private void checkGrossSalesValidation(float grossSales) {
        if (grossSales < 0) {
            throw new IllegalArgumentException("grossSales cannot be negative");
        }
    }

    /**
     * Validates that commission is non-negative.
     * @param commission the commission percentage
     * @throws IllegalArgumentException if commission is negative
     */
    private void checkCommissionValidation(int commission) {
        if (commission < 0) {
            throw new IllegalArgumentException("Commission cannot be negative");
        }
    }

    /**
     * Gets the commission percentage.
     * @return the commission percentage
     */
    public int getCommission() {
        return commission;
    }

    /**
     * Sets the commission percentage.
     * @param commission the new commission percentage
     * @throws IllegalArgumentException if commission is negative
     */
    public void setCommission(int commission) {
        checkCommissionValidation(commission);
        this.commission = commission;
    }

    /**
     * Gets the total sales made by the employee.
     * @return the total gross sales
     */
    public float getGrossSales() {
        return grossSales;
    }

    /**
     * Sets the total sales made by the employee.
     * @param grossSales the new gross sales value
     * @throws IllegalArgumentException if grossSales is negative
     */
    public void setGrossSales(float grossSales) {
        checkGrossSalesValidation(grossSales);
        this.grossSales = grossSales;
    }

    /**
     * Implements Employee's abstract earnings method.
     * @return the total earnings based on gross sales and commission percentage
     */
    @Override
    public float earnings() {
        return this.grossSales * (this.commission / 100.0f);
    }
}