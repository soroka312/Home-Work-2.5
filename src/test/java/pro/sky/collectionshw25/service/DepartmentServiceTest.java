package pro.sky.collectionshw25.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.collectionshw25.Employee;

import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    DepartmentService departmentService;

    @BeforeEach
    void init() {
        Mockito.when(employeeService.findAll())
                .thenReturn(List.of(
                        new Employee("Родин", "Артемий", 4, 280000),
                        new Employee("Колесова", "Ева", 2, 207000),
                        new Employee("Черепанова", "Алина", 4, 358000),
                        new Employee("Елизарова", "Эмилия", 2, 246000)
                ));

    }

    @Test
    void sum() {
        double actual = departmentService.amountOfSalariesDepartment(4);
        Assertions.assertEquals(638000, actual);
    }

    @Test
    void min() {
        Employee actual = departmentService.minimumSalaryDepartment(2);
        Assertions.assertEquals(207000, actual.getSalary());
    }

    @Test
    void max() {
        Employee actual = departmentService.maximumSalaryDepartment(2);
        Assertions.assertEquals(246000, actual.getSalary());
    }

    @Test
    void filter() {
        List<Employee> actual = departmentService.allEmployeesOfTheDepartment(4);
        Assertions.assertEquals(2, actual.size());
        actual.forEach(employee -> Assertions.assertEquals(4, employee.getDepartment()));
    }

    @Test
    void grouped() {
        Map<Integer, List<Employee>> actual = departmentService.employeesGroupedByDep();
        Assertions.assertEquals(2, actual.keySet().size());
    }
}
