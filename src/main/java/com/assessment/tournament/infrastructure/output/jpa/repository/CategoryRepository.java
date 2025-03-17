package com.assessment.tournament.infrastructure.output.jpa.repository;

import com.assessment.tournament.infrastructure.output.jpa.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
