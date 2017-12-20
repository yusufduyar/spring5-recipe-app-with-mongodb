package com.spring5.recipeapp.repositories;

import com.spring5.recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ICategoryRepository extends CrudRepository<Category, String> {
    Optional<Category> findByDescription(String description);
}
