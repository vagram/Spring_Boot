package com.spring.boot.springboottest.repository;

import com.spring.boot.springboottest.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    @Query(value = "select * from todo where is_deleted is null or is_deleted = 1 ", nativeQuery = true)
    List<Todo> getAllTodos();

    @Query(value = "select * from todo where id = :id", nativeQuery = true)
    Todo getTodosById(@Param("id") Integer id);
}
