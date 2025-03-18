import java.util.Objects;

public class CommissionEmployee extends Employee {
    private float grossSales;
    private int commission;

    public CommissionEmployee(String firstName, String lastName, int id, float grossSales, int commission) {
        super(firstName, lastName, id);
        checkGrossSalesValidation(grossSales);
        checkCommissionValidation(commission);
        this.grossSales = grossSales;
        this.commission = commission;
    }

    public CommissionEmployee() {
        super();
        this.grossSales = 0;
        this.commission = 0;
    }

    @Override
    public String toString() {
        return "CommissionEmployee{" +
                super.toString() +
                "grossSales=" + grossSales +
                ", commission=" + commission +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CommissionEmployee)) return false;
        if (!super.equals(o)) return false;
        CommissionEmployee that = (CommissionEmployee) o;
        return Float.compare(grossSales, that.grossSales) == 0 && commission == that.commission;
    }

    private void checkGrossSalesValidation(float grossSales) {
        if (grossSales < 0) {
            throw new IllegalArgumentException("grossSales cannot be negative");
        }
    }

    private void checkCommissionValidation(int commission) {
        if (commission < 0) {
            throw new IllegalArgumentException("Commission cannot be negative");
        }
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        checkCommissionValidation(commission);
        this.commission = commission;
    }

    public float getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(float grossSales) {
        checkGrossSalesValidation(grossSales);
        this.grossSales = grossSales;
    }

    @Override
    public float earnings() {
        return this.grossSales * (this.commission / 100.0f);
    }
}
