package com.patricio.citas.controllers;

import com.patricio.citas.DTO.MedicoDTO;
import com.patricio.citas.service.MedicoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") //permiso para poder acceder a la API desde el front en modo desarrollo.
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoServices medicoServices;

    //EndPoint por GET para traer la lista de todos los pacientes que hay en la bbdd.
    @GetMapping
    public List<MedicoDTO> getMedicos() {
        return this.medicoServices.getMedicos();
    }

    //EndPoint por GET con parámetro para traer un solo paciente por Id(NSS).
    @GetMapping(path = "/{numColegiado}")
    public MedicoDTO getMedico(@PathVariable String numColegiado) {
        return this.medicoServices.getMedico(numColegiado);
    }

    //EndPoint por POST para guardar un paciente en la bbdd.
    @PostMapping
    public MedicoDTO saveMedico(@RequestBody MedicoDTO medicoDTO) {
        return this.medicoServices.saveMedico(medicoDTO);
    }

    //EndPoint por DELETE con parámetro para eliminar un paciente de la bbdd por medio del NSS.
    @DeleteMapping(path = "/{numColegiado}")
    public Boolean deleteMedico(@PathVariable String numColegiado) {
        return this.medicoServices.deleteMedico(numColegiado);
    }
    @PutMapping(path = "/{numColegiado}")
    public MedicoDTO updateMedicoById(@PathVariable String numColegiado, @RequestBody MedicoDTO request) {
        return this.medicoServices.updateMedicoById(numColegiado, request);
    }
}
