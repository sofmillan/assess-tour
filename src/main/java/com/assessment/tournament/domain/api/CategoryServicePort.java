package com.assessment.tournament.domain.api;

import com.assessment.tournament.domain.model.Category;

public interface CategoryServicePort {
    Category findById(Long id);
}
