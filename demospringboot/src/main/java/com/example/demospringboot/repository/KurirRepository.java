// Leticia Michelle Purba (8252401440)
package com.example.demospringboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demospringboot.entity.Kurir;

@Repository
public interface KurirRepository extends JpaRepository<Kurir, Long> {
    Optional<Kurir> findByIdKurir(String idKurir);
}
