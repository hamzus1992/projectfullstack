package com.projectfullstack.rest.webservices.restwebservices.todopackage.service;

import com.projectfullstack.rest.webservices.restwebservices.todopackage.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoHardCodeService {

    private static List<Todo> todos = new ArrayList<>();
    private static int idCounter = 0;

    static {
        todos.add(new Todo(++idCounter,"hamzus1992","Learn to Dance",new Date(),false));
        todos.add(new Todo(++idCounter,"hamzus1992","Become an Expert at Angular",new Date(),false));
        todos.add(new Todo(++idCounter,"hamzus1992","Visit Tunisia",new Date(),false));
    }

    public List<Todo> findAll(String username){
       return todos.stream().filter(todo -> todo.getUsername().equals(username)).collect(Collectors.toList());
    }

    public Todo findById(String username,long id) {
        return todos.stream().filter(todo1 -> todo1.getUsername().equals(username)&& todo1.getId() == id).findFirst().orElse(null);
    }

    public Todo delete(String username,long id) {
        Todo todo = findById(username,id);
        if(todo != null) {
            todos.remove(todo);
            return todo;
        } else {
            return null;
        }
    }
    public Todo save(Todo todo) {
        if(findById(todo.getUsername(),todo.getId())!=null) {
          todos =  todos.stream().map(todoSaving -> {
                if (todoSaving.getUsername().equals(todo.getUsername()) && todoSaving.getId() == todo.getId()) {
                    return todo;
                } else return todoSaving;
            }).collect(Collectors.toList());
          return todo;
        } else {
            todo.setId(++idCounter);
            todos.add(todo);
            return todo;
        }
    }
}
