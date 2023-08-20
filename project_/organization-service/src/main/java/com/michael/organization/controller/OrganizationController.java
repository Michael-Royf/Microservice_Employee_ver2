package com.michael.organization.controller;

import com.michael.clients.organization.OrganizationResponse;
import com.michael.organization.exception.payload.OrganizationAlreadyExists;
import com.michael.organization.exception.payload.OrganizationNotFoundException;
import com.michael.organization.payload.request.OrganizationRequest;
import com.michael.organization.service.OrganizationService;
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
@RequestMapping("/api/v1/organizations")
@Tag(
        name = "Organization Service",
        description = "Organization Controller Exposes REST APIs for Organization-Service")
public class OrganizationController {

    private final OrganizationService organizationService;

    @Operation(
            summary = "Save Organization REST API",
            description = "Save organization REST API is used to save organization object in a database")
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationResponse> saveOrganization(@Valid @RequestBody OrganizationRequest organizationRequest) throws OrganizationAlreadyExists, OrganizationNotFoundException {
        return new ResponseEntity<>(organizationService.saveOrganization(organizationRequest), CREATED);
    }

    @Operation(
            summary = "Get Organization By Code REST API",
            description = "Get Organization By Code REST API is used to fetch single organization bu code from the database")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/{organizationCode}")
    public ResponseEntity<OrganizationResponse> getOrganizationByCode(@PathVariable String organizationCode) throws OrganizationNotFoundException {
        return new ResponseEntity<>(organizationService.getOrganizationByCode(organizationCode), OK);
    }

    @Operation(
            summary = "Get All Organizations REST API",
            description = "Get all organizations REST API is used to fetch all organizations from the database")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping
    public ResponseEntity<List<OrganizationResponse>> getAllOrganization() {
        return new ResponseEntity<>(organizationService.getAllOrganization(), OK);
    }

}
