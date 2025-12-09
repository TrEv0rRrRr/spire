package com.spire.platform.u20231b475.monitoring.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spire.platform.u20231b475.monitoring.domain.model.aggregates.Alert;

/**
 * This interface is responsible for providing the Alert entity related
 * operations.
 * It extends the JpaRepository interface.
 */
@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
}
