package it.avanscoperta.playground.organization.design.domain;

public interface OrganizationSpecification {
    boolean isSatisfiedBy(OrganizationStructure org);
}
