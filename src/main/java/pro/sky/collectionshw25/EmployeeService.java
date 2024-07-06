package pro.sky.collectionshw25;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService implements EmployeeInterface {
    private final Map<String, Employee> employees = new HashMap(Map.of(
            "Кочетков",
            new Employee("Кочетков", "Александр"),
            "Пименова",
            new Employee("Пименова", "Нина"),
            "Родин",
            new Employee("Родин", "Артемий"),
            "Колесова",
            new Employee("Колесова", "Ева"),
            "Черепанова",
            new Employee("Черепанова", "Алина"),
            "Елизарова",
            new Employee("Елизарова", "Эмилия"),
            "Иванова",
            new Employee("Иванова", "Алиса"),
            "Сергеева",
            new Employee("Сергеева", "Марьяна"),
            "Попов",
            new Employee("Попов", "Даниил"),
            "Носова",
            new Employee("Носова", "Екатерина")

    ));

    @Override
    public Employee addEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employees.containsKey(employee.getLastName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getLastName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employees.containsKey(employee.getLastName())) {
            employees.remove(employee.getLastName(), employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employees.containsKey(employee.getLastName())) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }


}
