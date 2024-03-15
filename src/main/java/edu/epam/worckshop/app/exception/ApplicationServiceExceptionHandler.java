package edu.epam.worckshop.app.exception;

import edu.epam.worckshop.app.mapper.ApplicationExceptionMapper;
import edu.epam.worckshop.app.model.dto.ExceptionResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ApplicationServiceExceptionHandler {

    private final ApplicationExceptionMapper mapper;

    @ExceptionHandler(NotFoundApplicationException.class)
    public ResponseEntity<ExceptionResponseDto> handleNotFoundException(NotFoundApplicationException exception) {
        log.error("Entity not found", exception);
        return ResponseEntity.status(exception.getStatus())
                .body(mapper.mapToResponse(exception));
    }
}
