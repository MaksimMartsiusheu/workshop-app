package edu.epam.worckshop.app.dao.mapper;

import edu.epam.worckshop.app.model.entity.CategoryEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Component
public class CategoryEntityRowMapper implements RowMapper<CategoryEntity> {
    @Override
    public CategoryEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return CategoryEntity.builder()
                .id(rs.getLong("ID"))
                .name(rs.getNString("NAME"))
                .parentId(parseLongOrNull(rs.getNString("PARENT_ID")))
                .build();
    }

    private Long parseLongOrNull(String number) {
        return Optional.ofNullable(number)
                .map(Long::parseLong)
                .orElse(null);
    }
}
