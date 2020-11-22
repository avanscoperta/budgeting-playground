package it.avanscoperta.playground.budgeting.design.domain;

// Depending on Common is fine.
import it.avanscoperta.playground.common.OrganizationMember;
import it.avanscoperta.playground.common.OrganizationMemberId;

/**
 * A very simple test data builder.
 * Maybe I'll need something more sophisticated later on.
 */
public class MemberBuilder {

    private OrganizationMemberId id = OrganizationMemberId.generate();
    private String name = "Mario";
    private String surname = "Rossi";
    private String email = "Mario.rossi@gmail.zot";
    private String position = "Impiegato";

    /**
     * Returns a plausible valid OrganizationMember instance, for testing purposes.
     * @return
     */
    public OrganizationMember build() {
        return new OrganizationMember(id, name, surname, email, position);
    }
}
