package dev.catamesh.core.model.deployment;

import java.util.List;

public record DeploymentSpec(
        String dataProduct,
        Environment environment,
        List<ResourceDeployment> resources) {
}
