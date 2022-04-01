package com.IMetA.IMetAwebservice.domain.repository;

import com.IMetA.IMetAwebservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
