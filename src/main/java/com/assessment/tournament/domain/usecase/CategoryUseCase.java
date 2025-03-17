package com.assessment.tournament.domain.usecase;

import com.assessment.tournament.domain.api.CategoryServicePort;
import com.assessment.tournament.domain.model.Category;
import com.assessment.tournament.domain.spi.CategoryPersistencePort;

public class CategoryUseCase implements CategoryServicePort {
    private final CategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public Category findById(Long id) {
        return categoryPersistencePort.findById(id);
    }
}
