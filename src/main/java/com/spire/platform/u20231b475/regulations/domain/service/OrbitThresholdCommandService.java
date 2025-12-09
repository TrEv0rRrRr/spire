package com.spire.platform.u20231b475.regulations.domain.service;

import com.spire.platform.u20231b475.regulations.domain.model.commands.SeedOrbitThresholdCommand;

/**
 * This service is for command handling
 * 
 * @author Valentino Solis
 */
public interface OrbitThresholdCommandService {
  /**
   * Handle seed orbit threshold command
   * 
   * @param command The {@link SeedOrbitThresholdCommand} command
   */
  void handle(SeedOrbitThresholdCommand command);
}
