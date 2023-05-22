package com.example.libraries2;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, EmployeeMap> employeeMap;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }

    @Override
    public EmployeeMap createEmployee(String firstName, String lastName, int salary, int department) {
        EmployeeMap employee = new EmployeeMap(firstName,lastName,salary,department);
        if (StringUtils.isAllLowerCase(firstName)||StringUtils.isAllLowerCase(lastName)) {
            employee.setFirstname(StringUtils.capitalize(firstName));
            employee.setLastName(StringUtils.capitalize(lastName));
        }
        if (!StringUtils.isAlpha(firstName)||!StringUtils.isAlpha(lastName)) {
            throw new EnteringIncorrectData("incorrect data");
        }
        if (employeeMap.containsKey(employee.FullName())) {
            throw new EmployeeAlreadyAddedException("EmployeeAlreadyAdded");
        } else {
            this.employeeMap.put(employee.FullName(), employee);
        }
        return employee;
    }

    @Override
    public EmployeeMap removeEmployee(String firstname, String lastName, int salary, int department) {
       EmployeeMap employee = new EmployeeMap(firstname, lastName,salary,department);
        if (employeeMap.containsKey(employee.FullName())) {
            return employeeMap.remove(employee.FullName());
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public EmployeeMap findEmployee(String firstname, String lastName, int salary, int department) {
        EmployeeMap employee = new EmployeeMap(firstname, lastName,salary,department);
        if (employeeMap.containsKey(employee.FullName())) {
            return employeeMap.get(employee.FullName());
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public Collection<EmployeeMap> showAllEmployees() {
        return Collections.unmodifiableCollection(employeeMap.values());
    }





}
