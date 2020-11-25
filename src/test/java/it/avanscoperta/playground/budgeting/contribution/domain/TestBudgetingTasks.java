package it.avanscoperta.playground.budgeting.contribution.domain;

import it.avanscoperta.playground.budgeting.design.domain.OrganizationMemberTestBuilder;
import it.avanscoperta.playground.budgeting.design.domain.TaskTypes;
import it.avanscoperta.playground.common.MemberBuilder;
import it.avanscoperta.playground.common.OrganizationMember;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestBudgetingTasks {


    FixtureConfiguration<BudgetingTask> fixture = new AggregateTestFixture<>(BudgetingTask.class);
    private TaskId taskId;
    private TaskTypes taskType;
    private OrganizationMember assignee;
    private LocalDate dueDate;
    private SubmissionForm form;
    private AssignTask assignTask;
    private TaskAssigned taskAssigned;


    @BeforeEach
    void setUp() {
        taskId = TaskId.generate();
        taskType = TaskTypes.BUDGETING;
        assignee = new OrganizationMemberTestBuilder().build();
        dueDate = LocalDate.now().plusMonths(1);
        form = SubmissionForm.budgetingForm();
    }

    @Test
    public void a_task_is_born_assigned() {

        assignTask = new AssignTask(taskId, taskType, assignee, dueDate, form);
        taskAssigned = new TaskAssigned(taskId, taskType, assignee, dueDate, form);

        fixture.givenNoPriorActivity()
                .when(assignTask)
                .expectEvents(taskAssigned);
    }

    @Test
    public void a_task_can_be_marked_complete() {

        taskAssigned = new TaskAssigned(taskId, taskType, assignee, dueDate, form);
        LocalDate date = LocalDate.now();
        String notes = "test";

        MarkComplete markComplete = new MarkComplete(taskId, assignee, date, notes);
        TaskMarkedComplete taskMarkedComplete = new TaskMarkedComplete(taskId, assignee, date, notes);
        fixture.given(taskAssigned)
                .when(markComplete)
                .expectEvents(taskMarkedComplete);
    }



    @Test
    public void a_task_cannot_be_marked_complete_twice() {

        taskAssigned = new TaskAssigned(taskId, taskType, assignee, dueDate, form);
        LocalDate date = LocalDate.now();
        String notes = "test";

        MarkComplete markComplete = new MarkComplete(taskId, assignee, date, notes);
        TaskMarkedComplete taskMarkedComplete = new TaskMarkedComplete(taskId, assignee, date, notes);
        fixture.given(taskAssigned, taskMarkedComplete)
                .when(markComplete)
                .expectExceptionMessage("task was already complete")
                .expectException(RuntimeException.class); // Lazy.
    }



}
