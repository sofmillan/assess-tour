package com.assessment.tournament.domain.spi;

import com.assessment.tournament.domain.model.Category;

public interface CategoryPersistencePort {
    Category findById(Long id);
}
