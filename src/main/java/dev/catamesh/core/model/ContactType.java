package dev.catamesh.core.model;

public enum ContactType {

    MAIL("mail"),
    SLACK("slack");

    private final String value;

    ContactType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
