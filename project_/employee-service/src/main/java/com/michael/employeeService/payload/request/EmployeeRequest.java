package com.michael.employeeService.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Schema(
        description = "Employee Request Model Information"
)
public class EmployeeRequest {
    @Schema(description = "Employee First Name")
    @NotBlank
    private String firstName;
    @Schema(description = "EmployeeLast Name")
    @NotBlank
    private String lastName;
    @Schema(description = "Employee Email address")
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Schema(description = "Department Code")
    private String departmentCode;
    @Schema(description = "Organization Code")
    @NotBlank
    private String organizationCode;
}
