package com.example.facebookproj.repository;

import com.example.facebookproj.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
