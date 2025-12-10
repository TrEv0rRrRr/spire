package com.spire.platform.u20231b475.missions.interfaces.rest.resources;

import java.time.LocalDateTime;
import java.util.Date;

import com.spire.platform.u20231b475.missions.domain.model.valueobjects.MissionAssignmentStatus;
import com.spire.platform.u20231b475.missions.domain.model.valueobjects.SatelliteCode;

/**
 * Mission Assignment Resource
 */
public record MissionAssignmentResource(Long id, SatelliteCode satelliteCode, String orbitClass,
    Integer estimatedDuration, MissionAssignmentStatus status, LocalDateTime requestedAt, Date createdAt,
    Date updatedAt) {

}
