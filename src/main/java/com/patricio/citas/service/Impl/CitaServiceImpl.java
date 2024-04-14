package com.patricio.citas.service.Impl;

import com.patricio.citas.DTO.CitaDTO;
import com.patricio.citas.entity.Cita;
import com.patricio.citas.entity.Diagnostico;
import com.patricio.citas.entity.Medico;
import com.patricio.citas.entity.Paciente;
import com.patricio.citas.mapper.CitaMapper;
import com.patricio.citas.mapper.DiagnosticoMapper;
import com.patricio.citas.repository.ICitaRepository;
import com.patricio.citas.repository.IDiagnosticoRepository;
import com.patricio.citas.repository.IMedicoRepository;
import com.patricio.citas.repository.IPacienteRepository;
import com.patricio.citas.service.CitaServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CitaServiceImpl implements CitaServices {

    @Autowired
    ICitaRepository citaRepository;
    @Autowired
    IDiagnosticoRepository diagnosticoRepository;
    @Autowired
    CitaMapper citaMapper;
    @Autowired
    DiagnosticoMapper diagnosticoMapper;
    @Autowired
    IMedicoRepository medicoRepository;
    @Autowired
    IPacienteRepository pacienteRepository;

    @Transactional
    @Override
    public List<CitaDTO> getCitas() {
        List<Cita> citas = citaRepository.findAll();
        if(!citas.isEmpty()){
            return citas.stream()
                    .map((Cita cita) -> citaMapper.ToCitaDTO(cita))
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }
    @Transactional
    @Override
    public CitaDTO getCita(Long id) {
        Optional<Cita> cita = citaRepository.findById(id);
        return cita.map(value->citaMapper.ToCitaDTO(value)).orElse(null);
    }

    @Override
    public CitaDTO saveCita(CitaDTO citaDTO) {
        Cita cita = this.citaMapper.ToCita(citaDTO);

        if(citaDTO.getMedicoNumColegiado() != null){
            Medico medico = medicoRepository.findById(citaDTO.getMedicoNumColegiado())
                    .orElseThrow(() -> new EntityNotFoundException("Medico con numColegiado no encontrado" + citaDTO.getMedicoNumColegiado()));
            cita.setMedico(medico);
        }
        if(citaDTO.getPacienteNSS() != null){
            Paciente paciente = pacienteRepository.findById(citaDTO.getPacienteNSS())
                    .orElseThrow(() -> new EntityNotFoundException("Paciente con NSS no encontrado" + citaDTO.getPacienteNSS()));
            cita.setPaciente(paciente);
        }

        Diagnostico diagnostico;
        if(citaDTO.getDiagnostico() == null){
            diagnostico = diagnosticoMapper.ToDiagnostico(citaDTO.getDiagnostico());
        } else {
            diagnostico = new Diagnostico();
        }
        cita.setDiagnostico(diagnostico);

        citaRepository.save(cita);
        return this.citaMapper.ToCitaDTO(cita);
    }

    @Override
    public Boolean deleteCita(Long id) {
        try {
            citaRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public CitaDTO updateCitaById(Long id, CitaDTO request) {
        Optional<Cita> citaOptional = citaRepository.findById(id);
        Diagnostico newDiagno = diagnosticoMapper.ToDiagnostico(request.getDiagnostico());
        if (citaOptional.isPresent()) {
            Cita cita = citaOptional.get();

            if(request.getMotivoCita() != null) cita.setMotivoCita(request.getMotivoCita());
            if(request.getDiagnostico() != null) cita.setDiagnostico(newDiagno);
            if(request.getAttribute11() != 0) cita.setAttribute11(request.getAttribute11());
            cita = citaRepository.save(cita);
            return this.citaMapper.ToCitaDTO(cita);
        } else {
            return null;
        }

    }
}
