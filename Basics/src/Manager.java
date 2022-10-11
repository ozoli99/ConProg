import java.nio.file.FileSystemLoopException;
import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {

    private final List<Employee> subordinates = new ArrayList<>();

    public Manager(String name, float salary) { super(name, salary); }

    @Override
    public float getSalary() {
        float salaryOfSubordinates = (float) subordinates.stream().mapToDouble(Employee::getSalary).sum();
        return salary + salaryOfSubordinates * 0.05f;
    }

    public void addSubordinate(Employee subordinate) { subordinates.add(subordinate); }

    public void removeSubordinate(Employee subordinate) { subordinates.remove(subordinate); }
}
