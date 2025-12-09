package com.spire.platform.u20231b475.regulations.interfaces.acl;

/**
 * RegulationsContextFacade
 * 
 * @author Valentino Solis
 */
public interface RegulationsContextFacade {
  /**
   * Fetches an orbit threshold by its orbit class
   * 
   * @param orbitClass the orbit class
   * @return The OrbitThreshold ID
   */
  Long fetchByOrbitClass(String orbitClass);
}
