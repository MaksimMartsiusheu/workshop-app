package edu.epam.worckshop.app.dao.impl;

import edu.epam.worckshop.app.dao.mapper.CategoryEntityRowMapper;
import edu.epam.worckshop.app.dao.CategoryRepository;
import edu.epam.worckshop.app.exception.NotFoundApplicationException;
import edu.epam.worckshop.app.model.entity.CategoryEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CategoryRepositoryJdbcImpl implements CategoryRepository {

    @Value("${sql.category.find-by-id}")
    private String findByIdSql;

    @Value("${sql.category.find-all}")
    private String findAllSql;

    @Value("${sql.category.insert}")
    private String insertSql;

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final CategoryEntityRowMapper rowMapper;

    @Override
    public CategoryEntity findById(Long id) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
                .addValue("categoryId", id);
        try {
            return jdbcTemplate.queryForObject(findByIdSql, mapSqlParameterSource, rowMapper);
        } catch (EmptyResultDataAccessException exception) {
            throw new NotFoundApplicationException("Category with id not found: " + id, exception);
        }
    }

    @Override
    public List<CategoryEntity> findAll() {
        return jdbcTemplate.query(findAllSql, rowMapper);
    }

    @Override
    public CategoryEntity create(CategoryEntity categoryEntity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("name", categoryEntity.getName())
                .addValue("parentId", categoryEntity.getParentId());

        jdbcTemplate.update(insertSql, parameterSource, keyHolder);

        categoryEntity.setId(keyHolder.getKeyAs(Long.class));

        return categoryEntity;
    }
}
