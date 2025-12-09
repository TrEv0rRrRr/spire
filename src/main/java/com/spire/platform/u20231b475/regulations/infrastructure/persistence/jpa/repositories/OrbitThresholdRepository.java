package com.spire.platform.u20231b475.regulations.infrastructure.persistence.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spire.platform.u20231b475.regulations.domain.model.aggregates.OrbitThreshold;

/**
 * This interface is responsible for providing the OrbitThreshold entity related
 * operations.
 * It extends the JpaRepository interface.
 */
@Repository
public interface OrbitThresholdRepository extends JpaRepository<OrbitThreshold, Long> {

  /**
   * Finds an orbit class by its orbit class
   * 
   * @param orbitClass The orbit class
   * @return A {@link OrbitThreshold} if the given properties are valid, otherwise
   *         empty
   */
  Optional<OrbitThreshold> findByOrbitClass(String orbitClass);
}
