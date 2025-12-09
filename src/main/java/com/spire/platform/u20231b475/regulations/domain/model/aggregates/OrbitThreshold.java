package com.spire.platform.u20231b475.regulations.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

/**
 * The Orbit Threshold aggregate root
 * 
 * @author Valentino Solis
 */
@Entity
public class OrbitThreshold {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Getter
  @NotBlank(message = "Orbit class is required")
  private String orbitClass;

  @Getter
  @NotNull(message = "Max safe duration is required")
  @Min(0)
  private Integer maxSafeDuration;

  public OrbitThreshold() {
    // Empty for JPA purposes
  }

  public OrbitThreshold(String orbitClass,
      Integer maxSafeDuration) {
    this.orbitClass = orbitClass;
    this.maxSafeDuration = maxSafeDuration;
  }
}
