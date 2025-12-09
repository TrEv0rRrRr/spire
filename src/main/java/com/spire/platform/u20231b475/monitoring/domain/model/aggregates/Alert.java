package com.spire.platform.u20231b475.monitoring.domain.model.aggregates;

import java.time.LocalDateTime;

import com.spire.platform.u20231b475.monitoring.domain.model.commands.CreateAlertCommand;
import com.spire.platform.u20231b475.monitoring.domain.model.valueobjects.AlertType;
import com.spire.platform.u20231b475.monitoring.domain.model.valueobjects.SatelliteCode;
import com.spire.platform.u20231b475.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

/**
 * The alert aggregate root
 */
@Entity
@Getter
public class Alert extends AuditableAbstractAggregateRoot<Alert> {
  @Embedded
  private SatelliteCode satelliteCode;

  @Enumerated(EnumType.STRING)
  private AlertType alertType;

  @NotNull(message = "The register date must exists")
  private LocalDateTime registeredAt;

  public Alert() {
    // Empty for JPA purposes
  }

  public Alert(CreateAlertCommand command) {
    this.satelliteCode = new SatelliteCode(command.satelliteCode());
    this.alertType = command.alertType();
    this.registeredAt = LocalDateTime.now();
  }
}
