// Darren Evan Nathanael (825240062)
package com.example.demospringboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demospringboot.entity.Kiriman;

@Repository
public interface KirimanRepository extends JpaRepository<Kiriman, Long> {
  
    Optional<Kiriman> findByNomorResi(String nomorResi);
    List<Kiriman> findByStatus(String status);
}