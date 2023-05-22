package com.example.libraries2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeMapController {
    private final EmployeeService employeeService;

    public EmployeeMapController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/add")
    public EmployeeMap addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                                       @RequestParam("salary") int salary, @RequestParam("departmentId") int department) {
        return this.employeeService.createEmployee(firstName, lastName,salary,department);
    }

    @GetMapping(path = "/remove")
    public EmployeeMap removeEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                                          @RequestParam int salary, @RequestParam int department) {
        return employeeService.removeEmployee(firstName, lastName,salary,department);

    }

    @GetMapping(path = "/find")
    public EmployeeMap findEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                                        @RequestParam int salary, @RequestParam int department) {
        return employeeService.findEmployee(firstName, lastName,salary,department);
    }

    @GetMapping(path = "/allEmployees")
    public Collection<EmployeeMap> showAllEmployees() {
        return this.employeeService.showAllEmployees();
    }

}
