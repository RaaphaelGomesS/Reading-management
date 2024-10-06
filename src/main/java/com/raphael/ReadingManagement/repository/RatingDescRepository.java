package com.raphael.ReadingManagement.repository;

import com.raphael.ReadingManagement.model.RatingDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingDescRepository extends JpaRepository<RatingDescription, Long> {
}
