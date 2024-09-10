package com.fie.apiturismo.vega.Controllers;

import com.fie.apiturismo.vega.Entities.UsuarioEntity;
import com.fie.apiturismo.vega.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<UsuarioEntity> registrar(@RequestBody UsuarioEntity usuario) {
        UsuarioEntity nuevoUsuario = usuarioService.registrarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    // Inicio de sesión - Recibe un JSON con email y contraseña
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioEntity usuario) {
        // Validamos las credenciales del usuario utilizando el email y la contraseña
        UsuarioEntity usuarioValidado = usuarioService.validarCredenciales(usuario.getEmail(), usuario.getContrasena());
        if (usuarioValidado != null) {
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } else {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
    }
}

