package com.welitoncardozo.bicycleallocation.models;

import com.welitoncardozo.bicycleallocation.enums.AllocationStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
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
@Table(name = "bicycle_allocation_historic")
public class BicycleAllocationHistoricEntity {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column
    private UUID id;

    @Valid
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bicycle_allocation")
    private BicycleAllocationEntity bicycleAllocation;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column
    private AllocationStatus status;

    @Column
    private LocalDateTime date;

    public static BicycleAllocationHistoricEntity from(final BicycleAllocationEntity bicycleAllocation) {
        return BicycleAllocationHistoricEntity.builder()
                .bicycleAllocation(bicycleAllocation)
                .status(bicycleAllocation.getStatus())
                .date(LocalDateTime.now())
                .build();
    }
}
