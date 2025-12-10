package com.spire.platform.u20231b475.regulations.application.acl;

import org.springframework.stereotype.Service;

import com.spire.platform.u20231b475.regulations.domain.model.queries.GetOrbitThresholdByOrbitClassQuery;
import com.spire.platform.u20231b475.regulations.domain.service.OrbitThresholdQueryService;
import com.spire.platform.u20231b475.regulations.interfaces.acl.RegulationsContextFacade;

/**
 * RegulationsContextFacadeImplementation
 * 
 * @author Valentino Solis
 */
@Service
public class RegulationsContextFacadeImpl implements RegulationsContextFacade {
  private final OrbitThresholdQueryService service;

  public RegulationsContextFacadeImpl(OrbitThresholdQueryService service) {
    this.service = service;
  }

  // inherited javadoc
  @Override
  public boolean isUnderutilized(String orbitClass, Integer estimatedDuration) {
    var query = new GetOrbitThresholdByOrbitClassQuery(orbitClass);
    var threshold = service.handle(query);

    if (threshold.isEmpty())
      throw new IllegalArgumentException("No orbit threshold found for the given orbit class.");

    var maxSafeDuration = threshold.get().getMaxSafeDuration();

    return estimatedDuration < (maxSafeDuration * 0.2);
  }
}
