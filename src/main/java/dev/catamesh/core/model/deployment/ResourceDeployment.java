package dev.catamesh.core.model.deployment;

import dev.catamesh.core.model.shared.SemVer;

import java.time.Instant;

public record ResourceDeployment(String resource,
                                 SemVer version,
                                 DeploymentStatus status,
                                 Instant lastTransitionAt,
                                 String message) {
}
