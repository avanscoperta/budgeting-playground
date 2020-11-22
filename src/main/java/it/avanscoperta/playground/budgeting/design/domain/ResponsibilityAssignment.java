package it.avanscoperta.playground.budgeting.design.domain;

public class ResponsibilityAssignment {
    private Responsibility responsibility;
    private OrganizationRole role;
    private String notes;

    public ResponsibilityAssignment(Responsibility responsibility, OrganizationRole role, String notes) {
        this.responsibility = responsibility;
        this.role = role;
        this.notes = notes;
    }
    // TODO: possibly more stuff here like validity intervals and so on.


    public Responsibility getResponsibility() {
        return responsibility;
    }

    public OrganizationRole getRole() {
        return role;
    }

    public String getNotes() {
        return notes;
    }
}
