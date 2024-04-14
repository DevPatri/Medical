package com.patricio.citas.DTO;

import com.patricio.citas.entity.Diagnostico;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CitaDTO {
    private Long id;
    private Date fechaHora;
    private String motivoCita;
    private int attribute11;
    private DiagnosticoDTO diagnostico;
    private String medicoNumColegiado;
    private String pacienteNSS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivoCita() {
        return motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public int getAttribute11() {
        return attribute11;
    }

    public void setAttribute11(int attribute11) {
        this.attribute11 = attribute11;
    }

    public DiagnosticoDTO getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(DiagnosticoDTO diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getMedicoNumColegiado() {
        return medicoNumColegiado;
    }

    public void setMedicoNumColegiado(String medicoNumColegiado) {
        this.medicoNumColegiado = medicoNumColegiado;
    }

    public String getPacienteNSS() {
        return pacienteNSS;
    }

    public void setPacienteNSS(String pacienteNSS) {
        this.pacienteNSS = pacienteNSS;
    }
}
