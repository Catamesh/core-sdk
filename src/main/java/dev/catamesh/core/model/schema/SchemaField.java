package dev.catamesh.core.model.schema;

import dev.catamesh.core.model.shared.Tag;

import java.util.List;
import java.util.Objects;

public record SchemaField(String name,
                          String type,
                          String description,
                          boolean required,
                          List<SchemaField> fields,
                          List<Tag> tags) {

    public SchemaField {
        name = requireText(name, "name");
        type = requireText(type, "type");
        fields = fields == null ? List.of() : List.copyOf(fields);
        tags = tags == null ? List.of() : List.copyOf(tags);
    }

    public static SchemaField of(String name, String type) {
        return new SchemaField(name, type, null, false, List.of(), List.of());
    }

    public static SchemaField required(String name, String type) {
        return new SchemaField(name, type, null, true, List.of(), List.of());
    }

    private static String requireText(String value, String field) {
        Objects.requireNonNull(value, () -> "schema field " + field + " is required");
        if (value.isBlank()) {
            throw new IllegalArgumentException("schema field " + field + " must not be blank");
        }
        return value;
    }
}
