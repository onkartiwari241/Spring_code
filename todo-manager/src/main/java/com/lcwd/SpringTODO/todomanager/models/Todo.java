package com.lcwd.SpringTODO.todomanager.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Todo {
    private int id;
    private String name;
    private String content;
    private String tittle;

    private Date addTodoDate;


    @JsonFormat(pattern = "dd/MM/YYYY")
    private Date toDoTodoDate;


    public Todo() {}
    public Todo(int id, String name, String content, String tittle,Date addTodoDate,Date toDoTodoDate) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.tittle = tittle;
        this.addTodoDate = addTodoDate;
        this.toDoTodoDate = toDoTodoDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Date getAddTodoDate() {
        return addTodoDate;
    }

    public void setAddTodoDate(Date addTodoDate) {
        this.addTodoDate = addTodoDate;
    }

    public Date getToDoTodoDate() {
        return toDoTodoDate;
    }

    public void setToDoTodoDate(Date toDoTodoDate) {
        this.toDoTodoDate = toDoTodoDate;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", tittle='" + tittle + '\'' +
                ", addTodoDate=" + addTodoDate +
                ", toDoTodoDate=" + toDoTodoDate +
                '}';
    }
}
