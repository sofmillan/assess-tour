package com.assessment.tournament.infrastructure.configuration;

import com.assessment.tournament.domain.api.CategoryServicePort;
import com.assessment.tournament.domain.api.IdentityResolver;
import com.assessment.tournament.domain.api.TournamentServicePort;
import com.assessment.tournament.domain.spi.CategoryPersistencePort;
import com.assessment.tournament.domain.spi.TournamentPersistencePort;
import com.assessment.tournament.domain.usecase.CategoryUseCase;
import com.assessment.tournament.domain.usecase.TournamentUseCase;
import com.assessment.tournament.infrastructure.output.jpa.adapter.CategoryJpaAdapter;
import com.assessment.tournament.infrastructure.output.jpa.adapter.TournamentJpaAdapter;
import com.assessment.tournament.infrastructure.output.jpa.mapper.CategoryEntityMapper;
import com.assessment.tournament.infrastructure.output.jpa.mapper.TournamentEntityMapper;
import com.assessment.tournament.infrastructure.output.jpa.repository.CategoryRepository;
import com.assessment.tournament.infrastructure.output.jpa.repository.TournamentRepository;
import com.assessment.tournament.infrastructure.security.JwtClaimsResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;
    private final TournamentRepository tournamentRepository;
    private final TournamentEntityMapper tournamentEntityMapper;

    @Bean
    public CategoryPersistencePort categoryPersistencePort(){
        return new CategoryJpaAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public CategoryServicePort categoryServicePort(){
        return new CategoryUseCase(categoryPersistencePort());
    }

    @Bean
    public TournamentPersistencePort tournamentPersistencePort(){
        return new TournamentJpaAdapter(tournamentRepository, tournamentEntityMapper);
    }

    @Bean
    public TournamentServicePort tournamentServicePort(){
        return new TournamentUseCase(tournamentPersistencePort());
    }

    @Bean
    public IdentityResolver identityResolver(){
        return new JwtClaimsResolver();
    }
}
