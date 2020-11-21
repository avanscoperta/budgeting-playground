package it.avanscoperta.playground.budgeting.design.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class OrganizationStructureTest {

    @Test
    public void can_create_an_organization() {

        String orgName = "Small Company";

        // TODO: this calls for something better
        OrganizationMember member = new MemberBuilder().build();
        List<OrganizationMember> members = new ArrayList<OrganizationMember>();
        members.add(member);

        OrganizationStructure smallOrg =
                OrganizationStructure.createSimple(orgName, members);

        assertNotNull(smallOrg);

    }

    @Test
    public void can_add_responsibilities() {
        fail("No implementation yet");
    }
}
