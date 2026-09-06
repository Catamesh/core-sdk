package dev.catamesh.core.model.shared;

import java.util.List;
import java.util.Objects;

/**
 * Identity and documentation shared by the elements of a document.
 *
 * @param name        stable identifier, unique within its parent
 * @param displayName human friendly name, falls back to {@code name} when absent
 * @param description what the element is and when to use it
 * @param tags        free form classification
 */
public record Descriptor(String name, String displayName, String description, List<Tag> tags) {

    public Descriptor {
        Objects.requireNonNull(name, "descriptor name is required");
        if (name.isBlank()) {
            throw new IllegalArgumentException("descriptor name must not be blank");
        }
        tags = tags == null ? List.of() : List.copyOf(tags);
    }

    public static Descriptor of(String name) {
        return new Descriptor(name, null, null, List.of());
    }

    public String displayNameOrName() {
        return displayName == null || displayName.isBlank() ? name : displayName;
    }
}
