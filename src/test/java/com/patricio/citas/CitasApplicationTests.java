package com.patricio.citas;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.patricio.citas.DTO.PacienteDTO;
import com.patricio.citas.entity.Paciente;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CitasApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void testPacienteDTOSerialization() throws Exception {
		PacienteDTO paciente = new PacienteDTO();
		paciente.setNombre("Juan");
		paciente.setApellidos("Perez");
		paciente.setUsuario("juanpe");
		paciente.setClave("235klh5l234");
		paciente.setNSS("123456789");
		paciente.setNumTarjeta("987654321");
		paciente.setTelefono("1234567890");
		paciente.setDireccion("Calle Falsa 123");

//		ObjectMapper mapper = new ObjectMapper();
//		String jsonResult = mapper.writeValueAsString(paciente);

		// Verifica que el JSON contiene las claves esperadas
//		assertTrue(jsonResult.contains("nombre"));
//		assertTrue(jsonResult.contains("apellidos"));
//		assertTrue(jsonResult.contains("NSS"));
//		assertTrue(jsonResult.contains("numTarjeta"));
//		assertTrue(jsonResult.contains("telefono"));
//		assertTrue(jsonResult.contains("direccion"));
		System.out.println(paciente);
	}
}
