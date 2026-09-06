package dev.catamesh.core.model.resource;

import dev.catamesh.core.model.schema.DataSchema;
import dev.catamesh.core.model.shared.SemVer;

import java.util.Map;

public record ResourceDefinition(
        SemVer version,
        DataSchema schema,
        Map<String, Object> configuration) {
}
