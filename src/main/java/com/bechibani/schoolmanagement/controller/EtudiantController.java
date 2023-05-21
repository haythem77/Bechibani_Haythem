package com.bechibani.schoolmanagement.controller;

import com.bechibani.schoolmanagement.model.Classe;
import com.bechibani.schoolmanagement.model.Etudiant;
import com.bechibani.schoolmanagement.repositories.ClassRepositories;
import com.bechibani.schoolmanagement.repositories.EtudiantRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.EmitUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/etudiants")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class EtudiantController {
    private final EtudiantRepositories etudiantRepositories;
    private final ClassRepositories classRepositories;

    @GetMapping("/findAll")
    public List<Etudiant> listeEtud (@RequestParam Integer pageNumber,
                                     @RequestParam Integer pageSize)

    {
        Pageable page=PageRequest.of(pageNumber,pageSize);
        return  this.etudiantRepositories.findAll(page).getContent();
    }

    @PostMapping("/add/{classId}")
    Etudiant addEtud(@PathVariable (value = "classId") Integer classId,
                         @Validated @RequestBody Etudiant etudiant) {
        return classRepositories.findById(classId).map(classe -> {etudiant.setCalsse(classe);
        return etudiantRepositories.save(etudiant);}).orElseThrow(()->new IllegalArgumentException("id"+classId+"notfound"));

    }
    @GetMapping("/chercher")

    public List<Etudiant> chercher(@RequestParam (name="mc",defaultValue = "")String mc )
                                   {

        return etudiantRepositories.chercher("%"+mc+"%") ;



    }

}
