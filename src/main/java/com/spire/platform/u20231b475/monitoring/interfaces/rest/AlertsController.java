package com.spire.platform.u20231b475.monitoring.interfaces.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spire.platform.u20231b475.monitoring.domain.model.queries.GetAllAlertsQuery;
import com.spire.platform.u20231b475.monitoring.domain.services.AlertQueryService;
import com.spire.platform.u20231b475.monitoring.interfaces.rest.resources.AlertResource;
import com.spire.platform.u20231b475.monitoring.interfaces.rest.transform.AlertResourceFromEntityAssembler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Alerts controller
 */
@RestController
@RequestMapping(value = "/api/v1/alerts")
@Tag(name = "Alerts controller", description = "Available alerts controller")
public class AlertsController {
  private final AlertQueryService service;

  public AlertsController(AlertQueryService service) {
    this.service = service;
  }

  /**
   * Get all alerts
   * 
   * @return The list of {@link AlertResource} resources for all alerts.
   */
  @GetMapping
  @Operation(summary = "Get all courses")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Alerts found"),
      @ApiResponse(responseCode = "404", description = "Alerts not found")
  })
  public ResponseEntity<List<AlertResource>> getAllAlerts() {
    var alerts = service.handle(new GetAllAlertsQuery());

    if (alerts.isEmpty())
      return ResponseEntity.notFound().build();

    var alertResources = alerts.stream().map(AlertResourceFromEntityAssembler::toResourceFromEntity).toList();

    return ResponseEntity.ok(alertResources);
  }
}
