package dev.catamesh.core.model.dataproduct;

import java.util.List;

public record Owner(String name, List<Contact> contacts) {
}
