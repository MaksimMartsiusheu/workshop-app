package edu.epam.worckshop.app.mapper;

import edu.epam.worckshop.app.exception.ApplicationServiceException;
import edu.epam.worckshop.app.model.dto.ExceptionResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", imports = LocalDateTime.class)
public interface ApplicationExceptionMapper {

    @Mapping(target = "statusCode", source = "status")
    @Mapping(target = "time", expression = "java(LocalDateTime.now())")
    ExceptionResponseDto mapToResponse(ApplicationServiceException e);

    default int mapStatusToInt(HttpStatus status) {
        return status.value();
    }
}
