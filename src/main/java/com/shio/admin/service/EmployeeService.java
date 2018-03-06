package com.shio.admin.service;

import com.shio.admin.domain.Employee;
import com.shio.admin.persistence.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Employee getSingle(Long id){
        return employeeRepository.findOne(id);
    }

    public Employee create(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee update(Employee employee){
        return employeeRepository.save(employee);
    }

}
