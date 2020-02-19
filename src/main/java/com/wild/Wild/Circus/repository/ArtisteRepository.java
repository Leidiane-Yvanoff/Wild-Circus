package com.wild.Wild.Circus.repository;

import com.wild.Wild.Circus.entity.Artiste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtisteRepository extends JpaRepository<Artiste, Long> {
    public Artiste findOneByName(String name);
}
