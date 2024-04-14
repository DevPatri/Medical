package com.patricio.citas.controllers;

import com.patricio.citas.DTO.DiagnosticoDTO;
import com.patricio.citas.service.DiagnosticoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/diagnostico")
public class DiagnosticoController {

    @Autowired
    private DiagnosticoServices diagnosticoServices;

    @GetMapping
    public List<DiagnosticoDTO> listaDiagnosticos() { return this.diagnosticoServices.getDiagnosticos();}

    @GetMapping(path = "/{id}")
    public DiagnosticoDTO getDiagnostico(@PathVariable Long id) { return diagnosticoServices.getDiagnostico(id);}

    @PostMapping
    public DiagnosticoDTO saveDiagnostico(@RequestBody DiagnosticoDTO diagnosticoDTO) {
        return this.diagnosticoServices.saveDiagnostico(diagnosticoDTO);
    }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteDiagnostico(@PathVariable Long id) {return diagnosticoServices.deleteDiagnostico(id);}

    @PutMapping(path = "/{id}")
    public DiagnosticoDTO updateDiagnosticoById(@PathVariable Long id, @RequestBody DiagnosticoDTO request) {
        return this.diagnosticoServices.updateDiagnosticoById(id,request);
    }

}

