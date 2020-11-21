package it.avanscoperta.playground.budgeting.design.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class BudgetingModelTest {


    @Test
    @DisplayName("An empty budgeting model is not complete")
    public void can_create_a_budgeting_model() {
        OrganizationStructure structure = OrganizationStructure.createSimple();
        BudgetingModel thisYearBudgetingModel = BudgetingModel.emptyFor(structure);
        assertFalse(thisYearBudgetingModel.isComplete());
    }

}
