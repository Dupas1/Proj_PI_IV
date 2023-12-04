package com.woodpecker.backend.controller;

import com.woodpecker.backend.dtos.CategoryRequest;
import com.woodpecker.backend.dtos.CategoryResponse;
import com.woodpecker.backend.service.CategoryService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService service;

    @PostMapping("/{uid}")
    public ResponseEntity<?> create(@PathVariable String uid, @Valid @RequestBody CategoryRequest request, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return handleErrors(bindingResult);
        return ResponseEntity.ok(service.create(uid,request));
    }

    @GetMapping("/{uid}")
    public ResponseEntity<List<CategoryResponse>> findByAllUid(@PathVariable String uid){
        return ResponseEntity.ok(service.findAllByUid(uid));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @Valid @RequestBody CategoryRequest request, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return handleErrors(bindingResult);
        return ResponseEntity.ok(service.update(id,request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        boolean success = service.delete(id);
        if(success) return ResponseEntity.ok().build();
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
        response.put("path", "/category");

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }
}
