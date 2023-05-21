package com.bechibani.schoolmanagement.repositories;

import com.bechibani.schoolmanagement.model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepositories extends JpaRepository<Classe,Integer> {
}
