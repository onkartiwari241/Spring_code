package com.lcwd.SpringTODO.todomanager.services;

import com.lcwd.SpringTODO.todomanager.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

//@Component
@Service
public class TODOService {

    Logger logger = LoggerFactory.getLogger(TODOService.class);
    List<Todo> todos = new ArrayList<>();
    public Todo createTodo(Todo todo)
    {
        todos.add(todo);
        logger.info("Todos {} "+this.todos);
        return todo;
    }

    public List<Todo> getAllTodos()
    {
        return todos;
    }

    public Todo getSingleTodo(int id)
    {
      Todo todo= todos.stream().filter(t -> id==t.getId()).findAny().get();

        logger.info("Todo {} ",todo);

        return todo;
    }

    public Todo updateTodoById(int id, Todo todo)
    {
        List<Todo> updatedTodoList = todos.stream().map( e-> {
            if(e.getId() == id)
            {
                e.setName(todo.getName());
                e.setContent(todo.getContent());
                e.setTittle(todo.getTittle());
                e.setAddTodoDate(e.getAddTodoDate());
                return e;
            }
            else
            {
                return e;
            }
        }).collect(Collectors.toList());
        todos = updatedTodoList;
        todo.setId(id);
        //todo.setAddTodoDate(date);
        return todo;
    }

    public void deleteTodoById(int id)
    {
        List<Todo> removedList=todos.stream().filter(e->e.getId() != id).collect(Collectors.toList());
        todos = removedList;
    }
}
