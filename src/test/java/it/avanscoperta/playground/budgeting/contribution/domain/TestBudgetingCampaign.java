package it.avanscoperta.playground.budgeting.contribution.domain;

import it.avanscoperta.playground.budgeting.design.domain.BudgetingModel;
import it.avanscoperta.playground.budgeting.design.domain.OrganizationStructureReader;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestBudgetingCampaign {

    FixtureConfiguration<BudgetingCampaign> fixture = new AggregateTestFixture<>(BudgetingCampaign.class);


    @Test
    public void can_launch_a_budgeting_campaign() {

        BudgetingCampaignId campaignId = BudgetingCampaignId.generate();
        String name = "Campagna budgeting 2020";
        LocalDate dueDate = LocalDate.now().plusMonths(2);
        BudgetingModelSnapshot budgetingModel = new BudgetingModelSnapshot();

        LaunchBudgetingCampaign launchBudgetingCampaign = new LaunchBudgetingCampaign(
                campaignId, name, dueDate, budgetingModel
        );
        BudgetingCampaignLaunched budgetingCampaignLaunched = new BudgetingCampaignLaunched(
                campaignId, name, dueDate, budgetingModel
        );

        fixture.givenNoPriorActivity()
                .when(launchBudgetingCampaign)
                .expectSuccessfulHandlerExecution()
                .expectEvents(budgetingCampaignLaunched);
    }
}
