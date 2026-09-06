package dev.catamesh.core.model.resource;

import java.util.Objects;

/**
 * Platform a resource is materialised on, and the artifact it is materialised as.
 *
 * <p>Identifies who has to know how to provision the resource. A resource is born and retired on one
 * platform: migrating means creating a new resource, not changing this one.</p>
 *
 * <p>The three parts stay open on purpose. A closed vocabulary would leave out the next managed
 * service, the on premises deployment or the vendor that is not a cloud.</p>
 *
 * @param provider who operates the platform, for instance {@code aws}, {@code gcp}, {@code confluent} or {@code on-prem}
 * @param service  service within the provider, for instance {@code s3}, {@code bigquery} or {@code kafka}
 * @param artifact artifact managed within the service, for instance {@code table}, {@code topic} or {@code parquet-dataset}
 */
public record ResourceKind(String provider, String service, String artifact) {

    public ResourceKind {
        provider = requireText(provider, "provider");
        service = requireText(service, "service");
        artifact = requireText(artifact, "artifact");
    }

    /** Serialised form, for instance {@code aws:s3/parquet-dataset}. */
    public String getValue() {
        return provider + ":" + service + "/" + artifact;
    }

    public static ResourceKind fromValue(String value) {
        Objects.requireNonNull(value, "resource kind is required");
        int separator = value.indexOf(':');
        int artifact = value.indexOf('/', separator + 1);
        if (separator < 0 || artifact < 0) {
            throw new IllegalArgumentException("resource kind must be provider:service/artifact, was: " + value);
        }
        return new ResourceKind(
                value.substring(0, separator),
                value.substring(separator + 1, artifact),
                value.substring(artifact + 1));
    }

    private static String requireText(String value, String field) {
        Objects.requireNonNull(value, () -> "resource kind " + field + " is required");
        if (value.isBlank()) {
            throw new IllegalArgumentException("resource kind " + field + " must not be blank");
        }
        return value;
    }
}
