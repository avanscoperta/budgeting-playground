package it.avanscoperta.playground.organization.design.domain;

// FIXME: this dependency should go away somehow.
import it.avanscoperta.playground.common.MemberBuilder;
import it.avanscoperta.playground.common.OrganizationMember;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    public void can_add_a_single_role() {

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
    @DisplayName("Can add roles in bulk mode")
    public void can_add_many_roles_at_once() {

        // TODO: this calls for something better and moving
        OrganizationMember member = new MemberBuilder().build();
        List<OrganizationMember> members = new ArrayList<OrganizationMember>();
        members.add(member);

        OrganizationStructure smallOrg =
                OrganizationStructure.createSimple(orgName, members);


        List<Role> roles = new ArrayList<>();
        Role ceo = new Role("CEO");
        Role slave = new Role("Slave");
        roles.add(ceo);
        roles.add(slave);

        smallOrg.addRoles(roles);

        assertTrue(smallOrg.hasRole("CEO"));
        assertTrue(smallOrg.hasRole("Slave"));
    }


    @Test
    @DisplayName("Can add responsibilities to existing roles")
    public void can_add_responsibilities_to_roles() {

        Role role = new Role("CEO");
        OrganizationStructure org = new OrganizationStructureBuilder()
                .withRole(role)
                .build();
        assertTrue(org.hasRole("CEO"));

        Responsibility responsibility = new Responsibility("Budgeting");
        org.placeResponsibility(responsibility, role);

        assertTrue(org.roleHasResponsibility(role, responsibility));
    }

    @Test
    @DisplayName("Should not add responsibilities to missing roles")
    public void cannot_add_responsibilities_to_missing_roles() {

        Role role = new Role("CEO");
        OrganizationStructure headless = new OrganizationStructureBuilder()
                .build();

        Responsibility responsibility = new Responsibility("Budgeting");
        assertThrows(RuntimeException.class, () -> {
            headless.placeResponsibility(responsibility, role);
        });
    }


    @Test
    public void can_add_departments() {

        Department department = new Department("Stealth Ops");

        OrganizationStructure org = new OrganizationStructureBuilder()
                .withRole(new Role("CEO"))
                .build();

        org.addDepartment(department);

        assertTrue(org.hasDepartment(department));
    }

    @Test
    public void well_formed_organization() {
        OrganizationStructure org = new OrganizationStructureBuilder()
                .withRole(new Role("CEO"))
                .build();


        OrganizationSpecification wellFormedOrganization = new WellFormedOrganizationCriteria();
        assertFalse(wellFormedOrganization.isSatisfiedBy(org));
    }


}
