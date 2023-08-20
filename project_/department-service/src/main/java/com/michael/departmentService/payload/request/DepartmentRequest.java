package com.michael.departmentService.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Schema(
        description = "Department Request Model Information"
)
public class DepartmentRequest {
    @Schema(description = "Department Name")
    @NotBlank
    private String departmentName;
    @Schema(description = "Department Description")
    @NotBlank
    private String departmentDescription;
    @Schema(description = "Department Code")
    @NotBlank
    private String departmentCode;
}
