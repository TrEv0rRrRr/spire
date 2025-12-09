package com.spire.platform.u20231b475.regulations.application.acl;

import org.springframework.stereotype.Service;

import com.spire.platform.u20231b475.regulations.domain.model.queries.GetOrbitThresholdByOrbitClassQuery;
import com.spire.platform.u20231b475.regulations.domain.service.OrbitThresholdQueryService;
import com.spire.platform.u20231b475.regulations.interfaces.acl.RegulationsContextFacade;

@Service
public class RegulationsContextFacadeImpl implements RegulationsContextFacade {
  private final OrbitThresholdQueryService service;

  public RegulationsContextFacadeImpl(OrbitThresholdQueryService service) {
    this.service = service;
  }

  @Override
  public Long fetchByOrbitClass(String orbitClass) {
    var query = new GetOrbitThresholdByOrbitClassQuery(orbitClass);

    var orbitThreshold = service.handle(query);

    return orbitThreshold.isEmpty() ? 0L : orbitThreshold.get().getId();
  }
}
