package it.avanscoperta.playground.budgeting.design.domain;

import it.avanscoperta.playground.common.OrganizationMember;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BudgetingModelTest {

    @Test
    @DisplayName("An empty budgeting model is not complete")
    public void an_empty_model_is_not_complete() {
        OrganizationStructureReader orgReader = new MockOrganizationStructureReader("Test Org");
        BudgetingModel thisYear = BudgetingModel.emptyFor(orgReader);
        assertFalse(thisYear.isComplete());
    }

    @Test
    @DisplayName("Can assign tasks to organization members")
    public void can_add_tasks_to_members() {
        OrganizationStructureReader orgReader = new MockOrganizationStructureReader("Test Org");
        BudgetingModel firstModel = BudgetingModel.emptyFor(orgReader);

        OrganizationMember boss = orgReader.peopleWithBudgetingResponsibilities().stream().findFirst().get();
        firstModel.assignTask(
                boss,
                TaskTypes.BUDGETING,
                "Manually assigned (in test)");

        assertTrue(firstModel.getAssignedTasks().stream().count() >= 1);
        assertTrue(firstModel.getAssignedTasks().stream().allMatch(task -> task.isAssignedTo(boss)));
    }

    @Test
    @DisplayName("Trivial organization: when budgeting is assigned to the boss, we're done.")
    public void adding_one_task_to_one_member_completes_the_plan() {
        OrganizationStructureReader orgReader = new MockOrganizationStructureReader("Test Org");
        BudgetingModel firstModel = BudgetingModel.emptyFor(orgReader);

        firstModel.assignTask(
                orgReader.peopleWithBudgetingResponsibilities().stream().findFirst().get(),
                TaskTypes.BUDGETING,
                "Manually assigned (in test)");

        assertTrue(firstModel.isComplete());
    }


    @Test
    @DisplayName("A Budgeting model created with the factory is born complete.")
    public void simplest_case_of_budgeting_model() {
        OrganizationStructureReader orgReader = new MockOrganizationStructureReader("Test Org");
        BudgetingModel thisYearModel = BudgetingModel.fromStructure(orgReader);

        assertTrue(thisYearModel.isComplete());
    }



    private class MockOrganizationStructureReader implements OrganizationStructureReader {
        List<OrganizationMember> budgetPeople = new ArrayList<>();
        String orgName;

        public MockOrganizationStructureReader(String orgName) {
            this.orgName = orgName;
            budgetPeople.add(new OrganizationMemberTestBuilder().build());
        }

        @Override
        public List<OrganizationMember> peopleWithBudgetingResponsibilities() {
            return budgetPeople;
        }
    }
}
