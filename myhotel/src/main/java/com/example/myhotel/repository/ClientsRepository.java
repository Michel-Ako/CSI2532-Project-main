package com.example.myhotel.repository;

import com.example.myhotel.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Integer> {
    Optional<Clients> findByNomComplet(String nomComplet);
}
