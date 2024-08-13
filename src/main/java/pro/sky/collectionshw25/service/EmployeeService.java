package pro.sky.collectionshw25.service;

import org.springframework.stereotype.Service;
import pro.sky.collectionshw25.Employee;
import pro.sky.collectionshw25.exception.EmployeeAlreadyAddedException;
import pro.sky.collectionshw25.exception.EmployeeNotFoundException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>(Map.of(
            "Кочетков",

            new Employee("Кочетков", "Александр", 5, 257532),
            "Пименова",

            new Employee("Пименова", "Нина", 2, 308235),
            "Родин",

            new Employee("Родин", "Артемий", 3, 280932),
            "Колесова",

            new Employee("Колесова", "Ева", 2, 207493),
            "Черепанова",

            new Employee("Черепанова", "Алина", 4, 358742),
            "Елизарова",

            new Employee("Елизарова", "Эмилия", 2, 246432),
            "Иванова",

            new Employee("Иванова", "Алиса", 1, 269573),
            "Сергеева",

            new Employee("Сергеева", "Марьяна", 5, 329473),
            "Попов",

            new Employee("Попов", "Даниил", 3, 350283),
            "Носова",

            new Employee("Носова", "Екатерина", 1, 397562)));


    public void addEmployee(String lastName, String firstName, int department, double salary) {
        Employee employee = new Employee(lastName, firstName, department, salary);
        if (employees.containsKey(employee.getFirstName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getLastName(), employee);
    }


    public void removeEmployee(String lastName, String firstName, int department, double salary) {
        Employee employee = new Employee(lastName, firstName, department, salary);
        if (employees.containsKey(employee.getFirstName())) {
            employees.remove(employee.getFirstName(), employee);
            return;
        }
        throw new EmployeeNotFoundException();
    }


    public Employee findEmployee(String lastName, String firstName, int department, double salary) {
        Employee employee = new Employee(lastName, firstName, department, salary);
        if (employees.containsKey(employee.getFirstName())) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }


}
