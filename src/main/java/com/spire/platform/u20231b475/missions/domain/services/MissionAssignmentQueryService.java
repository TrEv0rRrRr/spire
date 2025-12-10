package com.spire.platform.u20231b475.missions.domain.services;

import java.util.Optional;

import com.spire.platform.u20231b475.missions.domain.model.aggregates.MissionAssignment;
import com.spire.platform.u20231b475.missions.domain.model.queries.GetMissionAssignmentBySatelliteCodeAndRequestedAtQuery;

/**
 * This service is for mission assignment query handling
 */
public interface MissionAssignmentQueryService {
  /**
   * Handle GetMissionAssignmentBySatelliteCodeAndRequestedAtQuery query
   * 
   * @param query The
   *              {@link GetMissionAssignmentBySatelliteCodeAndRequestedAtQuery}
   * @return an {@link Optional} of {@link MissionAssignment} entity
   */
  Optional<MissionAssignment> handle(GetMissionAssignmentBySatelliteCodeAndRequestedAtQuery query);
}
