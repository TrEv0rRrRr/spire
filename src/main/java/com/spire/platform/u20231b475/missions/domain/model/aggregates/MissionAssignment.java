package com.spire.platform.u20231b475.missions.domain.model.aggregates;

import java.time.LocalDateTime;

import com.spire.platform.u20231b475.missions.domain.model.commands.CreateMissionAssignmentCommand;
import com.spire.platform.u20231b475.missions.domain.model.events.OrbitWindowUnderutilizedEvent;
import com.spire.platform.u20231b475.missions.domain.model.valueobjects.MissionAssignmentStatus;
import com.spire.platform.u20231b475.missions.domain.model.valueobjects.SatelliteCode;
import com.spire.platform.u20231b475.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;

/**
 * The mission assignment aggregate root
 */
@Entity
@Getter
public class MissionAssignment extends AuditableAbstractAggregateRoot<MissionAssignment> {
  @Embedded
  private SatelliteCode satelliteCode;

  @NotBlank(message = "Orbit class is required")
  private String orbitClass;

  @NotNull(message = "The estimated duration is required")
  @Min(1)
  private Integer estimatedDuration;

  @Enumerated(EnumType.STRING)
  private MissionAssignmentStatus status;

  @NotNull(message = "The requested date is required")
  @PastOrPresent
  private LocalDateTime requestedAt;

  public MissionAssignment() {
    // Empty for JPA purposes
  }

  public MissionAssignment(CreateMissionAssignmentCommand command) {
    this.satelliteCode = new SatelliteCode(command.satelliteCode());
    this.orbitClass = command.orbitClass();
    this.estimatedDuration = command.estimatedDuration();
    this.status = command.status();
    this.requestedAt = command.requestedAt();
  }

  public void orbitWindowUnderutilized() {
    this.registerEvent(new OrbitWindowUnderutilizedEvent(this, satelliteCode.satelliteCode()));
  }
}
