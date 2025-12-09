package com.spire.platform.u20231b475.regulations.application.internal.eventhandlers;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.spire.platform.u20231b475.regulations.domain.model.commands.SeedOrbitThresholdCommand;
import com.spire.platform.u20231b475.regulations.domain.service.OrbitThresholdCommandService;

/**
 * ApplicationReadyEventHandler class
 * This class is used to handle the ApplicationReadyEvent
 */
@Service
public class ApplicationReadyEventHandler {
  private final OrbitThresholdCommandService service;

  public ApplicationReadyEventHandler(OrbitThresholdCommandService service) {
    this.service = service;
  }

  /**
   * Handle the ApplicationReadyEvent
   * This method is used to seed the orbit threshold
   * 
   * @param event the ApplicationReadyEvent the event to handle
   */
  @EventListener
  public void on(ApplicationReadyEvent event) {
    var seedOrbitThresholdCommand = new SeedOrbitThresholdCommand();

    service.handle(seedOrbitThresholdCommand);
  }
}
