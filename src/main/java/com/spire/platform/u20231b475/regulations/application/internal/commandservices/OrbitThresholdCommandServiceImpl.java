package com.spire.platform.u20231b475.regulations.application.internal.commandservices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spire.platform.u20231b475.regulations.domain.model.aggregates.OrbitThreshold;
import com.spire.platform.u20231b475.regulations.domain.model.commands.SeedOrbitThresholdCommand;
import com.spire.platform.u20231b475.regulations.domain.service.OrbitThresholdCommandService;
import com.spire.platform.u20231b475.regulations.infrastructure.persistence.jpa.repositories.OrbitThresholdRepository;

/**
 * Orbit Threshold Command Service Implementation
 * 
 * @author Valentino Solis
 */
@Service
public class OrbitThresholdCommandServiceImpl implements OrbitThresholdCommandService {
  private final OrbitThresholdRepository repo;

  public OrbitThresholdCommandServiceImpl(OrbitThresholdRepository repo) {
    this.repo = repo;
  }

  /**
   * Handle the seed orbit threshold command. It will create the registers inside
   * of the table.
   */
  @Override
  public void handle(SeedOrbitThresholdCommand command) {
    if (repo.count() > 0)
      return;

    repo.saveAll(List.of(
        new OrbitThreshold("LEO", 300),
        new OrbitThreshold("MEO", 450),
        new OrbitThreshold("GEO", 650)));
  }
}
