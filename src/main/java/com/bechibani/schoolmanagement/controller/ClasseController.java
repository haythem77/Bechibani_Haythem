package com.bechibani.schoolmanagement.controller;

import com.bechibani.schoolmanagement.model.Classe;
import com.bechibani.schoolmanagement.repositories.ClassRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/classe")
public class ClasseController {

    private final ClassRepositories classRepositories;
    @GetMapping("/findAll")
    public List<Classe> fetchAll(){
        return  this.classRepositories.findAll();
    }

    @PostMapping("/add")

    public ResponseEntity<Classe> ajoutClass(@RequestBody Classe classe){
        Classe classe1=classRepositories.save(classe);
        return new ResponseEntity<Classe>(classe1, HttpStatus.CREATED);
    }


}
