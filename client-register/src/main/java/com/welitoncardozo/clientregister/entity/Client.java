package com.welitoncardozo.clientregister.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "client")
public class Client {
	@Id
	@SequenceGenerator(name = "client_id_seq", sequenceName = "client_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_id_seq")
	private Long id;
	@NotNull private String name;
	@NotNull private String cpf;
}