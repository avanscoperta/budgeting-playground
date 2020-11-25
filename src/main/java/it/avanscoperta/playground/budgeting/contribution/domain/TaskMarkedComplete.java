package it.avanscoperta.playground.budgeting.contribution.domain;

import it.avanscoperta.playground.common.OrganizationMember;

import java.time.LocalDate;

public class TaskMarkedComplete  {
    private final TaskId taskId;
    private final OrganizationMember assignee;
    private final LocalDate date;
    private final String notes;

    public TaskMarkedComplete(TaskId taskId, OrganizationMember assignee, LocalDate date, String notes) {
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
