package com.welitoncardozo.bicycleregister.service;

import com.welitoncardozo.bicycleregister.entity.Brand;
import com.welitoncardozo.bicycleregister.repository.BrandRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandService {
	private final BrandRepository repository;

	Brand findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Brand not found!"));
	}
}
