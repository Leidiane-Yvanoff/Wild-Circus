package com.wild.Wild.Circus.repository;

import com.wild.Wild.Circus.entity.Artiste;
import com.wild.Wild.Circus.entity.Spectacle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtisteRepository extends JpaRepository<Artiste, Long> {
    @Query("SELECT a FROM Artiste a WHERE name LIKE %:name% OR name LIKE %:name% ")
    public List<Artiste> findByName(@Param("name")String name);

    List<Artiste> findTop3ByOrderByName();
}
