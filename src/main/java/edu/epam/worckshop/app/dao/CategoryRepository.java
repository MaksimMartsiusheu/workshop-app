package edu.epam.worckshop.app.dao;

import edu.epam.worckshop.app.model.entity.CategoryEntity;

import java.util.List;

public interface CategoryRepository {

    CategoryEntity findById (Long id);
    List<CategoryEntity> findAll();

    CategoryEntity create(CategoryEntity categoryEntity);

}
