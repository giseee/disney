package com.alkemychallenge.disney.repository;

import com.alkemychallenge.disney.entities.GeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<GeneroEntity,Long> {
}
