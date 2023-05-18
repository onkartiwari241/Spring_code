package com.lcwd.SpringTODO.todomanager.controllers;

import com.lcwd.SpringTODO.todomanager.models.Todo;
import com.lcwd.SpringTODO.todomanager.services.TODOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/todos")
public class TodoController {

    Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TODOService todoService;

    Random random = new Random();
    //create
    @PostMapping("/create")
    public ResponseEntity<Todo> createTodoHandler(@RequestBody Todo todo)
    {
        int id = random.nextInt(9999999);
        todo.setId(id);

        logger.info("Todo created....");

        Date currentDate = new Date();
        logger.info("Current Date {} ",currentDate);
        todo.setAddTodoDate(currentDate);

       Todo todo1 = todoService.createTodo(todo);
        return new ResponseEntity<>(todo1, HttpStatus.CREATED);
    }

    //getAll todos
    @GetMapping("/alltodos")
    public ResponseEntity<List<Todo>> getAllTodoHandler()
    {
       List<Todo> allTodos= todoService.getAllTodos();
       return new ResponseEntity<>(allTodos,HttpStatus.OK);
    }

    //get single Todo

    @GetMapping("/singletodo/{id}")
    public ResponseEntity<Todo> getSingleTodoHandler(@PathVariable("id") int id)
    {
        Todo singleObject= todoService.getSingleTodo(id);

        return ResponseEntity.ok(singleObject);
    }

    @PutMapping("/updatetodo/{id}")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo newUpdatedTodo,@PathVariable("id") int id)
    {
       Todo updateTodo =todoService.updateTodoById(id,newUpdatedTodo);
       return ResponseEntity.ok(updateTodo);
    }

    @DeleteMapping("/deletetodo/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable int id)
    {
        todoService.deleteTodoById(id);
        return ResponseEntity.ok(id+" removed successfully...");
    }
}
