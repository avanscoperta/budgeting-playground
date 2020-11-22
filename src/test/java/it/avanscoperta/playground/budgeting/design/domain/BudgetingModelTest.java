package it.avanscoperta.playground.budgeting.design.domain;

import it.avanscoperta.playground.common.OrganizationMember;

// FIXME: this can potentially be an awkward dependency later on.
import it.avanscoperta.playground.organization.design.domain.OrganizationStructure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class BudgetingModelTest {

    @Test
    @DisplayName("An empty budgeting model is not complete")
    public void can_create_a_budgeting_model() {
        List<OrganizationMember> members = new ArrayList<OrganizationMember>();
        OrganizationStructure structure = OrganizationStructure.createSimple("Ghost Org.", members);
        BudgetingModel thisYearBudgetingModel = BudgetingModel.emptyFor(structure);
        assertFalse(thisYearBudgetingModel.isComplete());
    }

}
