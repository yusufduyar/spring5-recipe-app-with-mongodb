package com.spring5.recipeapp.repositories;

import com.spring5.recipeapp.bootstrap.RecipeBootstrap;
import com.spring5.recipeapp.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataMongoTest
public class IUnitOfMeasureRepositoryIT {

    @Autowired
    IUnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    ICategoryRepository categoryRepository;

    @Autowired
    IRecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        unitOfMeasureRepository.deleteAll();
        categoryRepository.deleteAll();
        recipeRepository.deleteAll();

        RecipeBootstrap recipeBootstrap = new RecipeBootstrap(categoryRepository,recipeRepository,unitOfMeasureRepository);

        recipeBootstrap.onApplicationEvent(null);
    }

    @Test
    public void findByDescription() throws Exception {
        Optional<UnitOfMeasure> measure = unitOfMeasureRepository.findByDescription("Teaspoon");

        assertEquals("Teaspoon",measure.get().getDescription());
    }
}