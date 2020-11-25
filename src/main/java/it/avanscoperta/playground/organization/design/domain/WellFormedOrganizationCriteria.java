package it.avanscoperta.playground.organization.design.domain;

/**
 * A top-class Specification building on top of more specific local predicates.
 */
public class WellFormedOrganizationCriteria implements OrganizationSpecification {
    DefaultDepartmentsCriteria defaultDepartments =
            new DefaultDepartmentsCriteria();
    DepartmentsHaveLeadershipCriteria departmentsHaveLeadership =
            new DepartmentsHaveLeadershipCriteria();
    DepartmentsHaveBudgetingResponsibilityCriteria departmentsHaveBudgetingResponsibility =
            new DepartmentsHaveBudgetingResponsibilityCriteria();

    @Override
    public boolean isSatisfiedBy(OrganizationStructure org) {
        return org.hasRole("CEO") &&
                defaultDepartments.isSatisfiedBy(org) &&
                departmentsHaveLeadership.isSatisfiedBy(org) &&
                departmentsHaveBudgetingResponsibility.isSatisfiedBy(org);
        // Lots of space for composition, nesting etc.
    }
}
