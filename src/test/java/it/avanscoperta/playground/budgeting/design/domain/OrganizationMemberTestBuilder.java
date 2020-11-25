package it.avanscoperta.playground.budgeting.design.domain;

import it.avanscoperta.playground.common.OrganizationMember;
import it.avanscoperta.playground.common.OrganizationMemberId;

/**
 * A Simple Test Data Builder for an organization member.
 */
public class OrganizationMemberTestBuilder {
    private OrganizationMemberId id = OrganizationMemberId.generate();
    private String name = "John";
    private String surname = "Smith";
    private String email = "John.smith@company.org";
    private String position = "Employee";
    // FIXME: still some unresolved ambiguity between position, role and job title here...

    public OrganizationMember build() {
        return new OrganizationMember(id, name, surname, email, position);
    }
}
