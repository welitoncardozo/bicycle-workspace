package com.welitoncardozo.bicycleallocation.exceptions.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@JsonInclude(NON_NULL)
public class MessageExceptionHandler {
    private int statusCode;
    private LocalDateTime occurrenceDate;
    private String title;
    private List<FieldExceptionHandler> fields;
}
