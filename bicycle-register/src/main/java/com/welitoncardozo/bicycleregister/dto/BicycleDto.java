package com.welitoncardozo.bicycleregister.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BicycleDto {
	@NotBlank private String name;
	@NotBlank private Long brandId;
}
