package it.avanscoperta.playground.organization.design.domain;

/**
 * A department inside the organization
 */
public class Department {

    private final String departmentName;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public boolean hasLeadershipPositionAssigned() {
        return true;
        // TODO: not implemented but I am glad you asked me. ;-)
    }

    public boolean hasBudgetingResponsibilityAssigned() {
        return true;
        // TODO: not implemented but I am glad you asked me. ;-)
    }
}
