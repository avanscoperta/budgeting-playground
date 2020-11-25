package it.avanscoperta.playground.organization.design.domain;

import java.util.Objects;

/**
 * Represents a role in the organization.
 * Just a label for now. Not so far away from reality in many organizations. #Sarcasm
 */
public class Role {
    private final String label;

    public Role(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return label.equals(role.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
