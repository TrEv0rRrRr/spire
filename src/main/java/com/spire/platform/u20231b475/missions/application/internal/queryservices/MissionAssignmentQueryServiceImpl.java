package com.spire.platform.u20231b475.missions.application.internal.queryservices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spire.platform.u20231b475.missions.domain.model.aggregates.MissionAssignment;
import com.spire.platform.u20231b475.missions.domain.model.queries.GetMissionAssignmentBySatelliteCodeAndRequestedAtQuery;
import com.spire.platform.u20231b475.missions.domain.services.MissionAssignmentQueryService;
import com.spire.platform.u20231b475.missions.infrastructure.persistence.jpa.repositories.MissionAssignmentRepository;

/**
 * MissionAssignmentQueryServiceImplementation
 * 
 * @author Valentino Solis
 */
@Service
public class MissionAssignmentQueryServiceImpl implements MissionAssignmentQueryService {
  private final MissionAssignmentRepository repo;

  public MissionAssignmentQueryServiceImpl(MissionAssignmentRepository repo) {
    this.repo = repo;
  }

  // inherited javadoc
  @Override
  public Optional<MissionAssignment> handle(GetMissionAssignmentBySatelliteCodeAndRequestedAtQuery query) {
    return repo.findBySatelliteCodeAndRequestedAt(query.satelliteCode(), query.requestedAt());
  }
}
