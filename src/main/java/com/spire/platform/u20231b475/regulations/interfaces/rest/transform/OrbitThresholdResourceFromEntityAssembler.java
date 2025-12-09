package com.spire.platform.u20231b475.regulations.interfaces.rest.transform;

import com.spire.platform.u20231b475.regulations.domain.model.aggregates.OrbitThreshold;
import com.spire.platform.u20231b475.regulations.interfaces.rest.resources.OrbitThresholdResource;

/**
 * Assembler to convert a OrbitThreshold entity to a OrbitThresholdResource.
 */
public class OrbitThresholdResourceFromEntityAssembler {
  /**
   * Converts an Orbit Threshold entity to a OrbitThreshold Resource
   * 
   * @param entity The {@link OrbitThreshold} entity
   * @return The {@link OrbitThresholdResource}
   */
  public static OrbitThresholdResource toResourceFromEntity(OrbitThreshold entity) {
    return new OrbitThresholdResource(entity.getOrbitClass(), entity.getMaxSafeDuration());
  }
}
