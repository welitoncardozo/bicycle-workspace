package com.welitoncardozo.bicycleregister.service;

import com.welitoncardozo.bicycleregister.dto.BicycleDto;
import com.welitoncardozo.bicycleregister.entity.Bicycle;
import com.welitoncardozo.bicycleregister.entity.Brand;
import com.welitoncardozo.bicycleregister.repository.BicycleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BicycleService {
	private final BicycleRepository repository;
	private final BrandService brandService;

	public void save(BicycleDto bicycleDto) {
		if (bicycleDto.getBrandId() == null) throw new EntityNotFoundException("Brand not found!");
		Brand brand = brandService.findById(bicycleDto.getBrandId());

		Bicycle bicycle = new Bicycle();
		bicycle.setName(bicycleDto.getName());
		bicycle.setBrand(brand);
		bicycle.setRented(false);

		repository.save(bicycle);
	}

	public Bicycle findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Bicycle not found!"));
	}

	public List<Bicycle> findAll() {
		return repository.findAll();
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public void rent(Long id, Boolean rented) {
		Bicycle bicycle = findById(id);
		bicycle.setRented(rented);
		repository.save(bicycle);
	}
}
