package com.welitoncardozo.bicycleallocation.models;

import com.welitoncardozo.bicycleallocation.dtos.BicycleAllocationInput;
import com.welitoncardozo.bicycleallocation.enums.AllocationStatus;
import com.welitoncardozo.bicycleallocation.exceptions.BicycleAllocationInvalidException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "bicycle_allocation")
public class BicycleAllocationEntity {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column
    private UUID id;

    @NotNull
    @Column(name = "bicycle_id")
    private Long bicycleId;

    @NotBlank
    @Column(name = "bicycle_name")
    private String bicycleName;

    @NotNull
    @Column(name = "client_id")
    private Long clientId;

    @NotBlank
    @Column(name = "client_name")
    private String clientName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column
    private AllocationStatus status;

    @Column
    private LocalDateTime date;

    public BicycleAllocationEntity update(final BicycleAllocationInput input) {
        if (status.equals(input.getStatus())) {
            switch (status) {
                case RENTED -> throw new BicycleAllocationInvalidException("Bicicleta já está alugada!");
                case AVAILABLE -> throw new BicycleAllocationInvalidException("Bicicleta já está disponível!");
                default -> throw new BicycleAllocationInvalidException("Status inválido!");
            }
        }

        bicycleName = input.getBicycle().getName();
        clientName = input.getClient().getName();
        status = input.getStatus();
        date = LocalDateTime.now();
        return this;
    }

    public static BicycleAllocationEntity from(final BicycleAllocationInput input) {
        return BicycleAllocationEntity.builder()
                .bicycleId(input.getBicycle().getId())
                .bicycleName(input.getBicycle().getName())
                .clientId(input.getClient().getId())
                .clientName(input.getClient().getName())
                .status(input.getStatus())
                .date(LocalDateTime.now())
                .build();
    }
}
