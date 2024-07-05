package pro.sky.collectionshw25;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService implements EmployeeInterface {
    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Кочетков", "Александр"),
            new Employee("Пименова", "Нина"),
            new Employee("Родин", "Артемий"),
            new Employee("Колесова", "Ева"),
            new Employee("Черепанова", "Алиса"),
            new Employee("Елизарова", "Эмилия"),
            new Employee("Иванова", "Алиса"),
            new Employee("Сергеева", "Марьяна"),
            new Employee("Попов", "Даниил"),
            new Employee("Носова", "Екатерина")

    ));

    @Override
    public Employee addEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employees);
    }


}
