package com.example.part2.model;

public class Task {
    private Long id;
    private String name;
    private String deadlineDate;
    private boolean completed;

    public Task() {}

    public Task(Long id, String name, String deadlineDate, boolean completed) {
        this.id = id;
        this.name = name;
        this.deadlineDate = deadlineDate;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deadlineDate='" + deadlineDate + '\'' +
                ", completed=" + completed +
                '}';
    }
}
