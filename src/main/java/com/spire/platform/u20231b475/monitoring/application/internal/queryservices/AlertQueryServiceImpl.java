package com.spire.platform.u20231b475.monitoring.application.internal.queryservices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spire.platform.u20231b475.monitoring.domain.model.aggregates.Alert;
import com.spire.platform.u20231b475.monitoring.domain.model.queries.GetAllAlertsQuery;
import com.spire.platform.u20231b475.monitoring.domain.services.AlertQueryService;
import com.spire.platform.u20231b475.monitoring.infrastructure.persistence.jpa.repositories.AlertRepository;

/**
 * Alert Query Service Implementation
 */
@Service
public class AlertQueryServiceImpl implements AlertQueryService {
  private final AlertRepository repo;

  public AlertQueryServiceImpl(AlertRepository repo) {
    this.repo = repo;
  }

  // inherited javadoc
  @Override
  public List<Alert> handle(GetAllAlertsQuery query) {
    return repo.findAll();
  }
}
