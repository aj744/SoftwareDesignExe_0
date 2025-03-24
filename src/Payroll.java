import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*
    Payroll is a system to manage salaries of employees.
 */
public class Payroll {
    /**
     *
     * @param args - command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // try block to catch thrown errors caused by invalid arguments
        try {
            // Creates the employees' objects
            Employee[] employees = {
                    new HourlyEmployee("max", "verstappen", 337317846, 30, 70),
                    new CommissionEmployee("lewis", "hamilton", 13243565, 12000,
                            10),
                    new BasePlusCommissionEmployee("charles", "leclerc", 283709320, 8000,
                            8, 1000)
            };

            // Iterates the employees array to show each one's salary
            for(Employee e: employees){
                if (e instanceof BasePlusCommissionEmployee){  // For the BasePlusCommissionEmployee employee
                    System.out.printf("%.2f%n", e.earnings() * 1.1);
                }
                else {  // For any other employee
                    System.out.printf("%.2f%n", e.earnings());
                }
            }
        }
        catch(IllegalArgumentException e) {  // If an exception has been caught, the code stops and shows the problem
            System.out.println("Error:" + e.getMessage());
        }
    }
}