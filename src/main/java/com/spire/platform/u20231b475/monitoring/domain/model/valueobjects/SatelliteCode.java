package com.spire.platform.u20231b475.monitoring.domain.model.valueobjects;

import java.util.UUID;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

/**
 * This VO represents the satellite code, it's the business unique identifier
 */
@Embeddable
public record SatelliteCode(@NotBlank(message = "The satellite code is required") String satelliteCode) {
  public SatelliteCode {
    try {
      UUID.fromString(satelliteCode);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Satellite code must be a valid UUID", e);
    }
  }
}
