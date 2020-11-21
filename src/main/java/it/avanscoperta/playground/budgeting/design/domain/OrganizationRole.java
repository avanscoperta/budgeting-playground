package it.avanscoperta.playground.budgeting.design.domain;

/**
 * Represents a role in the organization.
 * Just a label for now. Not so far away from reality in many organizations.
 */
public class OrganizationRole {
    private final String label;

    public OrganizationRole(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
