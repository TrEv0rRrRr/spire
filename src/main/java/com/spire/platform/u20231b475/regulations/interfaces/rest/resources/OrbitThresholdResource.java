package com.spire.platform.u20231b475.regulations.interfaces.rest.resources;

/**
 * This DTO is used to send data to another bounded context through the ACL.
 * 
 * @author Valentino Solis
 */
public record OrbitThresholdResource(String orbitClass, Integer maxSafeDuration) {
}
