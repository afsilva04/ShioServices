package com.shio.admin.rest;

import com.shio.admin.domain.Employee;
import com.shio.admin.rest.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RequestMapping("/employees")
@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll(){
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getSingle(@PathVariable("id") Long id){
        return employeeService.getSingle(id);
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee){
        return employeeService.create(employee);
    }

    @PutMapping
    public Employee update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

}
