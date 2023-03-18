package com.welitoncardozo.bicycleallocation.exceptions.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FieldExceptionHandler {
    private String name;
    private String message;
}
