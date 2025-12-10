package com.spire.platform.u20231b475.missions.interfaces.rest.transform;

import com.spire.platform.u20231b475.missions.domain.model.commands.CreateMissionAssignmentCommand;
import com.spire.platform.u20231b475.missions.interfaces.rest.resources.CreateMissionAssignmentResource;

/**
 * Assembler to convert a CreateMissionAssignment to a
 * CreateMissionAssignmentCommand.
 */
public class CreateMissionAssignmentCommandFromResourceAssembler {
  public static CreateMissionAssignmentCommand toCommandFromResource(CreateMissionAssignmentResource resource) {
    return new CreateMissionAssignmentCommand(
        resource.satelliteCode(),
        resource.orbitClass(),
        resource.estimatedDuration(),
        resource.status(),
        resource.requestedAt());
  }
}
