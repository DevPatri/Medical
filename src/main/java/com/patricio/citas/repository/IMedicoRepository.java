package com.patricio.citas.repository;

import com.patricio.citas.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IMedicoRepository extends JpaRepository<Medico, String> {
    Optional<Medico> findByUsuario(String nombre);
}
