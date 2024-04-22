package com.patricio.citas;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.patricio.citas.DTO.PacienteDTO;
import com.patricio.citas.entity.Cita;
import com.patricio.citas.entity.Paciente;
import com.patricio.citas.repository.ICitaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CitasApplicationTests {

	@Autowired
	private ICitaRepository citaRepository;

	@Test
	void contextLoads() {
	}
	@Test
	public void testPacienteDTOSerialization() throws Exception {

		Optional<Cita> citaOp = citaRepository.findById(29L);

		if(citaOp.isPresent()){
			Cita cita = citaOp.get();

			System.out.println(cita.getMotivoCita());
			System.out.println(cita.getFechaHora());
			System.out.println(cita.getAttribute11());
			System.out.println(cita.getMedico().getNombre());
			System.out.println(cita.getDiagnostico().getEnfermedad());
			System.out.println(cita.getPaciente().getNombre());

		}

	}
}
