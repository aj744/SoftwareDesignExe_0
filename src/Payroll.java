import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Payroll {
    public static void main(String[] args) {
        try {
            Employee[] employees = {
                    new HourlyEmployee("yair", "journo", 337317846, 30, 70),
                    new CommissionEmployee("nadav", "journo", 13243565, 12000, 10),
                    new BasePlusCommissionEmployee("ariel", "journo", 283709320, 8000,
                            8, 1000)
            };

            for(Employee e: employees){
                if (e instanceof BasePlusCommissionEmployee){
                    System.out.println(e.earnings() * 1.1);
                }
                else {
                    System.out.println(e.earnings());
                }
            }

            System.out.println(employees[0].getId());
        }
        catch(IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}