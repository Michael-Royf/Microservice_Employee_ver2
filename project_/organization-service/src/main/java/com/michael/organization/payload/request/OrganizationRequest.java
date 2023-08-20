package com.michael.organization.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Schema(
        description = "Organization Request Model Information"
)
public class OrganizationRequest {
    @Schema(description = "Organization Name")
    private String organizationName;
    @Schema(description = "Organization Description")
    private String organizationDescription;
    @Schema(description = "Organization Code")
    private String organizationCode;
}
