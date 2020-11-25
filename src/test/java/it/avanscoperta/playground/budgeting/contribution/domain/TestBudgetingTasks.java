package it.avanscoperta.playground.budgeting.contribution.domain;

import it.avanscoperta.playground.budgeting.design.domain.OrganizationMemberTestBuilder;
import it.avanscoperta.playground.budgeting.design.domain.TaskTypes;
import it.avanscoperta.playground.common.MemberBuilder;
import it.avanscoperta.playground.common.OrganizationMember;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestBudgetingTasks {


    FixtureConfiguration<BudgetingTask> fixture = new AggregateTestFixture<>(BudgetingTask.class);


    @Test
    public void a_task_is_born_assigned() {
        TaskId taskId = TaskId.generate();
        TaskTypes taskType = TaskTypes.BUDGETING;
        OrganizationMember assignee = new OrganizationMemberTestBuilder().build();
        LocalDate dueDate = LocalDate.now().plusMonths(1);
        SubmissionForm form = SubmissionForm.budgetingForm();

        AssignTask assignTask = new AssignTask(taskId, taskType, assignee, dueDate, form);
        TaskAssigned taskAssigned = new TaskAssigned(taskId, taskType, assignee, dueDate, form);

        fixture.givenNoPriorActivity()
                .when(assignTask)
                .expectEvents(taskAssigned);

    }



}
