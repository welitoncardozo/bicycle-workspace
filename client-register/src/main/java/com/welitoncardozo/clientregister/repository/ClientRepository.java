package com.welitoncardozo.clientregister.repository;

import com.welitoncardozo.clientregister.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}