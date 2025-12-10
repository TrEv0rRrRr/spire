package com.spire.platform.u20231b475.missions.application.internal.commandservices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spire.platform.u20231b475.missions.application.internal.outboundservices.acl.ExternalRegulationsService;
import com.spire.platform.u20231b475.missions.domain.model.aggregates.MissionAssignment;
import com.spire.platform.u20231b475.missions.domain.model.commands.CreateMissionAssignmentCommand;
import com.spire.platform.u20231b475.missions.domain.model.valueobjects.SatelliteCode;
import com.spire.platform.u20231b475.missions.domain.services.MissionAssignmentCommandService;
import com.spire.platform.u20231b475.missions.infrastructure.persistence.jpa.repositories.MissionAssignmentRepository;

/**
 * MissionAssignmentCommandServiceImplementation
 * 
 * @author Valentino Solis
 */
@Service
public class MissionAssignmentCommandServiceImpl implements MissionAssignmentCommandService {
  private final MissionAssignmentRepository repo;
  private final ExternalRegulationsService service;

  public MissionAssignmentCommandServiceImpl(MissionAssignmentRepository repo,
      ExternalRegulationsService service) {
    this.repo = repo;
    this.service = service;
  }

  // inherited javadoc
  @Override
  public Optional<MissionAssignment> handle(CreateMissionAssignmentCommand command) {
    var satelliteCode = new SatelliteCode(command.satelliteCode());

    if (repo.existsBySatelliteCodeAndRequestedAt(satelliteCode, command.requestedAt())) {
      throw new IllegalArgumentException("A mission assignment with the given properties already exists");
    }

    boolean isUnderutilized = service.isUnderutilized(command.orbitClass(), command.estimatedDuration());

    var missionAssignment = new MissionAssignment(command);

    repo.save(missionAssignment);

    if (isUnderutilized) {
      missionAssignment.orbitWindowUnderutilized();
      repo.save(missionAssignment);
    }

    return Optional.of(missionAssignment);
  }
}
