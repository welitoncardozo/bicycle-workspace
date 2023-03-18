package com.welitoncardozo.bicycleallocation.repositories;

import com.welitoncardozo.bicycleallocation.models.BicycleAllocationHistoricEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional(readOnly = true)
@Repository
public interface BicycleAllocationHistoricRepository extends JpaRepository<BicycleAllocationHistoricEntity, UUID>, JpaSpecificationExecutor<BicycleAllocationHistoricEntity> {
}
