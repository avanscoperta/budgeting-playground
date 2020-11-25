package it.avanscoperta.playground.budgeting.contribution.domain;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class BudgetingCampaign {

    @AggregateIdentifier
    private BudgetingCampaignId budgetingCampaignId;

    private BudgetingCampaign() {}

    @CommandHandler
    public BudgetingCampaign(LaunchBudgetingCampaign command) {
        apply(new BudgetingCampaignLaunched(
                command.getCampaignId(),
                command.getName(),
                command.getDueDate(),
                command.getBudgetingModel()
        ));
    }

    @EventSourcingHandler
    public void on(BudgetingCampaignLaunched event) {
        this.budgetingCampaignId = event.getCampaignId();
    }
}
