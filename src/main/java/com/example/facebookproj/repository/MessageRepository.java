package com.example.facebookproj.repository;

import com.example.facebookproj.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Integer> {
}
