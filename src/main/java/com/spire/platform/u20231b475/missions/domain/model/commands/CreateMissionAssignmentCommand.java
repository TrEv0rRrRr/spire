package com.spire.platform.u20231b475.missions.domain.model.commands;

import java.time.LocalDateTime;

import com.spire.platform.u20231b475.missions.domain.model.valueobjects.MissionAssignmentStatus;

/**
 * Command for mission assignments creation
 */
public record CreateMissionAssignmentCommand(String satelliteCode, String orbitClass,
    Integer estimatedDuration,
    MissionAssignmentStatus status,
    LocalDateTime requestedAt) {

}
