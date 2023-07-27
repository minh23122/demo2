package com.example.facebookproj.repository;

import com.example.facebookproj.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Integer> {
}
