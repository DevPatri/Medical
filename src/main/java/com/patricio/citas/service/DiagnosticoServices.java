package com.patricio.citas.service;

import com.patricio.citas.DTO.CitaDTO;
import com.patricio.citas.DTO.DiagnosticoDTO;

import java.util.List;

public interface DiagnosticoServices {

    List<DiagnosticoDTO> getDiagnosticos();

    DiagnosticoDTO getDiagnostico(Long id);

    DiagnosticoDTO saveDiagnostico(DiagnosticoDTO diagnostico);

    Boolean deleteDiagnostico(Long id);

    DiagnosticoDTO updateDiagnosticoById(Long id, DiagnosticoDTO request);
}
