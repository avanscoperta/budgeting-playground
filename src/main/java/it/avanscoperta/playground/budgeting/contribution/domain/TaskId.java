package it.avanscoperta.playground.budgeting.contribution.domain;

import java.util.UUID;

public class TaskId {
    private final String id;

    public TaskId(String id) {
        this.id = id;
    }

    public static TaskId generate() {
        return new TaskId(UUID.randomUUID().toString());
    }

    public String toString() {
        return this.id;
    }
}
