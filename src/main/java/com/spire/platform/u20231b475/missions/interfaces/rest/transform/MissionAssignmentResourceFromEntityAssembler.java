package com.spire.platform.u20231b475.missions.interfaces.rest.transform;

import com.spire.platform.u20231b475.missions.domain.model.aggregates.MissionAssignment;
import com.spire.platform.u20231b475.missions.interfaces.rest.resources.MissionAssignmentResource;

/**
 * Assembler to convert a MissionAssignment to a MissionAssignmentResource.
 */
public class MissionAssignmentResourceFromEntityAssembler {
  public static MissionAssignmentResource toResourceFromEntity(MissionAssignment entity) {
    return new MissionAssignmentResource(
        entity.getId(),
        entity.getSatelliteCode(),
        entity.getOrbitClass(),
        entity.getEstimatedDuration(),
        entity.getStatus(),
        entity.getRequestedAt(),
        entity.getCreatedAt(),
        entity.getUpdatedAt());
  }
}
