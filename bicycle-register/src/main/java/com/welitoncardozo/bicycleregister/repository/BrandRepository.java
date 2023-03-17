package com.welitoncardozo.bicycleregister.repository;

import com.welitoncardozo.bicycleregister.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {

}