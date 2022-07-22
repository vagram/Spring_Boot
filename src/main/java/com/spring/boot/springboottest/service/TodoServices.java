package com.spring.boot.springboottest.service;

import com.spring.boot.springboottest.entity.Todo;
import com.spring.boot.springboottest.repository.TodoRepository;

import java.util.List;

public interface TodoServices {
    List<Todo> getAllTodos();
    Todo getById(Integer id);
    void saveTodo(Todo todo);
    void deleteAllTodo();
    void deleteById(Integer id);
}
