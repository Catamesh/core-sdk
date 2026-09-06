package dev.catamesh.core.model;

import dev.catamesh.core.model.schema.DataSchema;
import dev.catamesh.core.model.shared.SemVer;

import java.util.Map;

public record ResourceDefinition(
        String kind,
        SemVer version,
        DataSchema schema,
        Map<String, Object> configuration) {
}
