package com.spire.platform.u20231b475.missions.interfaces.rest.resources;

import java.time.LocalDateTime;

import com.spire.platform.u20231b475.missions.domain.model.valueobjects.MissionAssignmentStatus;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

/**
 * Create mission assignment resource
 */
public record CreateMissionAssignmentResource(@NotBlank(message = "Satellite code is required") String satelliteCode,
        @NotBlank(message = "Orbit class is required") String orbitClass,
        @NotNull(message = "The estimated duration is required") @Min(1) Integer estimatedDuration,
        MissionAssignmentStatus status,
        @NotNull(message = "The requested date is required") @PastOrPresent LocalDateTime requestedAt) {

}
