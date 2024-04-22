package com.patricio.citas.controllers;

import com.patricio.citas.DTO.CitaDTO;
import com.patricio.citas.service.CitaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") //permiso para poder acceder a la API desde el front en modo desarrollo.
@RequestMapping("/cita")
public class CitaController {

    @Autowired
    private CitaServices citaServices;

    @GetMapping
    public List<CitaDTO> listaCitas(){
        return this.citaServices.getCitas();
    }

    @GetMapping(path = "/{id}")
    public CitaDTO getCita(@PathVariable Long id){
        return this.citaServices.getCita(id);
    }

    @PostMapping
    public CitaDTO saveCita(@RequestBody CitaDTO citaDTO){
        return this.citaServices.saveCita(citaDTO);
    }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteCita(@PathVariable Long id){
        return this.citaServices.deleteCita(id);
    }

    @PutMapping(path = "/{id}")
    public CitaDTO updateCita(@PathVariable Long id, @RequestBody CitaDTO request){
        return this.citaServices.updateCitaById(id,request);
    }
}
