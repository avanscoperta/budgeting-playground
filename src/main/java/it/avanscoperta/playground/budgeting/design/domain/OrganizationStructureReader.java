package it.avanscoperta.playground.budgeting.design.domain;

import it.avanscoperta.playground.common.OrganizationMember;

import java.util.Arrays;
import java.util.List;

/**
 * A Domain Service Interface containing only what we need to know here.
 */
public interface OrganizationStructureReader {

    /**
     * Returns a list of members in the current organization that have budgeting responsibilities
     * @return
     */
    List<OrganizationMember> peopleWithBudgetingResponsibilities();
}
