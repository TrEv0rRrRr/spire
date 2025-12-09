package com.spire.platform.u20231b475.monitoring.domain.services;

import java.util.Optional;

import com.spire.platform.u20231b475.monitoring.domain.model.aggregates.Alert;
import com.spire.platform.u20231b475.monitoring.domain.model.commands.CreateAlertCommand;

/**
 * This service is for alerts command handling.
 */
public interface AlertCommandService {
  /**
   * Handle create alert command
   * 
   * @param command the {@link CreateAlertCommand}
   * @return an {@link Optional} of {@link Alert}
   */
  Optional<Alert> handle(CreateAlertCommand command);
}
