package com.wild.Wild.Circus.repository;

import com.wild.Wild.Circus.entity.Artiste;
import com.wild.Wild.Circus.entity.Spectacle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpectacleRepository extends JpaRepository<Spectacle, Long>{

        @Query("SELECT a FROM Spectacle a WHERE ville LIKE %:ville% OR ville LIKE %:ville% ")
        public List<Spectacle> findByVille(@Param("ville")String ville);

        List<Spectacle> findTop3ByOrderByName();

}
