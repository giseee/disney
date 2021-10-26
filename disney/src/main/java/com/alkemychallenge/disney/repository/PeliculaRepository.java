package com.alkemychallenge.disney.repository;

import com.alkemychallenge.disney.entities.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PeliculaRepository extends JpaRepository<PeliculaEntity,Long> {
}
