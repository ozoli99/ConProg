public class EmployeeTest {

    public static void main(String[] args) {
        Employee employee = new Manager("Bela", 100);

        assertEquals("Bela", employee.getName());
        assertEquals(100.0f, employee.getSalary());
    }

    private static void assertEquals(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("expected was " + expected + " but got " + actual);
        }
    }
}
