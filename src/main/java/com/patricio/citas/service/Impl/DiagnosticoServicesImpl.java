package com.patricio.citas.service.Impl;

import com.patricio.citas.DTO.DiagnosticoDTO;
import com.patricio.citas.entity.Cita;
import com.patricio.citas.entity.Diagnostico;
import com.patricio.citas.mapper.DiagnosticoMapper;
import com.patricio.citas.repository.ICitaRepository;
import com.patricio.citas.repository.IDiagnosticoRepository;
import com.patricio.citas.service.DiagnosticoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DiagnosticoServicesImpl implements DiagnosticoServices {

    @Autowired
    IDiagnosticoRepository diagnosticoRepository;
    @Autowired
    DiagnosticoMapper diagnosticoMapper;
    @Autowired
    ICitaRepository citaRepository;

    @Override
    public List<DiagnosticoDTO> getDiagnosticos() {
        List<Diagnostico> diagnosticos = diagnosticoRepository.findAll();
        if(!diagnosticos.isEmpty()){
            return diagnosticos.stream()
                    .map(diagnosticoMapper::ToDiagnosticoDTO)
                    .collect(Collectors.toList());
        }else{
            return null;
        }
    }

    @Override
    public DiagnosticoDTO getDiagnostico(Long id) {
        Optional<Diagnostico> diagnostico = diagnosticoRepository.findById(id);
        return diagnostico.map(value -> diagnosticoMapper.ToDiagnosticoDTO(value)).orElse(null);
    }

    @Override
    public DiagnosticoDTO saveDiagnostico(DiagnosticoDTO diagnosticoDTO) {
        Diagnostico diagnostico = this.diagnosticoMapper.ToDiagnostico(diagnosticoDTO);
        diagnostico = diagnosticoRepository.save(diagnostico);
        return this.diagnosticoMapper.ToDiagnosticoDTO(diagnostico);
    }

    @Override
    public Boolean deleteDiagnostico(Long id) {
        try {
            diagnosticoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public DiagnosticoDTO updateDiagnosticoById(Long id, DiagnosticoDTO request) {
        Optional<Diagnostico> diagnosticoOptional = diagnosticoRepository.findById(id);

        if (diagnosticoOptional.isPresent()) {
            Diagnostico diagnostico = diagnosticoOptional.get();

            if (request.getEnfermedad() != null) diagnostico.setEnfermedad(request.getEnfermedad());
            if (request.getValoracionEspecialista() != null)
                diagnostico.setValoracionEspecialista(request.getValoracionEspecialista());
            Optional<Cita> citaOptional = citaRepository.findById(request.getIdCita());
            if (citaOptional.isPresent() && request.getIdCita() != null) diagnostico.setCita(citaOptional.get());

            diagnostico = diagnosticoRepository.save(diagnostico);
            return diagnosticoMapper.ToDiagnosticoDTO(diagnostico);
        } else {
            return null;
        }
    }
}
