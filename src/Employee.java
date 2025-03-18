import java.util.Objects;


abstract class Employee {
    private String firstName;
    private String lastName;
    private int id;

    /**
     * Constructor method with parameters.
     * @param firstName - the employee's first name
     * @param lastName - the employee's last name
     * @param id - the employee's ID
     */
    public Employee(String firstName, String lastName, int id) {
        checkIdValidation(id);  // check if the parameters are valid
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    /**
     * default constructor for Employee
     */
    public Employee() {
        firstName = "Plony";
        lastName = "Almony";
        id = 0;
    }

    /**
     * overrides the toString method of the Employee object
     * @return the values of the employee
     */
    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }

    /**
     *
     * @param o the object to compare to the Employee object
     * @return boolean value that indicate if the object o is equal to the employee object
     */
    @Override
    public boolean equals(Object o) {
        // if the object o isn't an instance of a class that inherits from Employee - it is not equal for sure
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;  // converts the object to Employee type
        return id == employee.id && Objects.equals(firstName, employee.firstName)
                && Objects.equals(lastName, employee.lastName);
    }

    /**
     * check if the id parameter is valid
     * @param id the id argument
     * @throws IllegalArgumentException if the id is a negative number, or it has more than 9 digits
     */
    private void checkIdValidation(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID cannot be a negative number");
        }
        if (id > 999999999) {
            throw new IllegalArgumentException("ID must have 9 digits");
        }
    }

    /**
     * getter method for firstName
     * @return the employee's first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * setter method for firstName
     * @param firstName the new employee's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * getter methpd for lastName
     * @return the employee's last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * setter method for lastName
     * @param lastName the new employee's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * getter method for id
     * @return the employee's ID
     */
    public int getId() {
        return this.id;
    }

    /**
     * setter method for id
     * @param id the new employee's ID
     */
    public void setId(int id) {
        checkIdValidation(id);
        this.id = id;
    }

    /**
     * calculates the employee's salary - abstract method
     * @return the employee's salary
     */
    abstract public float earnings();
}
