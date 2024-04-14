package com.patricio.citas.mapper;

import com.patricio.citas.DTO.DiagnosticoDTO;
import com.patricio.citas.entity.Cita;
import com.patricio.citas.entity.Diagnostico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CitaMapper.class})
public interface DiagnosticoMapper {

    @Mapping(target = "idCita", source = "cita.id")
    DiagnosticoDTO ToDiagnosticoDTO(Diagnostico diagnostico);

    @Mapping(target = "cita", source = "idCita")
    Diagnostico ToDiagnostico(DiagnosticoDTO diagnosticoDTO);

    default Cita map(Long id) {
        if (id == null) {
            return null;
        }
        Cita cita = new Cita();
        cita.setId(id);
        return cita;
    }
}
