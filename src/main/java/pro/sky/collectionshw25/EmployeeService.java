package pro.sky.collectionshw25;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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


    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employees);
    }



}
