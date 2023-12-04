package com.woodpecker.backend.controller;

import com.woodpecker.backend.dtos.UserRequest;
import com.woodpecker.backend.dtos.UserResponse;
import com.woodpecker.backend.model.FlashCard;
import com.woodpecker.backend.model.User;
import com.woodpecker.backend.service.Exception.ObjectNotFoundException;
import com.woodpecker.backend.service.FlashcardService;
import com.woodpecker.backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<UserResponse>> findAll(){

        List<User> list =service.findAll();
        List<UserResponse> listDto = list.stream().map(x -> new UserResponse(x)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody UserRequest request, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return handleErrors(bindingResult);
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{uid}")
    public ResponseEntity<UserResponse> findUser(@PathVariable String uid){
        return ResponseEntity.ok(service.findByUid(uid));
    }

    @GetMapping("/login/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email){
        UserResponse response = service.findByEmail(email);
        if(response == null){
            Map<String, Object> responseError = new HashMap<>();
            responseError.put("timestamp", new Date());
            responseError.put("status", HttpStatus.NOT_FOUND.value());
            responseError.put("error:", "Usuário não encontrado.");
            responseError.put("path", "/user/login");
            return  new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{uid}")
    public ResponseEntity<?> update(@PathVariable String uid,@Valid @RequestBody UserRequest request, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return handleErrors(bindingResult);
        return ResponseEntity.ok(service.update(uid,request));
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<?> delete(@PathVariable String uid){
        boolean success = service.delete(uid);
        if(success){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    private ResponseEntity<?> handleErrors(BindingResult bindingResult){

        List<String> validationErrors = bindingResult.getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.toList());
        //criando resposta de erro personalizada
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", new Date());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("errors", validationErrors);
        response.put("path", "/user");

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

    @RequestMapping(value="/{id}/flashcard", method=RequestMethod.GET)
    public ResponseEntity<List<FlashCard>> findFlashCard(@PathVariable String id){

        User obj = service.findById(id);

        return ResponseEntity.ok().body(obj.getFlashCard());
    }

}
