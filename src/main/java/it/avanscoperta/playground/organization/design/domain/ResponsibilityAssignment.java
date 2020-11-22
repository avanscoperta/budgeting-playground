package it.avanscoperta.playground.organization.design.domain;

public class ResponsibilityAssignment {
    private Responsibility responsibility;
    private Role role;
    private String notes;

    public ResponsibilityAssignment(Responsibility responsibility, Role role, String notes) {
        this.responsibility = responsibility;
        this.role = role;
        this.notes = notes;
    }
    // TODO: possibly more stuff here like validity intervals and so on.


    public Responsibility getResponsibility() {
        return responsibility;
    }

    public Role getRole() {
        return role;
    }

    public String getNotes() {
        return notes;
    }
}
