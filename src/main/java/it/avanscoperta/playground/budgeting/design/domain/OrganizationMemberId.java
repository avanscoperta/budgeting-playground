package it.avanscoperta.playground.budgeting.design.domain;

import java.util.UUID;

public class OrganizationMemberId {
    private String id;

    public OrganizationMemberId(String id) {
        this.id = id;
    }

    public static OrganizationMemberId generate() {
        return new OrganizationMemberId(UUID.randomUUID().toString());
    }
}
