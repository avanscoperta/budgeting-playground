package it.avanscoperta.playground.budgeting.contribution.domain;

import java.util.UUID;

public class BudgetingCampaignId {
    private final String id;

    public BudgetingCampaignId(String id) {
        this.id = id;
    }

    public static BudgetingCampaignId generate() {
        return new BudgetingCampaignId(UUID.randomUUID().toString());
    }

    public String toString() {
        return id;
    }
}
