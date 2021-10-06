package com.alkemychallenge.disney.repository;

import com.alkemychallenge.disney.entities.PersonajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends JpaRepository<PersonajeEntity,Long> {
}
