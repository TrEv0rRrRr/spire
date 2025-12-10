package com.spire.platform.u20231b475.missions.domain.model.queries;

import java.time.LocalDateTime;

import com.spire.platform.u20231b475.missions.domain.model.valueobjects.SatelliteCode;

/**
 * Query to retrieve a mission assignment by its satellite code and the
 * requested date
 */
public record GetMissionAssignmentBySatelliteCodeAndRequestedAtQuery(SatelliteCode satelliteCode,
    LocalDateTime requestedAt) {

}
