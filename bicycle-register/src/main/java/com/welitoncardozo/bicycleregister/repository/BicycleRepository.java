package com.welitoncardozo.bicycleregister.repository;

import com.welitoncardozo.bicycleregister.entity.Bicycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BicycleRepository extends JpaRepository<Bicycle, Long> {

}