package dev.catamesh.core.model.resource;

public enum ResourceType {

    SIGNAL("signal"),
    STORAGE("storage");

    private final String value;

    ResourceType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
