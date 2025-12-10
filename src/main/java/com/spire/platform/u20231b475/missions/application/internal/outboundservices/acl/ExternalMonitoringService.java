package com.spire.platform.u20231b475.missions.application.internal.outboundservices.acl;

import org.springframework.stereotype.Service;

import com.spire.platform.u20231b475.monitoring.interfaces.acl.MonitoringContextFacade;

/**
 * ExternalMonitoringService
 * 
 * @author Valentino Solis
 */
@Service
public class ExternalMonitoringService {
  private final MonitoringContextFacade facade;

  public ExternalMonitoringService(MonitoringContextFacade facade) {
    this.facade = facade;
  }

  /**
   * Create an alert
   * 
   * @param satelliteCode the satellite code
   * @param alertType     the alert type
   * @return The id of the created alert.
   */
  public Long createAlert(String satelliteCode, String alertType) {
    return facade.createAlert(satelliteCode, alertType);
  }
}
