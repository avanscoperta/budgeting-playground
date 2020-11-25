package it.avanscoperta.playground.organization.design.domain;

import java.util.ArrayList;
import java.util.List;

public class DefaultDepartmentsCriteria implements OrganizationSpecification {

    List<Department> defaultDepartments = new ArrayList<>();

    public DefaultDepartmentsCriteria() {
        defaultDepartments.add(new Department("R & D"));
        defaultDepartments.add(new Department("Delivery"));
        defaultDepartments.add(new Department("Operations"));
        defaultDepartments.add(new Department("Sales"));
    }

    @Override
    public boolean isSatisfiedBy(OrganizationStructure org) {
        return defaultDepartments.stream().allMatch(department -> org.hasDepartment(department));
    }
}
