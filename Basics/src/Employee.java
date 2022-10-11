public abstract class Employee implements SalariedEntity {

    private final String name;
    protected float salary;

    public Employee(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    public void increaseSalary(final float salaryIncrease) { salary *= salaryIncrease; }

    public String getName() { return name; }

    public abstract float getSalary();
}