package com.spire.platform.u20231b475.regulations.interfaces.acl;

/**
 * RegulationsContextFacade
 * 
 * @author Valentino Solis
 */
public interface RegulationsContextFacade {
  /**
   * This method determines whether an orbit window is underutilized or not.
   * 
   * @param orbitClass        the orbit class
   * @param estimatedDuration the estimated duration
   * @return true if it's being underutilized, otherwise false.
   */
  public boolean isUnderutilized(String orbitClass, Integer estimatedDuration);
}
