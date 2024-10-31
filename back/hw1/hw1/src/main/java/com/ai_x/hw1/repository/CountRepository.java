package com.ai_x.hw1.repository;

import com.ai_x.hw1.domain.Count;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountRepository extends JpaRepository<Count, Integer> {
}
