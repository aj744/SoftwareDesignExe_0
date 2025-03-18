import java.util.Objects;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    public float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) {
        this.baseSalary = baseSalary;
    }

    private float baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName, int id, float grossSales, int commission,
                                      float baseSalary) {
        super(firstName, lastName, id, grossSales, commission);
        checkBaseSalaryValidation(baseSalary);
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return "BasePlusCommissionEmployee{" +
                super.toString() +
                "baseSalary=" + baseSalary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BasePlusCommissionEmployee)) return false;
        if (!super.equals(o)) return false;
        BasePlusCommissionEmployee that = (BasePlusCommissionEmployee) o;
        return Float.compare(baseSalary, that.baseSalary) == 0;
    }

    private void checkBaseSalaryValidation(float baseSalary) {
        if (baseSalary < 0.0f) {
            throw new IllegalArgumentException("Base salary cannot be negative");
        }
    }

    @Override
    public float earnings() {
        return super.earnings()+this.baseSalary;
    }
}
