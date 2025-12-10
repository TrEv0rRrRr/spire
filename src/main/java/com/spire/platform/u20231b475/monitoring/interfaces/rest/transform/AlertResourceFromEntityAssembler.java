package com.spire.platform.u20231b475.monitoring.interfaces.rest.transform;

import com.spire.platform.u20231b475.monitoring.domain.model.aggregates.Alert;
import com.spire.platform.u20231b475.monitoring.interfaces.rest.resources.AlertResource;

/**
 * Assembler to convert an Alert entity to a AlertResource.
 */
public class AlertResourceFromEntityAssembler {
  public static AlertResource toResourceFromEntity(Alert entity) {
    return new AlertResource(
        entity.getId(),
        entity.getSatelliteCode(),
        entity.getAlertType(),
        entity.getRegisteredAt(),
        entity.getCreatedAt(),
        entity.getUpdatedAt());
  }
}
