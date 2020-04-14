package com.projectfullstack.rest.webservices.restwebservices.todopackage.rest;

import com.projectfullstack.rest.webservices.restwebservices.todopackage.entity.Todo;
import com.projectfullstack.rest.webservices.restwebservices.todopackage.service.TodoHardCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoRestController {

    @Autowired
    private TodoHardCodeService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
        return todoService.findAll(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodos(@PathVariable String username, @PathVariable long id) {
        return todoService.findById(username, id);

    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String username, @PathVariable long id) {
        Todo todo = todoService.delete(username, id);
        if(todo != null)
        return  ResponseEntity.noContent().build();
        else return ResponseEntity.notFound().build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo( @RequestBody Todo todo) {
        Todo todoSave = todoService.save(todo);
        return new ResponseEntity<>(todoSave,HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos/")
    public ResponseEntity<Void> save( @RequestBody Todo todo) {
        Todo createdTodo = todoService.save(todo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
