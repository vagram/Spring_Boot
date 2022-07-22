package com.spring.boot.springboottest.service;

import com.spring.boot.springboottest.entity.Todo;
import com.spring.boot.springboottest.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TodoServiceIml implements TodoServices{
    @Autowired
    TodoRepository todoRepository;

    @Override
    @Transactional
    public List<Todo> getAllTodos() {
        log.info("getAllTodos start");
        List<Todo> todoList = todoRepository.getAllTodos();
        if (todoList.isEmpty()){
            log.warn("Todos is empty");
        }
        log.info("Find" + todoList.size() + "todos");
        return todoList;
    }

    @Override
    @Transactional
    public Todo getById(Integer id) {
        Todo todoOptional = todoRepository.getTodosById(id);
        return todoOptional;

    }

    @Override
    @Transactional
    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    @Transactional
    public void deleteAllTodo() {
        List<Todo> all = todoRepository.findAll();
        all.forEach(todo -> todo.setIsDeleted(1));
        todoRepository.saveAll(all);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isEmpty()){
            log.warn("Todo with id: " + id + " not Found!" );
            return;
        }
        Todo todo = todoOptional.get();
        todo.setIsDeleted(null);
        todoRepository.save(todo);
        log.info("Todo with id: " + id + " has been Deleted!");
    }
}
