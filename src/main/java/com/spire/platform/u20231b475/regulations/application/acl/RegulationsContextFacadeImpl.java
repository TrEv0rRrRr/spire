package com.spire.platform.u20231b475.regulations.application.acl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spire.platform.u20231b475.regulations.domain.model.queries.GetOrbitThresholdByOrbitClassQuery;
import com.spire.platform.u20231b475.regulations.domain.service.OrbitThresholdQueryService;
import com.spire.platform.u20231b475.regulations.interfaces.acl.RegulationsContextFacade;
import com.spire.platform.u20231b475.regulations.interfaces.rest.resources.OrbitThresholdResource;
import com.spire.platform.u20231b475.regulations.interfaces.rest.transform.OrbitThresholdResourceFromEntityAssembler;

@Service
public class RegulationsContextFacadeImpl implements RegulationsContextFacade {
  private final OrbitThresholdQueryService service;

  public RegulationsContextFacadeImpl(OrbitThresholdQueryService service) {
    this.service = service;
  }

  @Override
  public Optional<OrbitThresholdResource> fetchByOrbitClass(String orbitClass) {
    var query = new GetOrbitThresholdByOrbitClassQuery(orbitClass);

    return service.handle(query).map(OrbitThresholdResourceFromEntityAssembler::toResourceFromEntity);
  }
}
