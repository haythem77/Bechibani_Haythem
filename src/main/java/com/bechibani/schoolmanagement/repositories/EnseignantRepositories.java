package com.bechibani.schoolmanagement.repositories;

import com.bechibani.schoolmanagement.model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepositories extends JpaRepository<Enseignant,Integer> {
}
