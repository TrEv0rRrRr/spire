package com.spire.platform.u20231b475.monitoring.domain.services;

import java.util.List;

import com.spire.platform.u20231b475.monitoring.domain.model.aggregates.Alert;
import com.spire.platform.u20231b475.monitoring.domain.model.queries.GetAllAlertsQuery;

/**
 * This service is for alerts queries handling.
 */
public interface AlertQueryService {
  /**
   * Handle get all alerts query
   * 
   * @param query The {@link GetAllAlertsQuery}
   * @return A list of all existing alerts.
   */
  List<Alert> handle(GetAllAlertsQuery query);
}
