package com.mtab.mytodolist;

public class Todo {
    private int id;
    private String title;
    private String description;
    private boolean isCompleted;
    private String date;

    public Todo() {
    }

    public Todo(String title, String description, String date) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.isCompleted = false;
    }

    public Todo(int id, String title, String description, boolean isCompleted, String date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
} 