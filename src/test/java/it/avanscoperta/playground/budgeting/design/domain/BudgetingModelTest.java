package it.avanscoperta.playground.budgeting.design.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class BudgetingModelTest {


    @Test
    public void can_create_a_budgeting_model() {

        OrganizationStructure structure = OrganizationStructure.createSimple();
        BudgetingModel thisYearBudgetingModel = BudgetingModel.emptyFor(structure);
        assertFalse(thisYearBudgetingModel.isComplete());

    }

}
