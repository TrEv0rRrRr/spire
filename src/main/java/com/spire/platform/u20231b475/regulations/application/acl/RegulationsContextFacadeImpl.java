package com.spire.platform.u20231b475.regulations.application.acl;

import org.springframework.stereotype.Service;

import com.spire.platform.u20231b475.regulations.domain.model.queries.GetOrbitThresholdByOrbitClassQuery;
import com.spire.platform.u20231b475.regulations.domain.service.OrbitThresholdQueryService;
import com.spire.platform.u20231b475.regulations.infrastructure.persistence.jpa.repositories.OrbitThresholdRepository;
import com.spire.platform.u20231b475.regulations.interfaces.acl.RegulationsContextFacade;

/**
 * RegulationsContextFacadeImplementation
 * 
 * @author Valentino Solis
 */
@Service
public class RegulationsContextFacadeImpl implements RegulationsContextFacade {
  private final OrbitThresholdQueryService service;
  private final OrbitThresholdRepository repo;

  public RegulationsContextFacadeImpl(OrbitThresholdQueryService service, OrbitThresholdRepository repo) {
    this.service = service;
    this.repo = repo;
  }

  @Override
  public Long fetchByOrbitClass(String orbitClass) {
    var query = new GetOrbitThresholdByOrbitClassQuery(orbitClass);

    var orbitThreshold = service.handle(query);

    return orbitThreshold.isEmpty() ? 0L : orbitThreshold.get().getId();
  }

  public boolean isUnderutilized(String orbitClass, Integer estimatedDuration) {
    return repo.findByOrbitClass(orbitClass)
        .map(threshold -> estimatedDuration < (threshold.getMaxSafeDuration() * 0.2))
        .orElse(false);
  }
}
