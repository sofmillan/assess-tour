package com.assessment.tournament.infrastructure.output.jpa.adapter;

import com.assessment.tournament.domain.model.Category;
import com.assessment.tournament.domain.spi.CategoryPersistencePort;
import com.assessment.tournament.infrastructure.output.jpa.mapper.CategoryEntityMapper;
import com.assessment.tournament.infrastructure.output.jpa.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements CategoryPersistencePort {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;
    @Override
    public Category findById(Long id) {
        return categoryEntityMapper.toModel(categoryRepository.findById(id).orElseThrow(RuntimeException::new));
    }
}
