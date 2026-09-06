package dev.catamesh.core.model;

import java.util.List;

public record Owner(String name, List<Contact> contacts) {
}
