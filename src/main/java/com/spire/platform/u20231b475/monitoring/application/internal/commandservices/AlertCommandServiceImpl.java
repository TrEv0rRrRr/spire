package com.spire.platform.u20231b475.monitoring.application.internal.commandservices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spire.platform.u20231b475.monitoring.domain.model.aggregates.Alert;
import com.spire.platform.u20231b475.monitoring.domain.model.commands.CreateAlertCommand;
import com.spire.platform.u20231b475.monitoring.domain.services.AlertCommandService;
import com.spire.platform.u20231b475.monitoring.infrastructure.persistence.jpa.repositories.AlertRepository;

/**
 * Alert Command Service Implementation
 */
@Service
public class AlertCommandServiceImpl implements AlertCommandService {
  private final AlertRepository repo;

  public AlertCommandServiceImpl(AlertRepository repo) {
    this.repo = repo;
  }

  // inherited javadoc
  @Override
  public Optional<Alert> handle(CreateAlertCommand command) {
    var alert = new Alert(command);

    repo.save(alert);
    return Optional.of(alert);
  }
}
