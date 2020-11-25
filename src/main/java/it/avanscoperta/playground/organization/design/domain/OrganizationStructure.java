package it.avanscoperta.playground.organization.design.domain;

import it.avanscoperta.playground.common.OrganizationMember;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * An arbitrary implementation  of organization structure.
 *
 * Please don't focus on the internals which are clearly naive. The main point is that
 * we should ignore this complexity as much as possible even in the services using this.
 */
public class OrganizationStructure {

    private List<Role> roles;
    private List<Department> departments;
    private Set<Responsibility> responsibilities;
    private List<ResponsibilityAssignment> assignedResponsibilities;

    private OrganizationStructure() {
        roles = new ArrayList<>();
        departments = new ArrayList<>();
        responsibilities = new HashSet<>();
        assignedResponsibilities = new ArrayList<>();
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

    public void addRole(Role role) {
        roles.add(role);
    }

    public void addRoles(List<Role> roles) {
        // Brutal, not asking questions
        this.roles.addAll(roles);
    }

    public boolean hasRole(String role) {
        return roles.stream()
                .anyMatch(localRole -> role.equals(localRole.getLabel()));
    }

    /**
     * I will probably change this naming many times.
     *
     * @param role
     * @param responsibility
     * @return
     */
    public boolean roleHasResponsibility(Role role, Responsibility responsibility) {
        return assignedResponsibilities.stream()
                .anyMatch(assignment -> (
                        assignment.getResponsibility().equals(responsibility) &&
                        assignment.getRole().equals(role)));
    }

    public void placeResponsibility(Responsibility responsibility, Role role) {
        rejectOnMissingResponsibility();
        rejectOnMissingRole(role);
        assignedResponsibilities.add(new ResponsibilityAssignment(
                responsibility, role, "Forever"
        ));
    }

    private void rejectOnMissingRole(Role role) {
        if (!roles.contains(role)) {
            throw new RuntimeException("There is no such role as " + role + " in the organization");
        }
    }

    private void rejectOnMissingResponsibility() {
        // TODO:
    }


    public void addDepartment(Department department) {
        departments.add(department);
    }

    public boolean hasDepartment(Department department) {
        return departments.contains(department);
    }
}
