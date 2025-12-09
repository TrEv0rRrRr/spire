package com.spire.platform.u20231b475.regulations.interfaces.acl;

import java.util.Optional;

import com.spire.platform.u20231b475.regulations.interfaces.rest.resources.OrbitThresholdResource;

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
   * @return an {@link Optional} of {@link OrbitThreshold}
   */
  Optional<OrbitThresholdResource> fetchByOrbitClass(String orbitClass);
}
