package dev.catamesh.core.model.shared;

import java.util.Comparator;

public record SemVer(int major, int minor, int patch) implements Comparable<SemVer> {

    private static final Comparator<SemVer> PRECEDENCE = Comparator.comparingInt(SemVer::major)
            .thenComparingInt(SemVer::minor)
            .thenComparingInt(SemVer::patch);

    public SemVer {
        requireNotNegative(major, "major");
        requireNotNegative(minor, "minor");
        requireNotNegative(patch, "patch");
    }

    @Override
    public int compareTo(SemVer other) {
        return PRECEDENCE.compare(this, other);
    }

    public boolean isNewerThan(SemVer other) {
        return compareTo(other) > 0;
    }

    public boolean isCompatibleWith(SemVer other) {
        return major == other.major;
    }

    private static void requireNotNegative(int value, String part) {
        if (value < 0) {
            throw new IllegalArgumentException("semver " + part + " must not be negative, was: " + value);
        }
    }
}
