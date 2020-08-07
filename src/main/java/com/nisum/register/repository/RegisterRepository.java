package com.nisum.register.repository;


import com.nisum.register.repository.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<Client, Long> {

    @Query("SELECT t FROM Client t WHERE t.email = ?1 ")
    Client findByEmail(String email);
}
