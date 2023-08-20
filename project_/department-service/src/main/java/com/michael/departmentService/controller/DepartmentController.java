package com.michael.departmentService.controller;

import com.michael.clients.department.DepartmentResponse;
import com.michael.departmentService.exceptions.payload.DepartmentExistExceptional;
import com.michael.departmentService.exceptions.payload.DepartmentNotFoundException;
import com.michael.departmentService.payload.request.DepartmentRequest;
import com.michael.departmentService.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Tag(
        name = "Department Service",
        description = "Department Controller Exposes REST APIs for Department-Service")
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Operation(
            summary = "Save Department REST API",
            description = "Save department REST API is used to save department object in a database")
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<DepartmentResponse> createDepartment(@RequestBody DepartmentRequest departmentRequest) throws DepartmentExistExceptional {
        return new ResponseEntity<>(departmentService.createDepartment(departmentRequest), CREATED);
    }

    @Operation(
            summary = "Get Department By Code REST API",
            description = "Get department by code REST API is used to fetch single department by code from the database")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/{department-code}")
    public ResponseEntity<DepartmentResponse> getDepartmentByCode(@PathVariable("department-code") String departmentCode) throws DepartmentNotFoundException {
        return new ResponseEntity<>(departmentService.getDepartmentByCode(departmentCode), OK);
    }

    @Operation(
            summary = "Get All Departments REST API",
            description = "Get all departments REST API is used to fetch all departments from the database")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments() {
        return new ResponseEntity<>(departmentService.getAllDepartments(), OK);
    }

    @Operation(
            summary = "Delete Department REST API",
            description = "Delete departments REST API is used to delete department from the database")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @DeleteMapping("/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long departmentId) throws DepartmentNotFoundException {
        return new ResponseEntity<>(departmentService.deleteDepartment(departmentId), OK);
    }
    @Operation(
            summary = "Update Department REST API",
            description = "Update department REST API is used to update department")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PutMapping("/{departmentId}")
    public ResponseEntity<DepartmentResponse> updateDepartment(@PathVariable Long departmentId,
                                                               @Valid @RequestBody DepartmentRequest departmentRequest) throws DepartmentNotFoundException, DepartmentExistExceptional {
        return new ResponseEntity<>(departmentService.updateDepartment(departmentId, departmentRequest), OK);
    }

}
