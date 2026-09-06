package dev.catamesh.core.model.deployment;

import java.util.Objects;

public record Environment(String name) {

    public Environment {
        Objects.requireNonNull(name, "environment name is required");
        if (name.isBlank()) {
            throw new IllegalArgumentException("environment name must not be blank");
        }
    }

    public static Environment of(String name) {
        return new Environment(name);
    }
}
