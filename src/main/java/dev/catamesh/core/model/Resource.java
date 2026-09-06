package dev.catamesh.core.model;

import dev.catamesh.core.model.shared.Descriptor;

import java.util.List;

public record Resource(
        Descriptor descriptor,
        ResourceType type,
        ResourceKind kind,
        List<ResourceDefinition> definitions) {
}
