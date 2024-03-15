package edu.epam.worckshop.app.model.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionResponseDto {

    private String message;
    private Integer statusCode;
    private LocalDateTime time;

}
