package com.wild.Wild.Circus.repository;

import com.wild.Wild.Circus.entity.Spectacle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpectacleRepository extends JpaRepository<Spectacle, Long>{

        public Spectacle findOneByName(String name);
        public List<Spectacle> findByVille(String ville);


}
