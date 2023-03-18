package com.welitoncardozo.bicycleallocation.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.welitoncardozo.bicycleallocation.enums.AllocationStatus;
import com.welitoncardozo.bicycleallocation.models.BicycleAllocationEntity;
import com.welitoncardozo.bicycleallocation.models.BicycleAllocationHistoricEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
@Builder
@Getter
public class BicycleAllocationDto {
    private Bicycle bicycle;
    private Client client;
    private AllocationStatus status;
    private LocalDateTime date;

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    static class Bicycle {
        private Long id;
        private String name;
    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    static class Client {
        private Long id;
        private String name;
    }

    public static BicycleAllocationDto from(final BicycleAllocationEntity bicycleAllocation) {
        return BicycleAllocationDto.builder()
                .bicycle(new Bicycle(bicycleAllocation.getBicycleId(), bicycleAllocation.getBicycleName()))
                .client(new Client(bicycleAllocation.getClientId(), bicycleAllocation.getClientName()))
                .date(bicycleAllocation.getDate())
                .build();
    }

    public static BicycleAllocationDto from(final BicycleAllocationHistoricEntity bicycleAllocationHistoric) {
        final BicycleAllocationEntity bicycleAllocation = bicycleAllocationHistoric.getBicycleAllocation();
        return BicycleAllocationDto.builder()
                .bicycle(new Bicycle(bicycleAllocation.getBicycleId(), bicycleAllocation.getBicycleName()))
                .client(new Client(bicycleAllocation.getClientId(), bicycleAllocation.getClientName()))
                .status(bicycleAllocationHistoric.getStatus())
                .date(bicycleAllocationHistoric.getDate())
                .build();
    }
}
