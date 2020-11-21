package it.avanscoperta.playground.budgeting.design.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrganizationStructureTest {

    private String orgName;

    @BeforeEach
    public void setUp() {
        orgName = "Small Company";
    }


    @Test
    public void can_create_an_organization() {

        // TODO: this calls for something better
        OrganizationMember member = new MemberBuilder().build();
        List<OrganizationMember> members = new ArrayList<OrganizationMember>();
        members.add(member);

        OrganizationStructure smallOrg =
                OrganizationStructure.createSimple(orgName, members);

        assertNotNull(smallOrg);
    }

    @Test
    public void can_add_roles() {

        // TODO: this calls for something better and moving
        OrganizationMember member = new MemberBuilder().build();
        List<OrganizationMember> members = new ArrayList<OrganizationMember>();
        members.add(member);

        OrganizationStructure smallOrg =
                OrganizationStructure.createSimple(orgName, members);

        smallOrg.addRole(new OrganizationRole("CEO"));

        assertTrue(smallOrg.hasRole("CEO"));
    }

    @Test
    public void can_add_responsibilities() {
        fail("No implementation yet");
    }

    @Test
    public void can_add_departments() {
        fail("No implementation yet");
    }
}
