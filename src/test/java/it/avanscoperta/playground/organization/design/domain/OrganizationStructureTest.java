package it.avanscoperta.playground.organization.design.domain;

// FIXME: this dependency should go away somehow.
import it.avanscoperta.playground.budgeting.design.domain.*;
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

        smallOrg.addRole(new OrganizationRole("CEO"));

        assertTrue(smallOrg.hasRole("CEO"));
    }

    @Test
    public void can_add_responsibilities_to_roles() {

        OrganizationRole role = new OrganizationRole("CEO");
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

    /**
     * A Test Data Builder for Organization Structure
     */
    public static class OrganizationStructureBuilder {
        private String orgName = "Test Org Ltd";
        private List<OrganizationRole> roles = new ArrayList<OrganizationRole>();
        private List<OrganizationMember> members = new ArrayList<OrganizationMember>();

        /**
         * First Shortcut, just with a label. Useful if we need to hide the
         * implementation details.
         *
         * @param roleLabel
         * @return
         */
        public OrganizationStructureBuilder withRole(String roleLabel) {
            roles.add(new OrganizationRole(roleLabel));
            return this;
        }

        /**
         * Adds a role to our test organization. More type strict. Useful if callers are aware
         * of the implementation details.
         * Easier to develop while the Org Structure is still evolving: less duplication.
         *
         * @param role
         * @return an OrganizationStructureBuilder with the given roles added to the roles list.
         */
        public OrganizationStructureBuilder withRole(OrganizationRole role) {
            roles.add(role);
            return this;
        }

        public OrganizationStructure build() {
            OrganizationStructure structure;
            structure = OrganizationStructure.createSimple(orgName, members);
            structure.addRoles(roles);
            return structure;
        }
    }
}
