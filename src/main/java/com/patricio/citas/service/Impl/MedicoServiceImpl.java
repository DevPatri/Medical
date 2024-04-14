package com.patricio.citas.service.Impl;

import com.patricio.citas.DTO.MedicoDTO;
import com.patricio.citas.entity.Medico;
import com.patricio.citas.mapper.MedicoMapper;
import com.patricio.citas.repository.IMedicoRepository;
import com.patricio.citas.service.MedicoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoServiceImpl implements MedicoServices {

    @Autowired
    IMedicoRepository medicoRepository;
    @Autowired
    MedicoMapper medicoMapper;

    @Override
    public List<MedicoDTO> getMedicos() {
        List<Medico> medicos = medicoRepository.findAll();
        if(!medicos.isEmpty()){
            return (List<MedicoDTO>) medicos.stream()
                    .map(medicoMapper::toMedicoDTO)
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @Override
    public MedicoDTO getMedico(String numColegiado) {
        Optional<Medico> medico = medicoRepository.findById(numColegiado);
        return medico.map(value -> medicoMapper.toMedicoDTO(value)).orElse(null);
    }

    @Override
    public MedicoDTO saveMedico(MedicoDTO medicoDTO) {

        Medico medico = this.medicoMapper.toMedico(medicoDTO);
        medico.setNumColegiado(medicoDTO.getNumColegiado());
        medico = medicoRepository.save(medico);
        return this.medicoMapper.toMedicoDTO(medico);
    }

    @Override
    public Boolean deleteMedico(String numColegiado) {
        try {
            medicoRepository.deleteById(numColegiado);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public MedicoDTO updateMedicoById(String numColegiado, MedicoDTO request) {
        Optional<Medico> medicoOptional = medicoRepository.findById(numColegiado);

        if(medicoOptional.isPresent()){
            Medico medico = medicoOptional.get();

            medico.setNumColegiado(request.getNumColegiado());
            if(request.getNombre() != null) medico.setNombre(request.getNombre());
            if(request.getApellidos() != null) medico.setApellidos(request.getApellidos());
            if(request.getUsuario() != null) medico.setUsuario(request.getUsuario());
            //if(request.getClave() != null) medico.setClave(request.getClave());

            medico = medicoRepository.save(medico);
            return medicoMapper.toMedicoDTO(medico);
        }else{
            return null;
        }
    }
}
