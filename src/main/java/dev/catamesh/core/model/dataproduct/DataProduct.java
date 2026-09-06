package dev.catamesh.core.model.dataproduct;

import dev.catamesh.core.model.DocumentKind;
import dev.catamesh.core.model.SchemaVersion;
import dev.catamesh.core.model.shared.Descriptor;

public class DataProduct {

    private SchemaVersion schemaVersion;
    private DocumentKind kind;
    private Descriptor descriptor;
    private DataProductSpec spec;
}
