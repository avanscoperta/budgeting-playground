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

    /**
     * Very simple local predicate.
     *
     * @return
     */
    public boolean isProperlyAssigned() {
        return (label != null) &&
                (assignee != null) &&
                (notes != null);
    }

    public boolean isAssignedTo(OrganizationMember keyperson) {
        return assignee.equals(keyperson);
    }

    public boolean isBudgeting() {
        return label.equals(TaskTypes.BUDGETING);
    }
}
