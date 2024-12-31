package com.nautiDevelopers.Controller;

import com.nautiDevelopers.DTO.TodoDTO;
import lombok.AllArgsConstructor;
import com.nautiDevelopers.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("api/todos") //Base URL
public class TodoController {

    @Autowired
    private TodoService todoService;

    // Build Add "TodoApplication" REST API

    //http://localhost:8080/api/todos/addTodo
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addTodo")
    public ResponseEntity<TodoDTO> addTodo(@RequestBody TodoDTO todoDto){
        TodoDTO savedTodo = todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    // Build Get All Todos REST API
    //http://localhost:8080/api/todos/allTodos
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/allTodos")
    public ResponseEntity<List<TodoDTO>> getAllTodos(){
        List<TodoDTO> todos = todoService.getAllTodos();
        //return new ResponseEntity<>(todos, HttpStatus.OK);
        return ResponseEntity.ok(todos);
    }

    //http://localhost:8080/api/todos/2
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("{id}")
    public ResponseEntity<TodoDTO> getTodo(@PathVariable("id") Long todoId){
        TodoDTO todoDto = todoService.getTodo(todoId);
        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

    // Build Update todos REST API
    //http://localhost:8080/api/todos/1
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    public ResponseEntity<TodoDTO> updateTodo(@RequestBody TodoDTO todoDto, @PathVariable("id") Long todoId){
        TodoDTO updatedTodo = todoService.updateTodo(todoDto, todoId);
        return ResponseEntity.ok(updatedTodo);
    }

    // Build Delete todos REST API
    //http://localhost:8080/api/todos/1
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId){
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("Todo deleted successfully!.");
    }

    // Build Complete todos REST API
    //http://localhost:8080/api/todos/1/complete
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PatchMapping("{id}/complete") //partial update
    public ResponseEntity<TodoDTO> completeTodo(@PathVariable("id") Long todoId){
        TodoDTO updatedTodo = todoService.completeTodo(todoId);
        return ResponseEntity.ok(updatedTodo);
    }

    // Build in-complete todos REST API
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    //http://localhost:8080/api/todos/1/in-complete
    @PatchMapping("{id}/in-complete") //partial update
    public ResponseEntity<TodoDTO> inCompleteTodo(@PathVariable("id") Long todoId){
        TodoDTO updatedTodo = todoService.inCompleteTodo(todoId);
        return ResponseEntity.ok(updatedTodo);
    }
}
