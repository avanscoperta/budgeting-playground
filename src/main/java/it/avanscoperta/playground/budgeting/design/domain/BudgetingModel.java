package it.avanscoperta.playground.budgeting.design.domain;

import it.avanscoperta.playground.common.OrganizationMember;
import it.avanscoperta.playground.organization.design.domain.OrganizationStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BudgetingModel {

    private List<AssignedTask> assignedTasks;
    private OrganizationStructureReader structureReader;

    private BudgetingModel(OrganizationStructureReader structureReader) {
        this.assignedTasks = new ArrayList<AssignedTask>();
        this.structureReader = structureReader;
    }

    /**
     * Returns an empty budgeting model for the given organization structure.
     * @param structureReader a reader for the current OrganizationStructure
     * @return
     */
    public static BudgetingModel emptyFor(OrganizationStructureReader structureReader) {
        return new BudgetingModel(structureReader);
    }

    /**
     * factory method to crete a Budgeting Model from a given organization structure
     * @param orgReader
     * @return
     */
    public static BudgetingModel fromStructure(OrganizationStructureReader orgReader) {
        BudgetingModel model = new BudgetingModel(orgReader);

        // here is where it should look disappointingly simple.
        orgReader.peopleWithBudgetingResponsibilities()
                .stream()
                .forEach(budgetPerson -> model.assignTask(budgetPerson, TaskTypes.BUDGETING, "from structure"));

        return model;
    }

    public void assignTask(OrganizationMember assignee, TaskTypes taskType, String notes) {
        assignedTasks.add(new AssignedTask(taskType, assignee, notes ));
    }

    /**
     * #TODO: Temporary, probably a specification is needed.
     *
     * Returns true if all tasks in the model are properly set up.
     *
     * @return
     */
    public boolean isComplete() {
        return structureReader.peopleWithBudgetingResponsibilities().stream().allMatch(
                keyPerson -> hasBudgetingTaskAssigned(keyPerson));
    }

    private boolean hasBudgetingTaskAssigned(OrganizationMember keyPerson) {
        return assignedTasks.stream().anyMatch(task ->
                task.isAssignedTo(keyPerson) &&
                task.isBudgeting());
    }

    public List<AssignedTask> getAssignedTasks() {
        return assignedTasks;
    }
}
