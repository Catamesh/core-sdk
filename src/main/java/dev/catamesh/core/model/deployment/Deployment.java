package dev.catamesh.core.model.deployment;

import dev.catamesh.core.model.DocumentKind;
import dev.catamesh.core.model.SchemaVersion;

public record Deployment(
        SchemaVersion schemaVersion,
        DocumentKind kind,
        DeploymentSpec spec) {

    public String id() {
        return spec.dataProduct() + "@" + spec.environment().name();
    }
}
