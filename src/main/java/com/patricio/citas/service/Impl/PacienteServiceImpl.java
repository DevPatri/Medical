package com.patricio.citas.service.Impl;

import com.patricio.citas.DTO.PacienteDTO;
import com.patricio.citas.entity.Paciente;
import com.patricio.citas.mapper.PacienteMapper;
import com.patricio.citas.repository.IPacienteRepository;
import com.patricio.citas.service.PacienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteServiceImpl implements PacienteServices {
    @Autowired
    IPacienteRepository pacienteRepository;
    @Autowired
    PacienteMapper pacienteMapper;

    @Override
    public List<PacienteDTO> getPacientes(){
        List<Paciente> pacientes = pacienteRepository.findAll();
        if(!pacientes.isEmpty()) {
            return pacienteMapper.toGetDTOList(pacientes);
        } else {
            return null;
        }
    }

    @Override
    public PacienteDTO getPaciente(String NSS) {
        Optional<Paciente> paciente = pacienteRepository.findById(NSS);
        return paciente.map(value -> pacienteMapper.toGetDTO(value)).orElse(null);
    }


    @Override
    public PacienteDTO savePaciente(PacienteDTO pacienteDTO){

        Paciente paciente = this.pacienteMapper.toGetPaciente(pacienteDTO);
        paciente = pacienteRepository.save(paciente);
        return this.pacienteMapper.toGetDTO(paciente);
    }

    @Override
    public Boolean deletePaciente(String NSS){
        try {
            pacienteRepository.deleteById(NSS);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public PacienteDTO updatePacienteById(String NSS, PacienteDTO request) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(NSS);

        if (pacienteOptional.isPresent()){
            Paciente paciente = pacienteOptional.get();

            paciente.setNSS(NSS);
            if (request.getNombre() != null) paciente.setNombre(request.getNombre());
            if (request.getApellidos() != null) paciente.setApellidos(request.getApellidos());
            if(request.getUsuario() != null) paciente.setUsuario(request.getUsuario());
            //if(request.getClave() != null) paciente.setClave(request.getClave());
            if(request.getDireccion() != null) paciente.setDireccion(request.getDireccion());
            if(request.getTelefono() != null) paciente.setTelefono(request.getTelefono());
            if(request.getNumTarjeta() != null) paciente.setNumTarjeta(request.getNumTarjeta());

            pacienteRepository.save(paciente);
            return pacienteMapper.toGetDTO(paciente);

        } else {
            return null;
        }
    }
}
