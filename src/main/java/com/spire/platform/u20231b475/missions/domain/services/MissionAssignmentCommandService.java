package com.spire.platform.u20231b475.missions.domain.services;

import java.util.Optional;

import com.spire.platform.u20231b475.missions.domain.model.aggregates.MissionAssignment;
import com.spire.platform.u20231b475.missions.domain.model.commands.CreateMissionAssignmentCommand;

/**
 * This service is for mission assignment command handling
 */
public interface MissionAssignmentCommandService {
  /**
   * Handle create mission assignment command
   * 
   * @param command The {@link CreateMissionAssignmentCommand}
   * @return An {@link Optional} of {@link MissionAssignment}
   */
  Optional<MissionAssignment> handle(CreateMissionAssignmentCommand command);
}
