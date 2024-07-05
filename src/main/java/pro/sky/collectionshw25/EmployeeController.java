package pro.sky.collectionshw25;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam String lastName, @RequestParam String firstName) {
        return employeeService.addEmployee(lastName,firstName);
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam String lastName, @RequestParam String firstName) {
        return employeeService.removeEmployee(lastName,firstName);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam String lastName, @RequestParam String firstName) {
        return employeeService.findEmployee(lastName,firstName);
    }
}
