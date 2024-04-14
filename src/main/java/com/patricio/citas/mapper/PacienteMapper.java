package com.patricio.citas.mapper;

import com.patricio.citas.DTO.PacienteDTO;
import com.patricio.citas.entity.Paciente;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring", uses = {CitaMapper.class})
public interface PacienteMapper {

    @Mapping(target = "clave", ignore = true)
//    @Mapping(target = "citas", source = "citas")
//    @Mapping(target = "medicos", source = "medicos")
    PacienteDTO toGetDTO(Paciente paciente);

    @InheritInverseConfiguration
//    @Mapping(target = "citas", source = "citas")
//    @Mapping(target = "medicos", source = "medicos")
    Paciente toGetPaciente(PacienteDTO pacienteDTO);

    List<PacienteDTO> toGetDTOList(List<Paciente> pacientes);
    List<Paciente> toGetPacientesList(List<PacienteDTO> pacienteDTOs);


}

