package it.avanscoperta.playground.organization.design.domain;

// FIXME: this dependency should go away somehow.
import it.avanscoperta.playground.common.MemberBuilder;
import it.avanscoperta.playground.common.OrganizationMember;
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

        smallOrg.addRole(new Role("CEO"));

        assertTrue(smallOrg.hasRole("CEO"));
    }

    @Test
    public void can_add_responsibilities_to_roles() {

        Role role = new Role("CEO");
        OrganizationStructure org = new OrganizationStructureBuilder()
                .withRole(role)
                .build();

        Responsibility responsibility = new Responsibility("Budgeting");
        org.placeResponsibility(responsibility, role);

        assertTrue(org.roleHasResponsibility(role, responsibility));
    }

    @Test
    public void can_add_departments() {
        fail("No implementation yet");
    }

}
