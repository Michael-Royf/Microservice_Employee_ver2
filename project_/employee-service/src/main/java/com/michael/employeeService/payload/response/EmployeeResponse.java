package com.michael.employeeService.payload.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Schema(
        description = "Employee Response Model Information"
)
public class EmployeeResponse {
    @Schema(description = "Employee Id")
    private String id;
    @Schema(description = "First Name")
    private String firstName;
    @Schema(description = "Last Name")
    private String lastName;
    @Schema(description = "Email")
    private String email;
    @Schema(description = "Department Code")
    private String departmentCode;
    @Schema(description = "Organization Code")
    private String organizationCode;
}
