package pro.sky.collectionshw25;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>(List.of(

            new Employee("Кочетков", "Александр", 5, 257532),

            new Employee("Пименова", "Нина", 2, 308235),

            new Employee("Родин", "Артемий", 3, 280932),

            new Employee("Колесова", "Ева", 2, 207493),

            new Employee("Черепанова", "Алина", 4, 358742),

            new Employee("Елизарова", "Эмилия", 2, 246432),

            new Employee("Иванова", "Алиса", 1, 269573),

            new Employee("Сергеева", "Марьяна", 5, 329473),

            new Employee("Попов", "Даниил", 3, 350283),

            new Employee("Носова", "Екатерина", 1, 397562)));


    public Employee minimumSalaryDepartment(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }


    public Employee maximumSalaryDepartment(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }


    public List<Employee> allEmployeesOfTheDepartment(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .toList();
    }

    public Map<Integer, List<Employee>> employeesGroupedByDep() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }


}
