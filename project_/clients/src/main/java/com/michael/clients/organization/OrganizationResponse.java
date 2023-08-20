package com.michael.clients.organization;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Schema(
        description = "Organization Request Model Information"
)
public class OrganizationResponse {
    @Schema(description = "Organization Id")
    private Long id;
    @Schema(description = "Organization Name")
    private String organizationName;
    @Schema(description = "Organization Description")
    private String organizationDescription;
    @Schema(description = "Organization Code")
    private String organizationCode;
}
