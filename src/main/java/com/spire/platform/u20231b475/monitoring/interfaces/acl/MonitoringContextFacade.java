package com.spire.platform.u20231b475.monitoring.interfaces.acl;

/**
 * MonitoringContextFacade
 */
public interface MonitoringContextFacade {
  /**
   * Creates a new alert
   * 
   * @param satelliteCode the satellite code
   * @param alertType     the type of alert
   * @return The Alert id
   */
  Long createAlert(String satelliteCode, String alertType);
}
