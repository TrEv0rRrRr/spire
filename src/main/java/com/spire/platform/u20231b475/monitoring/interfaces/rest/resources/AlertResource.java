package com.spire.platform.u20231b475.monitoring.interfaces.rest.resources;

import java.util.Date;
import java.time.LocalDateTime;

import com.spire.platform.u20231b475.monitoring.domain.model.valueobjects.AlertType;
import com.spire.platform.u20231b475.monitoring.domain.model.valueobjects.SatelliteCode;

/**
 * Alert Resource
 */
public record AlertResource(Long id, SatelliteCode satelliteCode, AlertType alertType, LocalDateTime registeredAt,
        Date createdAt, Date updatedAt) {

}
