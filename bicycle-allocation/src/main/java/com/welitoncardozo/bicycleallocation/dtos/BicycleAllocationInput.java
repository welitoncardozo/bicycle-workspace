package com.welitoncardozo.bicycleallocation.dtos;

import com.welitoncardozo.bicycleallocation.enums.AllocationStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class BicycleAllocationInput {
    @NotNull @Valid private Bicycle bicycle;
    @NotNull @Valid private Client client;
    @NotNull private AllocationStatus status;

    @Getter
    public static class Bicycle {
        @NotNull private Long id;
        @NotBlank private String name;
    }

    @Getter
    public static class Client {
        @NotNull private Long id;
        @NotBlank private String name;
    }
}
