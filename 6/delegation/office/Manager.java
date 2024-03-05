package delegation.office;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.BinaryOperator;

public class Manager implements Employee {
    private Collection<Employee> employees;
    private int taskCount = 0;

    public Manager(Collection<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            throw new IllegalArgumentException("Employees collection cannot be null or empty");
        }
        this.employees = employees;
    }

    @Override
    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        taskCount++;
        Iterator<Employee> iterator = employees.iterator();
        if (iterator.hasNext()) {
            return iterator.next().doCalculations(operation, value1, value2);
        }
        return 0;
    }

    @Override
    public void printDocument(String document) {
        taskCount++;
        Iterator<Employee> iterator = employees.iterator();
        if (iterator.hasNext()) {
            iterator.next().printDocument(document);
        }
    }

    @Override
    public int getTaskCount() {
        return taskCount;
    }

    @Override
    public int getResourceCount() {
        int count = 1;
        for (Employee employee : employees) {
            count += employee.getResourceCount();
        }
        return count;
    }
}
