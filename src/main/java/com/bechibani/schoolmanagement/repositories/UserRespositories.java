package com.bechibani.schoolmanagement.repositories;

import com.bechibani.schoolmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRespositories extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
