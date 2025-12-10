package com.spire.platform.u20231b475.missions.application.internal.eventhandlers;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.spire.platform.u20231b475.missions.application.internal.outboundservices.acl.ExternalMonitoringService;
import com.spire.platform.u20231b475.missions.domain.model.events.OrbitWindowUnderutilizedEvent;

/**
 * Event handler for the OrbitWindowUnderutilizedEvent
 */
@Service
public class OrbitWindowUnderutilizedEventHandler {
  private final ExternalMonitoringService service;

  public OrbitWindowUnderutilizedEventHandler(ExternalMonitoringService service) {
    this.service = service;
  }

  /**
   * Handles the OrbitWindowUnderutilizedEvent
   * 
   * <p>
   * Creates a new alert with the given satellite code and with "SYSTEM_ERROR" as
   * alert type
   * </p>
   * 
   * @param event The {@link OrbitWindowUnderutilizedEvent}
   */
  @EventListener
  public void on(OrbitWindowUnderutilizedEvent event) {
    service.createAlert(event.getSatelliteCode(), "SYSTEM_ERROR");
  }
}
