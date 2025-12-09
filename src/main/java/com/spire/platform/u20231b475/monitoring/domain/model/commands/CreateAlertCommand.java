package com.spire.platform.u20231b475.monitoring.domain.model.commands;

import com.spire.platform.u20231b475.monitoring.domain.model.valueobjects.AlertType;

public record CreateAlertCommand(String satelliteCode, AlertType alertType) {

}
