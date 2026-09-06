package dev.catamesh.core.model.dataproduct;

import dev.catamesh.core.builder.DataProductBuilder;
import dev.catamesh.core.model.DocumentKind;
import dev.catamesh.core.model.SchemaVersion;
import dev.catamesh.core.model.shared.Descriptor;

public class DataProduct {

    private final SchemaVersion schemaVersion;
    private final DocumentKind kind;
    private final Descriptor descriptor;
    private final DataProductSpec spec;

    public DataProduct(DataProductBuilder builder) {
        this.schemaVersion = builder.getSchemaVersion();
        this.kind = builder.getKind();
        this.descriptor = builder.getDescriptor();
        this.spec = builder.getSpec();
    }

    public static DataProductBuilder builder() {
        return new DataProductBuilder();
    }

    public SchemaVersion getSchemaVersion() {
        return schemaVersion;
    }

    public DocumentKind getKind() {
        return kind;
    }

    public Descriptor getDescriptor() {
        return descriptor;
    }

    public DataProductSpec getSpec() {
        return spec;
    }
}
