import java.util.List;

public class Company {

    private final List<SalariedEntity> salariedEntities;

    public Company(List<SalariedEntity> salariedEntities) { this.salariedEntities = salariedEntities; }

    public void addSalariedEntity(SalariedEntity salariedEntity) { salariedEntities.add(salariedEntity); }
    public void removeSalariedEntity(SalariedEntity salariedEntity) { salariedEntities.remove(salariedEntity); }
    public void increaseEmployeesSalary(int salaryIncrease /* % */) {
        for (SalariedEntity salariedEntity : salariedEntities) {
            if (salariedEntity instanceof Employee) {
                ((Employee) salariedEntity).increaseSalary((float)(1.0 + salaryIncrease/100.0));
            }
        }
    }
}
