package com.patricio.citas.service;

import com.patricio.citas.DTO.CitaDTO;

import java.text.ParseException;
import java.util.List;

public interface CitaServices {

    List<CitaDTO> getCitas();

    CitaDTO getCita(Long id);

    CitaDTO saveCita(CitaDTO cita);

    Boolean deleteCita(Long id);

    CitaDTO updateCitaById(Long id, CitaDTO request);
}
