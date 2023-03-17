package com.welitoncardozo.bicycleregister.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "bicycle")
public class Bicycle {
	@Id
	@SequenceGenerator(name = "bicycle_id_seq", sequenceName = "bicycle_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bicycle_id_seq")
	private Long id;
	@NotNull private String name;
	@NotNull @ManyToOne private Brand brand;
	@NotNull private Boolean rented;
}