package pro.sky.collectionshw25;

import java.util.Collection;

public interface EmployeeInterface {
    Employee addEmployee(String lastName, String firstName);
    Employee removeEmployee(String lastName, String firstName);
    Employee findEmployee(String lastName, String firstName);

    Collection<Employee> findAll();
}
