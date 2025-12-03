// Leticia Michelle Purba (8252401440)
package com.example.demospringboot.repository; 

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demospringboot.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    
    Optional<Admin> findByUsername(String username);
}
