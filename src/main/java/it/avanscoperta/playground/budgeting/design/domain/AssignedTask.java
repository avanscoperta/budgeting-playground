package it.avanscoperta.playground.budgeting.design.domain;

import it.avanscoperta.playground.common.OrganizationMember;

/**
 * A task assigned to a given member of the organization.
 */
public class AssignedTask {

    private TaskTypes label;
    private OrganizationMember assignee;
    private String notes;

    public AssignedTask(TaskTypes label, OrganizationMember assignee, String notes) {
        this.label = label;
        this.assignee = assignee;
        this.notes = notes;
    }

    public boolean isAssignedTo(OrganizationMember keyPerson) {
        return assignee.equals(keyPerson);
    }

    public boolean isBudgeting() {
        return label.equals(TaskTypes.BUDGETING);
    }
}
