package com.spring.boot.springboottest;

import com.spring.boot.springboottest.entity.Todo;
import com.spring.boot.springboottest.service.TodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoServices todoServices;

    @GetMapping("")
    public List<Todo> getAll(){
        return todoServices.getAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getById(@PathVariable Integer id){
        return todoServices.getById(id);
    }

    @PostMapping("/")
    public Todo saveTodo(@RequestBody Todo todo){
            todoServices.saveTodo(todo);
            return todo;
    }

    @PutMapping("/")
    public Todo updateTodo(@RequestBody Todo todo){
        todoServices.saveTodo(todo);
        return todo;
    }

    @DeleteMapping("/")
    public String deleteAll(){
        todoServices.deleteAllTodo();
        return "All todos has been Deleted!";
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        todoServices.deleteById(id);
    }
}
