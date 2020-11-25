package it.avanscoperta.playground.organization.design.domain;

import java.util.Arrays;

public class DepartmentsHaveLeadershipCriteria implements OrganizationSpecification {

    @Override
    public boolean isSatisfiedBy(OrganizationStructure org) {
        return org.departments().stream().allMatch(department -> department.hasLeadershipPositionAssigned());
    }


}
