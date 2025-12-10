package com.spire.platform.u20231b475.missions.infrastructure.persistence.jpa.repositories;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spire.platform.u20231b475.missions.domain.model.aggregates.MissionAssignment;
import com.spire.platform.u20231b475.missions.domain.model.valueobjects.SatelliteCode;

/**
 * This interface is responsible for providing the MissionAssignment entity
 * related
 * operations.
 * It extends the JpaRepository interface.
 */
@Repository
public interface MissionAssignmentRepository extends JpaRepository<MissionAssignment, Long> {
  /**
   * Finds a mission assignment by its satellite code and requested date
   * 
   * @param satelliteCode the satellite code
   * @param requestedAt   the requested date
   * @return A {@link MissionAssignment} if the given properties are valid,
   *         otherwise
   *         empty
   */
  Optional<MissionAssignment> findBySatelliteCodeAndRequestedAt(SatelliteCode satelliteCode, LocalDateTime requestedAt);

  /**
   * This method is used to check if a mission assignment exists by the given
   * properties.
   * 
   * @param satelliteCode the satellite code
   * @param requestedAt   the requested date
   * @return A boolean indicating if the mission assignment exists.
   */
  boolean existsBySatelliteCodeAndRequestedAt(SatelliteCode satelliteCode, LocalDateTime requestedAt);
}
