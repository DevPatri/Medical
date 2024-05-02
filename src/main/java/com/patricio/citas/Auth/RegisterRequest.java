package com.patricio.citas.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest
{
    String nombre;
    String apellidos;
    String numColegiado;
    String usuario;
    String clave;
}
