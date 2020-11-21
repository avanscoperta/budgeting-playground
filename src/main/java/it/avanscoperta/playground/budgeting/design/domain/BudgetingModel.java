package it.avanscoperta.playground.budgeting.design.domain;

public class BudgetingModel {
    /**
     * Returns an empty budgeting model for the given organization structure.
     * @param structure the current OrganizationStructure
     * @return
     */
    public static BudgetingModel emptyFor(OrganizationStructure structure) {
        return new BudgetingModel();
    }

    /**
     * Temporary, probably a specification is needed.
     * @return
     */
    public boolean isComplete() {
        return false;
    }
}
