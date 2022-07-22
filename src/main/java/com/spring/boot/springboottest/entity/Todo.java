package com.spring.boot.springboottest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="todo")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Column(name = "description_todo")
    private String descriptionTodo;
    private String priority;
    @Column(name = "date_todo")
    private String dateTodo;
    @Column(name = "is_deleted")
    private Integer isDeleted;

}
