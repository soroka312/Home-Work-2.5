package pro.sky.collectionshw25;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/max-salary")
    public Employee maxSalary(@RequestParam int department) {
        return employeeService.maximumSalaryDepartment(department);
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary(@RequestParam int department) {
        return employeeService.minimumSalaryDepartment(department);
    }

    @GetMapping(value = "/all", params = "department")
    public List<Employee> all(@RequestParam int department) {
        return employeeService.allEmployeesOfTheDepartment(department);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> getAll() {
        return employeeService.employeesGroupedByDep();
    }
}
