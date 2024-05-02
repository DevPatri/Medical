package com.patricio.citas.controllers;

import com.patricio.citas.DTO.PacienteDTO;
import com.patricio.citas.service.PacienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") //permiso para poder acceder a la API desde el front en modo desarrollo.
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteServices pacienteServices;

    //EndPoint por GET para traer la lista de todos los pacientes que hay en la bbdd.
    @GetMapping
    public List<PacienteDTO> getPacientes(){
        return this.pacienteServices.getPacientes();
    }

    //EndPoint por GET con parámetro para traer un solo paciente por Id(NSS).
    @GetMapping(path = "/{NSS}")
    public PacienteDTO getPaciente(@PathVariable String NSS){
        return pacienteServices.getPaciente(NSS);
    }

    //EndPoint por POST para guardar un paciente en la bbdd.
    @PostMapping
    public PacienteDTO savePaciente(@RequestBody PacienteDTO pacienteDTO){
        return this.pacienteServices.savePaciente(pacienteDTO);
    }

    //EndPoint por DELETE con parámetro para eliminar un paciente de la bbdd por medio del NSS.
    @DeleteMapping(path = "/{NSS}")
    public Boolean deletePaciente(@PathVariable String NSS){
        return this.pacienteServices.deletePaciente(NSS);
    }

    //EndPoint por PUT con parámetro para actualizar un paciente de la bbdd por medio del NSS.
    @PutMapping(path = "/{NSS}")
    public PacienteDTO updatePacienteById(@PathVariable String NSS,@RequestBody PacienteDTO request){
        return this.pacienteServices.updatePacienteById(NSS,  request);
    }
}
