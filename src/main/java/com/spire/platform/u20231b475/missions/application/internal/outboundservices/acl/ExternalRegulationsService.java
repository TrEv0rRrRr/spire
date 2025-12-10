package com.spire.platform.u20231b475.missions.application.internal.outboundservices.acl;

import org.springframework.stereotype.Service;

import com.spire.platform.u20231b475.regulations.interfaces.acl.RegulationsContextFacade;

/**
 * ExternalRegulationsService
 * 
 * @author Valentino Solis
 */
@Service
public class ExternalRegulationsService {
  private final RegulationsContextFacade facade;

  public ExternalRegulationsService(RegulationsContextFacade facade) {
    this.facade = facade;
  }

  /**
   * This method determines whether an orbit window is underutilized or not.
   * 
   * @param orbitClass        the orbit class
   * @param estimatedDuration the estimated duration
   * @return true if it is being underutilized, otherwise false.
   */
  public boolean isUnderutilized(String orbitClass, Integer estimatedDuration) {
    return facade.isUnderutilized(orbitClass, estimatedDuration);
  }
}
