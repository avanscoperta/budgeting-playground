package it.avanscoperta.playground.budgeting.design.domain;

import org.junit.jupiter.api.Test;

public class BudgetingModelTest {


    @Test
    public void can_create_a_budgeting_model() {

        OrganizationStructure structure = OrganizationStructure.createSimple();
        BudgetingModel thisYearBudgetingModel = BudgetingModel.emptyFor(structure);


    }

}
