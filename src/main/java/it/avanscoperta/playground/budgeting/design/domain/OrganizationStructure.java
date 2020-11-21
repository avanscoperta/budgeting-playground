package it.avanscoperta.playground.budgeting.design.domain;

import java.util.ArrayList;
import java.util.List;

public class OrganizationStructure {

    private List<OrganizationRole> roles;

    private OrganizationStructure() {
        roles = new ArrayList<>();
    }


    /**
     * Clearly temporary. Just need to have things going.
     * @return
     * @param orgName the name of the newly created organization;
     * @param members a List if members of this organization;
     */
    public static OrganizationStructure createSimple(String orgName, List<OrganizationMember> members) {
        return new OrganizationStructure();
    }

    public void addRole(OrganizationRole role) {
        roles.add(role);
    }

    public boolean hasRole(String role) {
        return roles.stream()
                .anyMatch(localRole -> role.equals(localRole.getLabel()));


    }
}
