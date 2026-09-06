package dev.catamesh.core.model;

public enum DocumentKind {

    DATA_PRODUCT("data-product"),
    DEPLOYMENT("deployment");

    private final String value;

    DocumentKind(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
