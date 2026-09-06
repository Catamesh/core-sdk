package dev.catamesh.core.model;

public enum SchemaVersion {

    V1("catamesh/v1");

    private final String value;

    SchemaVersion(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
