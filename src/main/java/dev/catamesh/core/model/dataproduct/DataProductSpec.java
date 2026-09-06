package dev.catamesh.core.model.dataproduct;

import dev.catamesh.core.model.resource.Resource;

import java.util.List;

public record DataProductSpec(Owner owner, List<Resource> resources) {
}
