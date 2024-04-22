package com.patricio.citas.mapper;

import com.patricio.citas.DTO.CitaDTO;
import com.patricio.citas.DTO.DiagnosticoDTO;
import com.patricio.citas.entity.Cita;
import com.patricio.citas.entity.Diagnostico;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;



@Mapper(componentModel = "spring",
        uses = {
                DiagnosticoMapper.class,
                MedicoMapper.class,
                PacienteMapper.class})
public interface CitaMapper {


    @Mapping(target = "pacienteNSS", source = "paciente.NSS")
    @Mapping(target = "medicoNumColegiado", source = "medico.numColegiado")
    CitaDTO ToCitaDTO(Cita cita);

    @InheritInverseConfiguration
    Cita ToCita(CitaDTO citaDTO);

    List<CitaDTO> toCitaDTOs(List<Cita> citas);
    List<Cita> toCitas(List<CitaDTO> citasDTO);

}
