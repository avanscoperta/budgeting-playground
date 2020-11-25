package it.avanscoperta.playground.budgeting.contribution.domain;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDate;

public class LaunchBudgetingCampaign {

    @TargetAggregateIdentifier
    private final BudgetingCampaignId campaignId;
    private final String name;
    private final LocalDate dueDate;
    private final BudgetingModelSnapshot budgetingModel;

    public LaunchBudgetingCampaign(BudgetingCampaignId campaignId, String name, LocalDate dueDate, BudgetingModelSnapshot budgetingModel) {
        this.campaignId = campaignId;
        this.name = name;
        this.dueDate = dueDate;
        this.budgetingModel = budgetingModel;
    }

    public BudgetingCampaignId getCampaignId() {
        return campaignId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public BudgetingModelSnapshot getBudgetingModel() {
        return budgetingModel;
    }
}
