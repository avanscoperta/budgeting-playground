package it.avanscoperta.playground.organization.design.domain;

import it.avanscoperta.playground.common.OrganizationMember;

import java.util.ArrayList;
import java.util.List;

/**
 * A Test Data Builder for Organization Structure
 */
public class OrganizationStructureBuilder {
    private String orgName = "Test Org Ltd";
    private List<Department> departments = new ArrayList<Department>();
    private List<Role> roles = new ArrayList<Role>();
    private List<OrganizationMember> members = new ArrayList<OrganizationMember>();

    /**
     * First Shortcut, just with a label. Useful if we need to hide the
     * implementation details.
     *
     * @param roleLabel
     * @return
     */
    public OrganizationStructureBuilder withRole(String roleLabel) {
        roles.add(new Role(roleLabel));
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
    public OrganizationStructureBuilder withRole(Role role) {
        roles.add(role);
        return this;
    }

    public OrganizationStructureBuilder withDepartment(Department department) {
        departments.add(department);
        return this;
    }

    public OrganizationStructure build() {
        OrganizationStructure structure;
        structure = OrganizationStructure.createSimple(orgName, members);
        structure.addRoles(roles);
        return structure;
    }
}
