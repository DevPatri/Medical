package com.patricio.citas.mapper;

import com.patricio.citas.DTO.MedicoDTO;
import com.patricio.citas.entity.Medico;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring", uses = {CitaMapper.class, PacienteMapper.class})
public interface MedicoMapper {

    @Mapping(target = "clave", ignore = true)
//    @Mapping(target = "pacientes", source = "pacientes")
//    @Mapping(target = "citas", source = "citas")
    MedicoDTO toMedicoDTO(Medico medico);


    @InheritInverseConfiguration
//    @Mapping(target = "pacientes", source = "pacientes")
    Medico toMedico(MedicoDTO medicoDTO);

    List<MedicoDTO> toMedicoDTO(List<Medico> medicos);
    List<Medico> toMedicos(List<MedicoDTO> medicoDTOs);


}
