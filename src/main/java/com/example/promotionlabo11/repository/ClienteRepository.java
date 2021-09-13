package com.example.promotionlabo11.repository;

import com.example.promotionlabo11.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
