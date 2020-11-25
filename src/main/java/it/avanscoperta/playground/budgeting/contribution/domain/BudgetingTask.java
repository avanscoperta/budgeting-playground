package it.avanscoperta.playground.budgeting.contribution.domain;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class BudgetingTask {

    @AggregateIdentifier
    private TaskId taskId;

    private BudgetingTask() {}

    @CommandHandler
    public BudgetingTask(AssignTask command) {
        apply(new TaskAssigned(
                command.getTaskId(),
                command.getTaskType(),
                command.getAssignee(),
                command.getDueDate(),
                command.getForm()
        ));
    }

    @EventSourcingHandler
    public void on(TaskAssigned event) {
        this.taskId = event.getTaskId();
    }

}
