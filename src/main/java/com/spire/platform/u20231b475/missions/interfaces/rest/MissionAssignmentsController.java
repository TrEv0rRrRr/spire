package com.spire.platform.u20231b475.missions.interfaces.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spire.platform.u20231b475.missions.domain.services.MissionAssignmentCommandService;
import com.spire.platform.u20231b475.missions.interfaces.rest.resources.CreateMissionAssignmentResource;
import com.spire.platform.u20231b475.missions.interfaces.rest.resources.MissionAssignmentResource;
import com.spire.platform.u20231b475.missions.interfaces.rest.transform.CreateMissionAssignmentCommandFromResourceAssembler;
import com.spire.platform.u20231b475.missions.interfaces.rest.transform.MissionAssignmentResourceFromEntityAssembler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * MissionAssignments controller
 */
@RestController
@RequestMapping(value = "/api/v1/mission-assignments")
@Tag(name = "MissionAssignments controller", description = "Available MissionAssignments endpoints")
public class MissionAssignmentsController {
  private final MissionAssignmentCommandService service;

  public MissionAssignmentsController(MissionAssignmentCommandService service) {
    this.service = service;
  }

  /**
   * Create a new mission assignment
   * 
   * @param resource The {@link MissionAssignmentResource} instance
   * @return The {@link MissionAssignmentResource} resource for the created
   *         mission assignment
   */
  @PostMapping
  @Operation(summary = "Create a new mission assignment")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Mission assignment created!"),
      @ApiResponse(responseCode = "400", description = "Bad request")
  })
  public ResponseEntity<MissionAssignmentResource> createMissionAssignment(
      @Valid @RequestBody CreateMissionAssignmentResource resource) {
    var createMissionAssignmentCommand = CreateMissionAssignmentCommandFromResourceAssembler
        .toCommandFromResource(resource);

    var missionAssignment = service.handle(createMissionAssignmentCommand);

    if (missionAssignment.isEmpty())
      return ResponseEntity.notFound().build();

    var createdMissionAssignment = missionAssignment.get();

    var missionAssignmentResource = MissionAssignmentResourceFromEntityAssembler
        .toResourceFromEntity(createdMissionAssignment);

    return new ResponseEntity<>(missionAssignmentResource, HttpStatus.CREATED);
  }
}
