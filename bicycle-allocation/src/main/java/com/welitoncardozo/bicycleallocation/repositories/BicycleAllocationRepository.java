package com.welitoncardozo.bicycleallocation.repositories;

import com.welitoncardozo.bicycleallocation.models.BicycleAllocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Transactional(readOnly = true)
@Repository
public interface BicycleAllocationRepository extends JpaRepository<BicycleAllocationEntity, UUID>, JpaSpecificationExecutor<BicycleAllocationEntity> {
    Optional<BicycleAllocationEntity> findByBicycleIdAndClientId(final Long bicycle, final Long client);
}
