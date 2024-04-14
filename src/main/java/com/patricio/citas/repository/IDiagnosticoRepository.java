package com.patricio.citas.repository;

import com.patricio.citas.entity.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiagnosticoRepository extends JpaRepository<Diagnostico, Long> {
}
