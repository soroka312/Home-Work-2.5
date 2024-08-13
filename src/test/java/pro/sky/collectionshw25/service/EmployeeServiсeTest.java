package pro.sky.collectionshw25.service;

import org.junit.jupiter.api.Test;
import pro.sky.collectionshw25.Employee;
import pro.sky.collectionshw25.exception.EmployeeNotFoundException;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeServiсeTest {
    EmployeeService employeeService = new EmployeeService();


    @Test
    void addEmployee() {
        int size = employeeService.findAll().size();
        employeeService.addEmployee("Иван", "Иванов", 5, 957342);
        assertEquals(size + 1, employeeService.findAll().size());
    }

    @Test
    void removeEmployee() {
        int size = employeeService.findAll().size();
        employeeService.removeEmployee("Черепанова", "Алина", 4, 358742);
        assertEquals(size - 1, employeeService.findAll().size());
    }

    @Test
    void findAll() {
        Collection<Employee> actual = employeeService.findAll();
        assertEquals(10, actual.size());
    }

    @Test
    void findEmployee() {
        Employee actual = employeeService.findEmployee("Черепанова", "Алина", 4, 358742);
        assertEquals("Черепанова", actual.getFirstName());
        assertEquals("Алина", actual.getLastName());
    }

    @Test
    void findEmployeeNegative() {
        assertThrows(EmployeeNotFoundException.class, () ->
                employeeService.findEmployee("Алина", "Алина", 4, 358742));
    }
}
