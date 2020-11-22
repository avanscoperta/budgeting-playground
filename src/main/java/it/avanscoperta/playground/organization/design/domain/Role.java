package it.avanscoperta.playground.organization.design.domain;

/**
 * Represents a role in the organization.
 * Just a label for now. Not so far away from reality in many organizations.
 */
public class Role {
    private final String label;

    public Role(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
