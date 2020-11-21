package it.avanscoperta.playground.budgeting.design.domain;

import java.util.List;

public class OrganizationStructure {

    /**
     * Clearly temporary. Just need to have things going.
     * @return
     * @param orgName the name of the newly created organization;
     * @param members a List if members of this organization;
     */
    public static OrganizationStructure createSimple(String orgName, List<OrganizationMember> members) {
        return new OrganizationStructure();
    }
}
