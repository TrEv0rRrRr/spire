package com.spire.platform.u20231b475.regulations.domain.service;

import java.util.Optional;

import com.spire.platform.u20231b475.regulations.domain.model.aggregates.OrbitThreshold;
import com.spire.platform.u20231b475.regulations.domain.model.queries.GetOrbitThresholdByOrbitClassQuery;

/**
 * This service is for query handling
 * 
 * @author Valentino Solis
 */
public interface OrbitThresholdQueryService {
  /**
   * Handle get orbit threshold by orbit class query
   * 
   * @param query The {@link GetOrbitThresholdByOrbitClassQuery} query
   * @return an {@link Optional} of {@link OrbitThreshold} entity
   */
  Optional<OrbitThreshold> handle(GetOrbitThresholdByOrbitClassQuery query);
}
