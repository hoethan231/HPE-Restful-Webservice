package com.example.restfulservice.HPE_RestfulAPI;

import java.net.URI;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeManager manager;

    public EmployeeController(EmployeeManager manager) { 
        this.manager = manager; 
    }

    // Get method for list of employees
    @GetMapping(path = "/", produces = "application/json")
    public Employees getEmployees() {
        return manager.getEmployees();
    }

    // POST method to add employee to list
    @PostMapping(path = "/", consumes = "applications/json", produces = "applications/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {

        Integer id = manager.getEmployees().getList().size() + 1;

        employee.set_id(id);
        manager.addEmployee(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.get_id()).toUri();

        return ResponseEntity.created(location).build();
    }
}