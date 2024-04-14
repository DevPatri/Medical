package com.patricio.citas.mapper;

import com.patricio.citas.DTO.CitaDTO;
import com.patricio.citas.entity.Cita;
import com.patricio.citas.entity.Medico;
import com.patricio.citas.entity.Paciente;
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

    @Mapping(target = "pacienteNSS", source = "paciente.NSS"/*, qualifiedByName = "mapToPacienteDTO"*/)
    @Mapping(target = "medicoNumColegiado", source = "medico.numColegiado"/*, qualifiedByName = "mapToMedicoDTO"*/)
    CitaDTO ToCitaDTO(Cita cita);


//    @Named("mapToPacienteDTO")
//    default String mapToPacienteDTO(Paciente paciente) {
//        return paciente.getNSS();
//    }
//    @Named("mapToMedicoDTO")
//    default String mapToMedicoDTO(Medico medico) {
//        return medico.getNumColegiado();
//    }

    @InheritInverseConfiguration
    Cita ToCita(CitaDTO citaDTO);

//    @Named("mapToMedico")
//    default Medico mapToMedico(String numColegiado) {
//        if (numColegiado == null) {
//            return null;
//        }
//        Medico medico = new Medico();
//        medico.setNumColegiado(numColegiado);
//        return medico;
//    }
//
//    @Named("mapToPaciente")
//    default Paciente mapToPaciente(String NSS) {
//        if (NSS == null) {
//            return null;
//        }
//        Paciente paciente = new Paciente();
//        paciente.setNSS(NSS);
//        return paciente;
//    }

    List<CitaDTO> toCitaDTOs(List<Cita> citas);
    List<Cita> toCitas(List<CitaDTO> citasDTO);


}
