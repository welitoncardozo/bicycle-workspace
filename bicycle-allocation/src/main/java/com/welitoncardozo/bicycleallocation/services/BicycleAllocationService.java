package com.welitoncardozo.bicycleallocation.services;

import com.welitoncardozo.bicycleallocation.clients.BicycleRegisterHandler;
import com.welitoncardozo.bicycleallocation.dtos.BicycleAllocationInput;
import com.welitoncardozo.bicycleallocation.enums.AllocationStatus;
import com.welitoncardozo.bicycleallocation.models.BicycleAllocationEntity;
import com.welitoncardozo.bicycleallocation.models.BicycleAllocationHistoricEntity;
import com.welitoncardozo.bicycleallocation.repositories.BicycleAllocationHistoricRepository;
import com.welitoncardozo.bicycleallocation.repositories.BicycleAllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BicycleAllocationService {
    @Autowired
    private BicycleAllocationRepository bicycleAllocationRepository;

    @Autowired
    private BicycleAllocationHistoricRepository bicycleAllocationHistoricRepository;

    @Autowired
    @Qualifier("bicycleRegisterMessageClient")
    private BicycleRegisterHandler bicycleRegisterHandler;

    @Transactional
    public void save(final BicycleAllocationInput input) {
        final var bicycleAllocation = bicycleAllocationRepository.findByBicycleIdAndClientId(input.getBicycle().getId(), input.getClient().getId())
                .map(it -> it.update(input))
                .map(bicycleAllocationRepository::save)
                .orElseGet(() -> bicycleAllocationRepository.save(BicycleAllocationEntity.from(input)));
        bicycleAllocationHistoricRepository.save(BicycleAllocationHistoricEntity.from(bicycleAllocation));
        publishEvent(bicycleAllocation);
    }

    private void publishEvent(final BicycleAllocationEntity bicycleAllocation) {
        if (bicycleAllocation.getStatus().isRented()) {
            bicycleRegisterHandler.rent(bicycleAllocation.getBicycleId());
            return;
        }

        bicycleRegisterHandler.giveItBack(bicycleAllocation.getBicycleId());
    }

    public List<BicycleAllocationEntity> findAll(final Long bicycle, final Long client) {
        final var bicycleAllocationFilter = BicycleAllocationEntity.builder()
                .bicycleId(bicycle)
                .clientId(client)
                .status(AllocationStatus.RENTED)
                .build();
        final var filter = Example.of(bicycleAllocationFilter);
        return bicycleAllocationRepository.findAll(filter);
    }

    public List<BicycleAllocationHistoricEntity> findAllHistoric(final Long bicycle, final Long client, final AllocationStatus status) {
        final var bicycleAllocationHistoricFilter = BicycleAllocationHistoricEntity.builder()
                .bicycleAllocation(BicycleAllocationEntity.builder()
                        .bicycleId(bicycle)
                        .clientId(client)
                        .build()
                )
                .status(status)
                .build();
        final var filter = Example.of(bicycleAllocationHistoricFilter);
        return bicycleAllocationHistoricRepository.findAll(filter);
    }
}
