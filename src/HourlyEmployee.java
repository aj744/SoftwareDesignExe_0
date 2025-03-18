import java.util.Objects;

public class HourlyEmployee extends Employee {
    private int hours;
    private float wage;

    public HourlyEmployee(String firstName, String lastName, int id, int hours, int wage) {
        super(firstName, lastName, id);
        checkHourValidation(hours);
        checkWageValidation(hours);
        this.hours = hours;
        this.wage = wage;
    }

    public HourlyEmployee() {
        super();
        this.hours = 0;
        this.wage = 0;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                super.toString() +
                "hours=" + hours +
                ", wage=" + wage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof HourlyEmployee)) return false;
        if (!super.equals(o)) return false;
        HourlyEmployee that = (HourlyEmployee) o;
        return super.equals(o) && hours == that.hours && Float.compare(wage, that.wage) == 0;
    }

    @Override
    public float earnings() {
        return this.hours * this.wage;
    }

    private void checkHourValidation(int hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("Hours cannot be negative");
        }
    }

    private void checkWageValidation(float wage) {
        if (wage < 0.0f) {
            throw new IllegalArgumentException("Wage cannot be negative");
        }
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        checkHourValidation(hours);
        this.hours = hours;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        checkWageValidation(wage);
        this.wage = wage;
    }
}
