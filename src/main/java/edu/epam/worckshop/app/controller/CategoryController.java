package edu.epam.worckshop.app.controller;

import edu.epam.worckshop.app.model.entity.CategoryEntity;
import edu.epam.worckshop.app.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryEntity> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public CategoryEntity getById(@PathVariable("id") Long id) {
        return categoryService.getById(id);
    }

    @PostMapping
    public CategoryEntity create(@RequestBody CategoryEntity category) {
        return categoryService.create(category);
    }
}
