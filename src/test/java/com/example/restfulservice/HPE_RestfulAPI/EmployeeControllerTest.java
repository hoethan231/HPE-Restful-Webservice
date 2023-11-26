package com.example.restfulservice.HPE_RestfulAPI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.mockito.Mockito;
import org.springframework.http.MediaType;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    EmployeeRepository employeeRepository;

    Employee employee_one = new Employee(1, "Vincent", "Yuong", "VY@gmail.com", "employee");
    Employee employee_two = new Employee(1, "Yuji", "Kim", "YK@gmail.com", "employee");
    Employee employee_three = new Employee(1, "Anthony", "Dong", "AD@gmail.com", "employee");

    @Test
    public void getAllEmployees_success() throws Exception {

        List<Employee> list = new ArrayList<>(Arrays.asList(employee_one, employee_two, employee_three));

        Mockito.when(employeeRepository.findAll()).thenReturn(list);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/employees")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$", hasSize(3)))
                        .andExpect(jsonPath("$[2].first_name", is("Anthony")));
                        
    }

}