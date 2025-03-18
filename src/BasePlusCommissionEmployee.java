import java.util.Objects;

/**
 * Represents an employee who earns a base salary plus commission from gross sales.
 */
public class BasePlusCommissionEmployee extends CommissionEmployee {
    private float baseSalary;

    /**
     * Gets the base salary of the employee.
     * @return the base salary
     */
    public float getBaseSalary() {
        return baseSalary;
    }

    /**
     * Sets the base salary of the employee.
     * @param baseSalary the new base salary
     * @throws IllegalArgumentException if baseSalary is negative
     */
    public void setBaseSalary(float baseSalary) {
        checkBaseSalaryValidation(baseSalary);
        this.baseSalary = baseSalary;
    }

    /**
     * Constructor for BasePlusCommissionEmployee with parameters.
     * @param firstName the employee's first name
     * @param lastName the employee's last name
     * @param id the employee's ID
     * @param grossSales the total sales made by the employee
     * @param commission the commission percentage
     * @param baseSalary the base salary of the employee
     * @throws IllegalArgumentException if baseSalary, grossSales, or commission are negative
     */
    public BasePlusCommissionEmployee(String firstName, String lastName, int id, float grossSales, int commission,
                                      float baseSalary) {
        super(firstName, lastName, id, grossSales, commission);
        checkBaseSalaryValidation(baseSalary);
        this.baseSalary = baseSalary;
    }

    /**
     * Overrides the Employee's toString method to include BasePlusCommissionEmployee-specific details.
     * @return a string representation of the BasePlusCommissionEmployee object
     */
    @Override
    public String toString() {
        return "BasePlusCommissionEmployee{" +
                super.toString() +
                "baseSalary=" + baseSalary +
                '}';
    }

    /**
     * Overrides Employee's equals method to compare BasePlusCommissionEmployee objects.
     * @param o the object to compare to the BasePlusCommissionEmployee object
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BasePlusCommissionEmployee)) return false;
        if (!super.equals(o)) return false;
        BasePlusCommissionEmployee that = (BasePlusCommissionEmployee) o;
        return Float.compare(baseSalary, that.baseSalary) == 0;
    }

    /**
     * Validates that baseSalary is non-negative.
     * @param baseSalary the base salary of the employee
     * @throws IllegalArgumentException if baseSalary is negative
     */
    private void checkBaseSalaryValidation(float baseSalary) {
        if (baseSalary < 0.0f) {
            throw new IllegalArgumentException("Base salary cannot be negative");
        }
    }

    /**
     * Implements Employee's abstract earnings method.
     * @return the total earnings based on base salary, gross sales, and commission percentage
     */
    @Override
    public float earnings() {
        return super.earnings() + this.baseSalary;
    }
}
