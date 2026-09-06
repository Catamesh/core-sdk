package dev.catamesh.core.model.deployment;

import java.util.Arrays;

public enum DeploymentStatus {

    DRAFT("draft"),
    DEPLOYING("deploying"),
    DEPLOYED("deployed"),
    FAILED("failed"),
    STOPPED("stopped"),
    TERMINATED("terminated");

    private final String value;

    DeploymentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    /** Whether the resource is available to consumers right now. */
    public boolean isServing() {
        return this == DEPLOYED;
    }

    /** Whether the status is expected to change on its own. */
    public boolean isTransitional() {
        return this == DEPLOYING;
    }

    public static DeploymentStatus fromValue(String value) {
        return Arrays.stream(values())
                .filter(status -> status.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown deployment status: " + value));
    }
}
