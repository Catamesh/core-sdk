package dev.catamesh.core.builder;

import dev.catamesh.core.model.DocumentKind;
import dev.catamesh.core.model.SchemaVersion;
import dev.catamesh.core.model.dataproduct.DataProduct;
import dev.catamesh.core.model.dataproduct.DataProductSpec;
import dev.catamesh.core.model.dataproduct.Owner;
import dev.catamesh.core.model.resource.Resource;
import dev.catamesh.core.model.shared.Descriptor;
import dev.catamesh.core.model.shared.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataProductBuilder {

    private final SchemaVersion schemaVersion;
    private final DocumentKind kind;
    private final List<Tag> tags = new ArrayList<>();
    private final List<Resource> resources = new ArrayList<>();

    private String name;
    private String displayName;
    private String description;
    private Owner owner;

    public DataProductBuilder() {
        this.schemaVersion = SchemaVersion.V1;
        this.kind = DocumentKind.DATA_PRODUCT;
    }

    public DataProductBuilder name(String name) {
        this.name = name;
        return this;
    }

    public DataProductBuilder displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public DataProductBuilder description(String description) {
        this.description = description;
        return this;
    }

    public DataProductBuilder tag(String name, String value) {
        this.tags.add(new Tag(name, value));
        return this;
    }

    public DataProductBuilder owner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public DataProductBuilder owner(String name) {
        return owner(new Owner(name, List.of()));
    }

    public DataProductBuilder resource(Resource resource) {
        this.resources.add(resource);
        return this;
    }

    public DataProductBuilder resources(List<Resource> resources) {
        this.resources.addAll(resources);
        return this;
    }

    public SchemaVersion getSchemaVersion() {
        return schemaVersion;
    }

    public DocumentKind getKind() {
        return kind;
    }

    public Descriptor getDescriptor() {
        return new Descriptor(name, displayName, description, tags);
    }

    public DataProductSpec getSpec() {
        return new DataProductSpec(owner, List.copyOf(resources));
    }

    public DataProduct build() {
        Objects.requireNonNull(name, "a data product requires a name");
        Objects.requireNonNull(owner, "data product " + name + " requires an owner");
        return new DataProduct(this);
    }
}
