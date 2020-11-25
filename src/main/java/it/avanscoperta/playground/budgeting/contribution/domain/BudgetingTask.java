package it.avanscoperta.playground.budgeting.contribution.domain;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class BudgetingTask {

    @AggregateIdentifier
    private TaskId taskId;
    private TaskState state;

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
        this.state = TaskState.ASSIGNED;
    }

    @CommandHandler
    public void markComplete(MarkComplete command) {
        rejectIfAlreadyComplete();
        apply(new TaskMarkedComplete(
                command.getTaskId(),
                command.getAssignee(),
                command.getDate(),
                command.getNotes()
        ));
    }

    private void rejectIfAlreadyComplete() {
        if (state == TaskState.COMPLETE) throw new RuntimeException("task was already complete");
    }

    @EventSourcingHandler
    public void on (TaskMarkedComplete event) {
        this.state = TaskState.COMPLETE;
    }

}
