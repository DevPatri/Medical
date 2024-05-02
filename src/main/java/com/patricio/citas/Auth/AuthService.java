package com.patricio.citas.Auth;

import com.patricio.citas.Jwt.JwtService;
import com.patricio.citas.entity.Medico;
import com.patricio.citas.repository.IMedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final IMedicoRepository medicoRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getClave()));
        UserDetails user = medicoRepository.findByUsuario(request.getUsuario())
                .orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        Medico medico = new Medico(
                request.nombre,
                request.apellidos,
                request.numColegiado,
                request.usuario,
                passwordEncoder.encode(request.clave)
        );
        medicoRepository.save(medico);

        return AuthResponse.builder()
                .token(jwtService.getToken(medico))
                .build();
    }
}
