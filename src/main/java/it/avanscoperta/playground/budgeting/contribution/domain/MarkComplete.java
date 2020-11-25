package it.avanscoperta.playground.budgeting.contribution.domain;

import it.avanscoperta.playground.common.OrganizationMember;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDate;

public class MarkComplete {

    @TargetAggregateIdentifier
    private final TaskId taskId;
    private final OrganizationMember assignee;
    private final LocalDate date;
    private final String notes;

    public MarkComplete(TaskId taskId, OrganizationMember assignee, LocalDate date, String notes) {
        this.taskId = taskId;
        this.assignee = assignee;
        this.date = date;
        this.notes = notes;
    }

    public TaskId getTaskId() {
        return taskId;
    }

    public OrganizationMember getAssignee() {
        return assignee;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getNotes() {
        return notes;
    }
}
