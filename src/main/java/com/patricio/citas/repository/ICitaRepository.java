package com.patricio.citas.repository;

import com.patricio.citas.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICitaRepository extends JpaRepository<Cita, Long> {
}
