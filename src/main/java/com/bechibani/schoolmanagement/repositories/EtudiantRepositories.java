package com.bechibani.schoolmanagement.repositories;

import com.bechibani.schoolmanagement.model.Etudiant;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EtudiantRepositories extends JpaRepository<Etudiant,Integer> {

    @Query("select c from Etudiant c  where c.calsse.nom like :x")
    public List<Etudiant> chercher(@Param("x") String mc);

}
