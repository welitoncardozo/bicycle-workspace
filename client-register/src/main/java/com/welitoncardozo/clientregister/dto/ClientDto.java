package com.welitoncardozo.clientregister.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
	@NotBlank private String name;
	@NotBlank private String Cpf;
}
