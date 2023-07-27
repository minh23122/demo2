package com.example.facebookproj.repository;

import com.example.facebookproj.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
