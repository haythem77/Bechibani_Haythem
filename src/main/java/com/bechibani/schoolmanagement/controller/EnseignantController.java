package com.bechibani.schoolmanagement.controller;

import com.bechibani.schoolmanagement.model.Enseignant;
import com.bechibani.schoolmanagement.model.Etudiant;
import com.bechibani.schoolmanagement.repositories.ClassRepositories;
import com.bechibani.schoolmanagement.repositories.EnseignantRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/enseignant")
public class EnseignantController {

    private final EnseignantRepositories enseignantRepositories;
    private final ClassRepositories classRepositories;

    @GetMapping("/findAll")
    public List<Enseignant> listeEnseig() {
        return this.enseignantRepositories.findAll();
    }



    @PostMapping("/add/{classId}")
    Enseignant addEnseign(@PathVariable(value = "classId") Integer classId,
                     @Validated @RequestBody Enseignant enseignant) {
        return classRepositories.findById(classId).map(classe -> {
            enseignant.setClasse(classe);
            return enseignantRepositories.save(enseignant);
        }).orElseThrow(() -> new IllegalArgumentException("id" + classId + "notfound"));
    }
}