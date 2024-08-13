package pro.sky.collectionshw25.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collectionshw25.Employee;
import pro.sky.collectionshw25.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{id}/salary/max")
    public Employee maxSalary(@RequestParam int department) {
        return departmentService.maximumSalaryDepartment(department);
    }

    @GetMapping(path = "/{id}/salary/min")
    public Employee minSalary(@RequestParam int department) {
        return departmentService.minimumSalaryDepartment(department);
    }

    @GetMapping(path = "/{id}/salary/sum")
    public double sumSalary(@RequestParam int department) {
        return departmentService.amountOfSalariesDepartment(department);
    }

    @GetMapping(path = "/{id}/employees")
    public List<Employee> all(@RequestParam int department) {
        return departmentService.allEmployeesOfTheDepartment(department);
    }

    @GetMapping(path = "/employees")
    public Map<Integer, List<Employee>> getAll() {
        return departmentService.employeesGroupedByDep();
    }
}
