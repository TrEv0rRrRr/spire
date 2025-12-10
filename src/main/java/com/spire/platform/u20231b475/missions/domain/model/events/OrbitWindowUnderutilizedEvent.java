package com.spire.platform.u20231b475.missions.domain.model.events;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

/**
 * OrbitWindowUnderutilizedEvent
 * Event that represents when an Orbit Window is underutilized
 */
@Getter
public class OrbitWindowUnderutilizedEvent extends ApplicationEvent {
  private String satelliteCode;

  public OrbitWindowUnderutilizedEvent(Object source, String satelliteCode) {
    super(source);
    this.satelliteCode = satelliteCode;
  }
}
