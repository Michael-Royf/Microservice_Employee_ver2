package com.michael.employeeService.controller;

import com.michael.employeeService.exceptions.payload.EmailExistException;
import com.michael.employeeService.exceptions.payload.EmployeeNotFoundException;
import com.michael.employeeService.payload.request.EmployeeRequest;
import com.michael.employeeService.payload.response.ApiResponseDto;
import com.michael.employeeService.payload.response.EmployeeResponse;
import com.michael.employeeService.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/employee")
@Tag(
        name = "Employee Service",
        description = "Employee Controller Exposes REST APIs for Employee-Service")

public class EmployeeController {

    private final EmployeeService employeeService;


    @Operation(
            summary = "Save Employee REST API",
            description = "Save employee REST API is used to save employee object in a database")
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody @Valid EmployeeRequest employeeRequest) throws EmailExistException {
        return new ResponseEntity<>(employeeService.createEmployee(employeeRequest), CREATED);
    }

    @Operation(
            summary = "Get  Employee By Id REST API",
            description = "Get  employee by Id REST API is used to fetch single employee by id from the database")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable Long id) throws EmployeeNotFoundException {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), OK);
    }

    @Operation(
            summary = "Get All Employees REST API",
            description = "Get all employees REST API is used to fetch all employees from the database")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployee() {
        return new ResponseEntity<>(employeeService.getAllEmployee(), OK);
    }

    @Operation(
            summary = "Delete Employee REST API",
            description = "Delete employee REST API is used to delete employee from the database")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) throws EmployeeNotFoundException {
        return new ResponseEntity<>(employeeService.deleteEmployee(id), OK);
    }

    @Operation(
            summary = "Update Employee REST API",
            description = "Update employee REST API is used to update employee from the database")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable Long id,
                                                           @Valid @RequestBody EmployeeRequest employeeRequest) throws EmployeeNotFoundException, EmailExistException {
        return new ResponseEntity<>(employeeService.updateEmployee(id, employeeRequest), OK);
    }
}
