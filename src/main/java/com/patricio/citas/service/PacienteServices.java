package com.patricio.citas.service;

import com.patricio.citas.DTO.PacienteDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PacienteServices {

    List<PacienteDTO> getPacientes();

    PacienteDTO getPaciente(String NSS);

    PacienteDTO savePaciente(PacienteDTO pacienteDTO);

    Boolean deletePaciente(String NSS);

    PacienteDTO updatePacienteById(String NSS, PacienteDTO request);
}
