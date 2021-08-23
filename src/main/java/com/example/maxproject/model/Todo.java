package com.example.maxproject.model;

import com.example.maxproject.entity.TodoEntity;

public class Todo {
    private Long id;
    private String title;
    private Boolean completed;

    public static Todo toModel(TodoEntity todoEntity){
        Todo model = new Todo();
        model.setId(todoEntity.getId());
        model.setCompleted(todoEntity.getCompleted());
        model.setTitle(todoEntity.getTitle());
        return model;
    }

    public Todo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
