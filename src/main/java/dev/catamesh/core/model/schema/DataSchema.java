package dev.catamesh.core.model.schema;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public record DataSchema(String format, List<SchemaField> fields) {

    public DataSchema {
        Objects.requireNonNull(format, "schema format is required");
        if (format.isBlank()) {
            throw new IllegalArgumentException("schema format must not be blank");
        }
        fields = fields == null ? List.of() : List.copyOf(fields);
        long distinct = fields.stream().map(SchemaField::name).distinct().count();
        if (distinct != fields.size()) {
            throw new IllegalArgumentException("schema field names must be unique");
        }
    }

    public static DataSchema of(String format, SchemaField... fields) {
        return new DataSchema(format, List.of(fields));
    }

    public Optional<SchemaField> field(String name) {
        return fields.stream().filter(field -> field.name().equals(name)).findFirst();
    }
}
