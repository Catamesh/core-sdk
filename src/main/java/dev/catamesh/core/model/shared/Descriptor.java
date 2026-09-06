package dev.catamesh.core.model.shared;

import java.util.List;

public record Descriptor(String name, String displayName, String description, List<Tag> tags) {
}
