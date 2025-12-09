package com.spire.platform.u20231b475.monitoring.application.acl;

import org.springframework.stereotype.Service;

import com.spire.platform.u20231b475.monitoring.domain.model.commands.CreateAlertCommand;
import com.spire.platform.u20231b475.monitoring.domain.model.valueobjects.AlertType;
import com.spire.platform.u20231b475.monitoring.domain.services.AlertCommandService;
import com.spire.platform.u20231b475.monitoring.interfaces.acl.MonitoringContextFacade;

@Service
public class MonitoringContextFacadeImpl implements MonitoringContextFacade {
  private final AlertCommandService service;

  public MonitoringContextFacadeImpl(AlertCommandService service) {
    this.service = service;
  }

  // inherited javadoc
  @Override
  public Long createAlert(String satelliteCode, String alertType) {
    var command = new CreateAlertCommand(satelliteCode, AlertType.valueOf(alertType));

    var alert = service.handle(command);
    return alert.isEmpty() ? 0L : alert.get().getId();
  }
}
