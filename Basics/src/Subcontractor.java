public class Subcontractor implements SalariedEntity {

    private final long taxNumber;
    private float salary;

    public Subcontractor(long taxNumber, float salary) {
        this.taxNumber = taxNumber;
        this.salary = salary;
    }

    public long getTaxNumber() { return taxNumber; }

    @Override
    public float getSalary() { return salary; }
}
