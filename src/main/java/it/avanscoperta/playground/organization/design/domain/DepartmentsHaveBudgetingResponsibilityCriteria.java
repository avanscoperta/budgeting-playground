package it.avanscoperta.playground.organization.design.domain;

public class DepartmentsHaveBudgetingResponsibilityCriteria implements OrganizationSpecification {
    @Override
    public boolean isSatisfiedBy(OrganizationStructure org) {
        return org.departments().stream().allMatch(department ->
            department.hasBudgetingResponsibilityAssigned());

    }
}
