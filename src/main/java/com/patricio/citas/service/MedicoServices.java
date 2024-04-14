package com.patricio.citas.service;

import com.patricio.citas.DTO.MedicoDTO;
import java.util.List;

public interface MedicoServices {

    List<MedicoDTO> getMedicos();

    MedicoDTO getMedico(String numColegiado);

    MedicoDTO saveMedico(MedicoDTO medicoDTO);

    Boolean deleteMedico(String numColegiado);

    MedicoDTO updateMedicoById(String numColegiado, MedicoDTO request);
}
