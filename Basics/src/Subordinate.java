public class Subordinate extends Employee {
    public Subordinate(String name, float salary) { super(name, salary); }

    @Override
    public float getSalary() { return salary; }
}
