package com.spire.platform.u20231b475.regulations.application.internal.queryservices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spire.platform.u20231b475.regulations.domain.model.aggregates.OrbitThreshold;
import com.spire.platform.u20231b475.regulations.domain.model.queries.GetOrbitThresholdByOrbitClassQuery;
import com.spire.platform.u20231b475.regulations.domain.service.OrbitThresholdQueryService;
import com.spire.platform.u20231b475.regulations.infrastructure.persistence.jpa.repositories.OrbitThresholdRepository;

/**
 * Orbit Threshold Query Service Implementation
 * @author Valentino Solis
 */
@Service
public class OrbitThresholdQueryServiceImpl implements OrbitThresholdQueryService {
  private final OrbitThresholdRepository repo;

  public OrbitThresholdQueryServiceImpl(OrbitThresholdRepository repo) {
    this.repo = repo;
  }

  /**
   * Handle the get orbit threshold by orbit class query
   * 
   * @return {@link Optional} of {@link OrbitThreshold} instance
   */
  @Override
  public Optional<OrbitThreshold> handle(GetOrbitThresholdByOrbitClassQuery query) {
    return repo.findByOrbitClass(query.orbitClass());
  }
}
