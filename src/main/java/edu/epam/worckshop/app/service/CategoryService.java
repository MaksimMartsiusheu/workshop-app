package edu.epam.worckshop.app.service;

import edu.epam.worckshop.app.dao.CategoryRepository;
import edu.epam.worckshop.app.exception.NotFoundApplicationException;
import edu.epam.worckshop.app.model.entity.CategoryEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryEntity getById(Long id) {
        return categoryRepository.findById(id);
    }

    public List<CategoryEntity> getAll() {
        List<CategoryEntity> categories = categoryRepository.findAll();

        if (categories.isEmpty()) {
            throw new NotFoundApplicationException("There are no categories");
        }

        return categories;
    }

    public CategoryEntity create(CategoryEntity categoryEntity) {
        return categoryRepository.create(categoryEntity);
    }
}
