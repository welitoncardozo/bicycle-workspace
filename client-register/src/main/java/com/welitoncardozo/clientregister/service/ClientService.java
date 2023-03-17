package com.welitoncardozo.clientregister.service;

import com.welitoncardozo.clientregister.dto.ClientDto;
import com.welitoncardozo.clientregister.entity.Client;
import com.welitoncardozo.clientregister.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
	private final ClientRepository repository;

	public ClientService(ClientRepository repository) {
		this.repository = repository;
	}

	public void save(ClientDto clientDto, Long id) {
		Client client = new Client();
		if (id != null) client.setId(id);
		client.setName(clientDto.getName());
		client.setCpf(clientDto.getCpf());
		repository.save(client);
	}

	public Client findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found!"));
	}

	public List<Client> findAll() {
		return repository.findAll();
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
