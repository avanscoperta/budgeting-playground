package it.avanscoperta.playground.budgeting.design.domain;

public class OrganizationMember {
    OrganizationMemberId id;
    String name;
    String surname;
    String email;       // TODO: maybe strict typing will come in handy here.
    String position;    // TODO: maybe strict typing will come in handy here.

    /**
     * The only way to create an OrganizationMember is through this constructor.
     * TODO: choose your favourite strategy for null check.
     * @param id the unique id for the org member
     * @param name
     * @param surname
     * @param email
     * @param position
     */
    public OrganizationMember(OrganizationMemberId id, String name, String surname, String email, String position) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.position = position;
    }
}
