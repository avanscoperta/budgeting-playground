package it.avanscoperta.playground.budgeting.contribution.domain;

import it.avanscoperta.playground.budgeting.design.domain.TaskTypes;
import it.avanscoperta.playground.common.OrganizationMember;

import java.time.LocalDate;

public class TaskAssigned {
    private final TaskId taskId;
    private final TaskTypes taskType;
    private final OrganizationMember assignee;
    private final LocalDate dueDate;
    private final SubmissionForm form;

    public TaskAssigned(TaskId taskId, TaskTypes taskType, OrganizationMember assignee, LocalDate dueDate, SubmissionForm form) {

        this.taskId = taskId;
        this.taskType = taskType;
        this.assignee = assignee;
        this.dueDate = dueDate;
        this.form = form;
    }

    public TaskId getTaskId() {
        return taskId;
    }

    public TaskTypes getTaskType() {
        return taskType;
    }

    public OrganizationMember getAssignee() {
        return assignee;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public SubmissionForm getForm() {
        return form;
    }
}
